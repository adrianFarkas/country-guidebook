package com.codecool.countryguidebook.controller;

import com.codecool.countryguidebook.dao.CountryGuideUserDao;
import com.codecool.countryguidebook.model.CountryGuideUser;
import com.codecool.countryguidebook.security.JwtTokenServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class AuthController {

    @Autowired
    private CountryGuideUserDao countryGuideUserDao;

    private final AuthenticationManager authenticationManager;

    private final JwtTokenServices jwtTokenServices;

    public AuthController(AuthenticationManager authenticationManager, JwtTokenServices jwtTokenServices) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenServices = jwtTokenServices;
    }

    @PostMapping("/auth/signup")
    public CountryGuideUser filteredCountries(@RequestBody CountryGuideUser countryGuideUser) {
        countryGuideUser.setRoles(Collections.singletonList("ROLE_USER"));
        countryGuideUserDao.saveUserToRepository(countryGuideUser);
        return countryGuideUser;
    }

    @PostMapping("/auth/login")
    public ResponseEntity signin(@RequestBody CountryGuideUser userData) {
        try {
            String username = userData.getUserName();
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, userData.getPassword()));
            List<String> roles = authentication.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            String token = jwtTokenServices.createToken(username, roles);
            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("roles", roles);
            model.put("token", token);

            return ResponseEntity.ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @GetMapping("/auth/logout")
    public ResponseEntity logout(){
        Map<Object, Object> model = new HashMap<>();
        model.put("logout", "logout");
        return ResponseEntity.ok(model);
    }
}
