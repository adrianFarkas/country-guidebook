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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
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
    public ResponseEntity signup(@RequestBody CountryGuideUser countryGuideUser, HttpServletResponse response) {
        countryGuideUser.setRoles(Collections.singletonList("ROLE_USER"));
        countryGuideUserDao.saveUserToRepository(countryGuideUser);

        String token = jwtTokenServices.createToken(countryGuideUser.getUserName(), Collections.singletonList("ROLE_USER"));

     //   Map<Object, Object> model = new HashMap<>();
       // model.put("token", token);
        Cookie cookie = new Cookie("token", token);

        response.addCookie(cookie);

        return ResponseEntity.ok("");

    }

    @PostMapping("/auth/login")
    public ResponseEntity signin(@RequestBody CountryGuideUser userData, HttpServletResponse response) {
        try {
            String username = userData.getUserName();
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, userData.getPassword()));
            List<String> roles = authentication.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            String token = jwtTokenServices.createToken(username, roles);
//            Map<Object, Object> model = new HashMap<>();
       //     model.put("username", username);
         //   model.put("roles", roles);
   //         model.put("token", token);
            Cookie cookie = new Cookie("token", token);

            response.addCookie(cookie);

            return ResponseEntity.ok("");
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
