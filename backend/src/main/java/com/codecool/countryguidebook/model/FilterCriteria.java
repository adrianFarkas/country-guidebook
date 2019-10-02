package com.codecool.countryguidebook.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterCriteria {
    private Map<String, Long> population;
    private List<Currency> currency;
    private List<Language> languages;
/*
    public FilterCriteria(Map<String, Integer> population, List<Currency> currency, List<Language> languages) {
        this.population = population;
        this.currency = currency;
        this.languages = languages;
    }

    public FilterCriteria() {
    }


  /*  public Map<String, Integer> getPopulation() {
        return population;
    }

    public List<Currency> getCurrency() {
        return currency;
    }

    public List<Language> getLanguages() {
        return languages;
    }

*/
}
