package com.codecool.countryguidebook.dao;

import com.codecool.countryguidebook.model.Country;
import org.json.JSONObject;

import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;



@Profile("test")
@Configuration
class MockCountry {

    @Bean
    @Primary
    public Country country() {
        return Mockito.mock(Country.class);
    }






}