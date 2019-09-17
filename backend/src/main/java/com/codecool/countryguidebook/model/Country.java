package com.codecool.countryguidebook.model;

import java.util.List;

public class Country {

    String name;
    CountryCode countryCode;
    Integer population;
    String currency;
    List<Language> languageList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public CountryCode getCountryCode() {
        return countryCode;
    }

    public List<Language> getLanguageList() {
        return languageList;
    }

    public Country(String name, CountryCode countryCode, Integer population, String currency, List<Language> languages) {
        this.name = name;
        this.countryCode = countryCode;
        this.population = population;
        this.currency = currency;
        this.languageList = languages;
    }
}
