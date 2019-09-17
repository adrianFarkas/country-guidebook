package com.codecool.countryguidebook.model;

public class Country {

    String name;
    CountryCode countryCode;
    Integer population;
    String currency;

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

    public Country(String name, CountryCode countryCode, Integer population, String currency) {
        this.name = name;
        this.countryCode = countryCode;
        this.population = population;
        this.currency = currency;
    }
}
