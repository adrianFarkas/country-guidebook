package com.codecool.countryguidebook;

import com.codecool.countryguidebook.model.Country;
import com.codecool.countryguidebook.repository.CountryRepository;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class CountryGuidebookApplication {


    @Autowired
    private CountryRepository countryRepository;

    public static void main(String[] args) {
        SpringApplication.run(CountryGuidebookApplication.class, args);
    }


}
