package com.codecool.countryguidebook.model;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class FilterCriteria {
    private Map<String, Integer> population;
    private List<Currency> currency;
    private List<Language> languages;

    public FilterCriteria(Map<String, Integer> population, List<Currency> currency, List<Language> languages) {
        this.population = population;
        this.currency = currency;
        this.languages = languages;
    }

    public FilterCriteria() {
    }


    public Map<String, Integer> getPopulation() {
        return population;
    }

    public List<Currency> getCurrency() {
        return currency;
    }

    public List<Language> getLanguages() {
        return languages;
    }


}
