package com.codecool.countryguidebook.dao;

import com.codecool.countryguidebook.model.Country;
import com.codecool.countryguidebook.model.CountryCode;
import com.codecool.countryguidebook.model.FilterCriteria;
import com.codecool.countryguidebook.model.Language;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
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
    public List<Country> findByPopulation(List<Country> countries, int populationRangeFrom, int populationRangeTo) {
         return countries.stream().
                filter(country -> ((country.getPopulation() > populationRangeFrom) && (country.getPopulation()<populationRangeTo))).
                collect(Collectors.toList());
    }

    @Override
    public List<Country> findByLanguage(List<Country> countries, List<Language> languages) {
        return  countries.stream().
                filter(country -> languages.stream()
                        .anyMatch(language -> country.getLanguageList().contains(language)))
                .collect(Collectors.toList());

    }

    @Override
    public List<Country> findByCurrency(List<Country> countries, List<String> currencies) {
        return  countries.stream().
                filter(country -> currencies.stream()
                        .anyMatch(currency -> country.getCurrency().contains(currency)))
                .collect(Collectors.toList());
    }

    @Override
    public List<CountryCode> filter(FilterCriteria filterCriteria) {
        List<Country> filteredCountries = this.countries;

        if (filterCriteria.isPopulationFilter()){
            filteredCountries = findByPopulation(filteredCountries, filterCriteria.getPopulationRangeFrom(), filterCriteria.getGetPopulationRangeTo());
        }

        if (filterCriteria.isLanguageFilter()){
            filteredCountries = findByLanguage(filteredCountries, filterCriteria.getLanguages());
        }

        if (filterCriteria.isCurrencyFilter()){
            filteredCountries = findByCurrency(filteredCountries, filterCriteria.getCurrency());
        }

        return filteredCountries.stream().map(Country::getCountryCode).collect(Collectors.toList());
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void clear(){
        countries.clear();
    }

}
