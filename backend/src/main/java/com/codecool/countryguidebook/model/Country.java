package com.codecool.countryguidebook.model;

public class Country {

    String name;
    Integer population;
    String[] currency;

    public Country(String name, Integer population, String[] currency) {
        this.name = name;
        this.population = population;
        this.currency = currency;
    }
}
