package com.codecool.countryguidebook.controller;

import com.codecool.countryguidebook.model.Country;
import com.codecool.countryguidebook.model.FilterCriteria;

import java.util.ArrayList;
import java.util.List;

public class CountryDaoMem implements CountryDao {
    private List<Country> countries = new ArrayList<>();

    @Override
    public void add(Country country) {
        this.countries.add(country);
    }

    @Override
    public List<Country> findByPopulation(List<Country> countries, int populationRangeFrom, int populationRangeTo) {

        return null;
    }

    @Override
    public List<Country> findByLanguage(List<Country> countries, String languauge) {
        return null;
    }

    @Override
    public List<Country> findByCurrency(List<Country> countries, String currency) {
        return null;
    }

    @Override
    public List<Country> Filter() {
        List<Country> filteredCountries = this.countries;
        FilterCriteria filterCriteria = new FilterCriteria(true,true,true,1000,10000,"HUF", "HUN");

        if (filterCriteria.isPopuplationFilter()){
            filteredCountries = findByPopulation(filteredCountries, filterCriteria.getPopulationRangeFrom(), filterCriteria.getGetPopulationRangeTo());
        }

        if (filterCriteria.isLanguageFilter()){
            filteredCountries = findByLanguage(filteredCountries, filterCriteria.getLanguage());
        }

        if (filterCriteria.isCurrencyFilter()){
            filteredCountries = findByCurrency(filteredCountries, filterCriteria.getCurrency());
        }

        return filteredCountries;
    }

    public List<Country> getCountries() {
        return countries;
    }
}
