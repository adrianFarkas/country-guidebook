package com.codecool.countryguidebook.dao;

import com.codecool.countryguidebook.model.Country;
import com.codecool.countryguidebook.model.Currency;
import com.codecool.countryguidebook.model.FilterCriteria;
import com.codecool.countryguidebook.model.Language;

import java.util.List;
import java.util.Map;

public class CountryDaoMemJPA implements CountryDao {
    @Override
    public void add(Country country) {

    }

    @Override
    public List<Country> findByPopulation(List<Country> countries, Map<String, Integer> population) {
        return null;
    }

    @Override
    public List<Country> findByLanguage(List<Country> countries, List<Language> language) {
        return null;
    }

    @Override
    public List<Country> findByCurrency(List<Country> countries, List<Currency> currency) {
        return null;
    }

    @Override
    public List<Country> filter(FilterCriteria filterCriteria) {
        return null;
    }

    @Override
    public String findCountryByName(String name) {
        return null;
    }
}
