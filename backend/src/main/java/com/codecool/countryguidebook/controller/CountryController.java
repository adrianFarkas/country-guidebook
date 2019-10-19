package com.codecool.countryguidebook.controller;


import com.codecool.countryguidebook.dao.CountryRateDao;
import com.codecool.countryguidebook.model.*;
import com.codecool.countryguidebook.model.countrybuilder.Rate;
import com.codecool.countryguidebook.repository.CountryRepository;
import com.codecool.countryguidebook.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@CrossOrigin
@RestController
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CountryRateDao rateDao;

    @GetMapping("/countries-list")
    public List<Country> countryList() {
        return countryRepository.findAll();
    }


    @PostMapping("/filter-countries")
    public List<Country> filteredCountries(@RequestBody FilterCriteria filterCriteria) {
        filterCriteria.checkEmpty();
        return countryRepository.filter(filterCriteria);
    }

    @GetMapping("/country/{countryCode}")
    public Country getCountry(@PathVariable String countryCode){
        return countryRepository.findCountryByGeographic_Alpha3Code(CountryCode.valueOf(countryCode.toUpperCase()));
    }

    @GetMapping("/all")
    public HashMap<String, Object> mainData() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("countries", countryRepository.findAll());
        data.put("languages", Language.values());
        data.put("currencies", Currency.values());
        return data;
    }

    @PostMapping("/country/{countryCode}/rate")
    public String rateCountry(@RequestBody Rate rate, @PathVariable String countryCode) {
        return rateDao.handleRate(rate, CountryCode.valueOf(countryCode.toUpperCase()));
    }

}
