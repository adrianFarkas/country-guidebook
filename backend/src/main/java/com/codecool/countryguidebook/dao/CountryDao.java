package com.codecool.countryguidebook.dao;

import com.codecool.countryguidebook.model.Country;
import com.codecool.countryguidebook.model.CountryCode;
import com.codecool.countryguidebook.model.FilterCriteria;
import com.codecool.countryguidebook.model.Language;

import java.util.List;


public interface CountryDao {

    void add(Country country);
    List<Country> findByPopulation(List<Country> countries, int populationRangeFrom, int populationRangeTo);
    List<Country> findByLanguage(List<Country> countries, List<Language> language);
    List<Country> findByCurrency(List<Country> countries, List<String> currency);
    List<CountryCode> filter(FilterCriteria filterCriteria);

}
