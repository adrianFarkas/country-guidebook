package com.codecool.countryguidebook.dao;

import com.codecool.countryguidebook.model.Country;
import com.codecool.countryguidebook.model.CountryCode;
import com.codecool.countryguidebook.model.FilterCriteria;
import com.codecool.countryguidebook.model.Language;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CountryDaoMem implements CountryDao {
    private List<Country> countries = new ArrayList<>();

    public CountryDaoMem() {
    }

    @Override
    public void add(Country country) {
        countries.add(country);
    }

    @Override
    public List<Country> findByPopulation(List<Country> countries, Map<String, Integer> population) {
         return countries.stream().
                filter(country -> ((country.getPopulation() > population.get("min")) && (country.getPopulation()<population.get("max")))).
                collect(Collectors.toList());
    }

    @Override
    public List<Country> findByLanguage(List<Country> countries, List<Language> languages) {
        return  countries.stream().
                filter(country -> languages.stream()
                        .anyMatch(language -> country.getLanguages().contains(language)))
                .collect(Collectors.toList());

    }

    @Override
    public List<Country> findByCurrency(List<Country> countries, List<String> currencies) {
        return  countries.stream().
                filter(country -> currencies.stream()
                        .anyMatch(currency -> country.getCurrencies().contains(currency)))
                .collect(Collectors.toList());
    }

    @Override
    public List<CountryCode> filter(FilterCriteria filterCriteria) {
        List<Country> filteredCountries = this.countries;

        if (filterCriteria.getPopulation()!=null){
            filteredCountries = findByPopulation(filteredCountries, filterCriteria.getPopulation());
        }

        if (filterCriteria.getLanguages()!=null){
            filteredCountries = findByLanguage(filteredCountries, filterCriteria.getLanguages());
        }

        if (filterCriteria.getCurrency()!=null){
            filteredCountries = findByCurrency(filteredCountries, filterCriteria.getCurrency());
        }

        return filteredCountries.stream().map(Country::getAlpha3Code).collect(Collectors.toList());
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void clear(){
        countries.clear();
    }

}
