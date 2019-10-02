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

    @Autowired
    private CountryDaoMemJPA countryDaoMemJPA;

    @GetMapping("/countries-list")
    public List<Country> countryList() {
        return countryDaoMemJPA.getCountries();
    }


    @PostMapping("/filter-countries")
    public List<Country> filteredCountries(@RequestBody FilterCriteria filterCriteria) {
       /* Map<String, Integer> population = new HashMap<>();
        population.put("min", 100000);
        population.put("max", 100000000);
        filterCriteria.setPopulation(population);
        List<Language> languages = Arrays.asList(Language.HUNGARIAN, Language.GERMAN);
        List<Currency> currencies = Arrays.asList(Currency.EUR, Currency.CHF);
        filterCriteria.setCurrency(currencies);
        filterCriteria.setLanguages(languages);
*/
        //List<Language> languages = Arrays.asList(Language.HUNGARIAN, Language.ITALIAN);
        List<Language> languages = filterCriteria.getLanguages();
        List<Currency> currencies = filterCriteria.getCurrency();
        Long min = filterCriteria.getPopulation().get("min");
        Long max = filterCriteria.getPopulation().get("max");
        return countryRepository.filter(min,max,languages,currencies);
        //return countryRepository.filter(filterCriteria);
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
