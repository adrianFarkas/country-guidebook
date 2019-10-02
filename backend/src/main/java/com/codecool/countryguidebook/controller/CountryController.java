package com.codecool.countryguidebook.controller;


import com.codecool.countryguidebook.dao.CountryDaoMemJPA;
import com.codecool.countryguidebook.model.Country;
import com.codecool.countryguidebook.model.Currency;
import com.codecool.countryguidebook.model.FilterCriteria;
import com.codecool.countryguidebook.model.Language;
import com.codecool.countryguidebook.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/countries-list")
    public List<Country> countryList() {
        return countryRepository.findAll();
    }


    @PostMapping("/filter-countries")
    public List<Country> filteredCountries(@RequestBody FilterCriteria filterCriteria) {
        filterCriteria.checkEmpty();
        return countryRepository.filter(filterCriteria);
    }
/*
    @GetMapping("/country/{countryCode}")
    public Country getCountry(@PathVariable String countryCode){
        return countryDaoMem.getCountry(countryCode);
    }
*/
    @GetMapping("/all")
    public HashMap<String, Object> mainData() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("countries", countryRepository.findAll());
        data.put("languages", Language.values());
        data.put("currencies", Currency.values());
        return data;
    }

}
