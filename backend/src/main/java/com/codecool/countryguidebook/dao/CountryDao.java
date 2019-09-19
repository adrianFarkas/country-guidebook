package com.codecool.countryguidebook.dao;

import com.codecool.countryguidebook.model.Country;
import com.codecool.countryguidebook.model.FilterCriteria;
import com.codecool.countryguidebook.model.Language;

import java.util.List;
import java.util.Map;


public interface CountryDao {

    void add(Country country);

    List<Country> findByPopulation(List<Country> countries, Map<String, Integer> population);

    List<Country> findByLanguage(List<Country> countries, List<Language> language);

    List<Country> findByCurrency(List<Country> countries, List<String> currency);

    List<Country> filter(FilterCriteria filterCriteria);

    String findCountryByName(String name);

}
