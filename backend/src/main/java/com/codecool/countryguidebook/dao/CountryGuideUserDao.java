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

    public boolean checkUsernameExists(String username){
        return countryGuideUserRepository.findByUserName(username).isPresent();
    }

    public boolean checkEmailExists(String email){
        return countryGuideUserRepository.findByEmail(email).isPresent();
    }

    public String checkUsernameAndPasswordPersent(String username, String email){
        boolean userNameExists = countryGuideUserRepository.findByUserName(username).isPresent();
        boolean emailExists = countryGuideUserRepository.findByEmail(email).isPresent();

        if (userNameExists && emailExists)
            return "Username and email address already taken";

        if (userNameExists)
            return "Username already taken";

        if (emailExists)
            return "Email address already taken";

        return "";


    }
}
