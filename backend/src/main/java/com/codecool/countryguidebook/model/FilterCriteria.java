package com.codecool.countryguidebook.model;

public class FilterCriteria {
    private boolean popuplationFilter;
    private boolean currencyFilter;
    private boolean languageFilter;
    private int populationRangeFrom;
    private int getPopulationRangeTo;
    private String currency;
    private String language;

    public FilterCriteria(boolean popuplationFilter, boolean currencyFilter, boolean languageFilter, int populationRangeFrom, int getPopulationRangeTo, String currency, String language) {
        this.popuplationFilter = popuplationFilter;
        this.currencyFilter = currencyFilter;
        this.languageFilter = languageFilter;
        this.populationRangeFrom = populationRangeFrom;
        this.getPopulationRangeTo = getPopulationRangeTo;
        this.currency = currency;
        this.language = language;
    }

    public boolean isPopuplationFilter() {
        return popuplationFilter;
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
