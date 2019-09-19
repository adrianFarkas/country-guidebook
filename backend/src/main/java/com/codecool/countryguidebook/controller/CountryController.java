package com.codecool.countryguidebook.controller;

import com.codecool.countryguidebook.dao.CountryDaoMem;
import com.codecool.countryguidebook.model.Country;
import com.codecool.countryguidebook.model.Currency;
import com.codecool.countryguidebook.model.FilterCriteria;
import com.codecool.countryguidebook.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
public class CountryController {

    @Autowired
    private CountryDaoMem countryDaoMem;

    @GetMapping("/countries-list")
    public List<Country> countryList() {
        return countryDaoMem.getCountries();
    }

    @PostMapping("/filter-countries")
    public List<Country> filteredCountries(@RequestBody FilterCriteria filterCriteria) {
        return countryDaoMem.filter(filterCriteria);
    }

    @GetMapping("/all")
    public HashMap<String, Object> mainData() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("countries", countryDaoMem.getCountries());
        data.put("languages", Language.values());
        data.put("currencies", Currency.values());
        return data;
    }

}
