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

@CrossOrigin
@RestController
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CountryDaoMemJPA countryDaoMemJPA;

    @GetMapping("/countries-list")
    public List<Country> countryList() {
        return countryDaoMemJPA.getCountries();
    }


    @PostMapping("/filter-countries")
    public List<Country> filteredCountries(@RequestBody FilterCriteria filterCriteria) {
        List<Language> languages = Arrays.asList(Language.HUNGARIAN, Language.ITALIAN);
        return countryRepository.getCountriesWithGivenLanguages(languages);
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
        data.put("countries", countryDaoMemJPA.getCountries());
        data.put("languages", Language.values());
        data.put("currencies", Currency.values());
        return data;
    }

}
