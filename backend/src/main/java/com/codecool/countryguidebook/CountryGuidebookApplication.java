package com.codecool.countryguidebook;

import com.codecool.countryguidebook.config.Initializer;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.IOException;

@SpringBootApplication
public class CountryGuidebookApplication {


    @Autowired
    private Initializer initializer;

    public static void main(String[] args) {
        SpringApplication.run(CountryGuidebookApplication.class, args);
    }

    @PostConstruct
    public void init() throws IOException, JSONException {
        initializer.createEUCountriesFromJson();
    }
}
