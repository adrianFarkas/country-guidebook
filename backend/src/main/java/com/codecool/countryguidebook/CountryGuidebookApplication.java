package com.codecool.countryguidebook;

import com.codecool.countryguidebook.config.Initializer;
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

//    @Autowired
//    private Initializer initializer;

    @Autowired
    private CountryRepository countryRepository;

    public static void main(String[] args) {
        SpringApplication.run(CountryGuidebookApplication.class, args);
    }

//    @PostConstruct
//    public void init() throws IOException, JSONException {
//        List<Country> countries = initializer.createEUCountriesFromJson();
//        countryRepository.saveAll(countries);
//    }


}
