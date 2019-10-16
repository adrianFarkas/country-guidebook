package com.codecool.countryguidebook.dao;

import com.codecool.countryguidebook.model.CountryGuideUser;
import com.codecool.countryguidebook.repository.CountryGuideUserRepository;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CountryGuideUserDao {

    private final CountryGuideUserRepository countryGuideUserRepository;

    public CountryGuideUserDao(CountryGuideUserRepository countryGuideUserRepository) {
        this.countryGuideUserRepository = countryGuideUserRepository;
    }

    public void saveUserToRepository(CountryGuideUser countryGuideUser) {
        String password = countryGuideUser.getPassword();
        String encodedPassword = encodePassword(password);
        countryGuideUser.setPassword(encodedPassword);
        countryGuideUserRepository.save(countryGuideUser);
    }

    private String encodePassword(String password) {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        return passwordEncoder.encode(password);
    }
}
