package com.codecool.countryguidebook.dao;

import com.codecool.countryguidebook.model.CountryGuideUsers;
import com.codecool.countryguidebook.repository.CountryGuideUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CountryGuideUserDao {

    @Autowired
    private CountryGuideUserRepository countryGuideUserRepository;

    public void saveUserToRepository(CountryGuideUsers countryGuideUsers){
        countryGuideUsers.setPassword(encodePassword(countryGuideUsers.getPassword()));
        countryGuideUserRepository.save(countryGuideUsers);

    }

    private String encodePassword(String password){
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        return passwordEncoder.encode(password);
    }
}
