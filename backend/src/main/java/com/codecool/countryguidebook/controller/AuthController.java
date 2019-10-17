package com.codecool.countryguidebook.controller;

import com.codecool.countryguidebook.dao.CountryGuideUserDao;
import com.codecool.countryguidebook.model.CountryGuideUser;
import com.codecool.countryguidebook.security.JwtTokenServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = {"http://127.0.0.1:3000","http://localhost:3000"} )
public class AuthController {

    @Autowired
    private CountryGuideUserDao countryGuideUserDao;

    private final AuthenticationManager authenticationManager;

    private final JwtTokenServices jwtTokenServices;

    public AuthController(AuthenticationManager authenticationManager, JwtTokenServices jwtTokenServices) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenServices = jwtTokenServices;
    }

    @PostMapping("/register")
    public ResponseEntity signup(@RequestBody CountryGuideUser countryGuideUser, HttpServletResponse response) {
        countryGuideUser.setRoles(Collections.singletonList("ROLE_USER"));

        String errorMessage = countryGuideUserDao.checkUsernameAndPasswordPersent(countryGuideUser.getUserName(), countryGuideUser.getEmail());
        if (errorMessage.length()>0) {
            return new ResponseEntity<>(errorMessage, HttpStatus.CREATED);
        }
        countryGuideUserDao.saveUserToRepository(countryGuideUser);
        String token = createToken(countryGuideUser, Collections.singletonList("ROLE_USER"));
        Cookie cookie = new Cookie("token", token);

        response.addCookie(cookie);

        return ResponseEntity.ok("");

    }

    @PostMapping("/login")
    public ResponseEntity signin(@RequestBody CountryGuideUser userData, HttpServletResponse response) {
        try {
            Cookie cookie = new Cookie("token", createToken(userData,null));
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
            return ResponseEntity.ok("");

        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    private String createToken(CountryGuideUser userData, List<String> roles){
        String username = userData.getUserName();
        if (roles==null) {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, userData.getPassword()));
            roles = authentication.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());
        }
        return jwtTokenServices.createToken(username, roles);
    }
}
