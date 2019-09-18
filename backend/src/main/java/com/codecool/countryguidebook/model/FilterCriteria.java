package com.codecool.countryguidebook.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FilterCriteria {
    private boolean populationFilter;
    private boolean currencyFilter;
    private boolean languageFilter;
    private int populationRangeFrom;
    private int getPopulationRangeTo;
    private List<String> currency;
    private List<Language> languages;

    public void setAll(boolean populationFilter,  boolean languageFilter, boolean currencyFilter, int populationRangeFrom, int getPopulationRangeTo, List<String> currency, List<Language> language) {
        this.populationFilter = populationFilter;
        this.currencyFilter = currencyFilter;
        this.languageFilter = languageFilter;
        this.populationRangeFrom = populationRangeFrom;
        this.getPopulationRangeTo = getPopulationRangeTo;
        this.currency = currency;
        this.languages = language;
    }

    public FilterCriteria() {
    }

    public boolean isPopulationFilter() {
        return populationFilter;
    }

    public boolean isCurrencyFilter() {
        return currencyFilter;
    }

    public boolean isLanguageFilter() {
        return languageFilter;
    }

    public int getPopulationRangeFrom() {
        return populationRangeFrom;
    }

    public int getGetPopulationRangeTo() {
        return getPopulationRangeTo;
    }

    public List<String> getCurrency() {
        return currency;
    }

    public List<Language> getLanguages() {
        return languages;
    }


}
