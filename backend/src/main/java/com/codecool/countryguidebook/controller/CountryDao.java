package com.codecool.countryguidebook.controller;

import com.codecool.countryguidebook.model.Country;

import java.util.List;

public interface CountryDao {

    public void add(Country country);
    public List<Country> findByPopulation(List<Country> countries, int populatonRangeFrom, int populationRangeTo);
    public List<Country> findByLanguage(List<Country> countries, String language);
    public List<Country> findByCurrency(List<Country> countries, String currency);
    public List<Country> Filter();

}
