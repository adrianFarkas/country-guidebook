package com.codecool.countryguidebook.dao;

import com.codecool.countryguidebook.model.Country;
import com.codecool.countryguidebook.model.CountryCode;
import com.codecool.countryguidebook.model.FilterCriteria;
import com.codecool.countryguidebook.model.Language;
import org.springframework.stereotype.Component;

import java.util.List;


public interface CountryDao {

    public void add(Country country);
    public List<Country> findByPopulation(List<Country> countries, int populatonRangeFrom, int populationRangeTo);
    public List<Country> findByLanguage(List<Country> countries, List<Language> language);
    public List<Country> findByCurrency(List<Country> countries, String currency);
    public List<CountryCode> filter(FilterCriteria filterCriteria);

}
