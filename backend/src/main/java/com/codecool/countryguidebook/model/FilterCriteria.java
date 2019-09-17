package com.codecool.countryguidebook.model;

import org.springframework.stereotype.Component;

@Component
public class FilterCriteria {
    private boolean populationFilter;
    private boolean currencyFilter;
    private boolean languageFilter;
    private int populationRangeFrom;
    private int getPopulationRangeTo;
    private String currency;
    private String language;

    public void setAll(boolean populationFilter,  boolean languageFilter, boolean currencyFilter, int populationRangeFrom, int getPopulationRangeTo, String currency, String language) {
        this.populationFilter = populationFilter;
        this.currencyFilter = currencyFilter;
        this.languageFilter = languageFilter;
        this.populationRangeFrom = populationRangeFrom;
        this.getPopulationRangeTo = getPopulationRangeTo;
        this.currency = currency;
        this.language = language;
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

    public String getCurrency() {
        return currency;
    }

    public String getLanguage() {
        return language;
    }


}
