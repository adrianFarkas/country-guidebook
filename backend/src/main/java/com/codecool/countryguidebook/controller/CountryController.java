package com.codecool.countryguidebook.controller;

import com.codecool.countryguidebook.dao.CountryDaoMem;
import com.codecool.countryguidebook.model.Country;
import com.codecool.countryguidebook.model.FilterCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CountryController {

    @Autowired
    private CountryDaoMem countryDaoMem;

    @GetMapping("/")
    public List<Country> countryList() {
        return countryDaoMem.getCountries();
    }

    @PostMapping("/filter")
    public List<Country> filteredCountries(@RequestBody FilterCriteria filterCriteria) {
        return countryDaoMem.filter(filterCriteria);
    }
}
