package com.codecool.countryguidebook.controller;

import com.codecool.countryguidebook.dao.CountryGuideUserDao;
import com.codecool.countryguidebook.model.CountryGuideUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class AuthController {

    @Autowired
    private CountryGuideUserDao countryGuideUserDao;

    @PostMapping("/auth/signup")
    public CountryGuideUsers filteredCountries(@RequestBody CountryGuideUsers countryGuideUsers) {
        countryGuideUsers.setRoles(Collections.singletonList("ROLE_USER"));
        countryGuideUserDao.saveUserToRepository(countryGuideUsers);
        return countryGuideUsers;
    }
}
