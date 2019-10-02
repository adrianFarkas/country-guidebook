package com.codecool.countryguidebook.dao;

import com.codecool.countryguidebook.model.Country;
import com.codecool.countryguidebook.model.FilterCriteria;
import com.codecool.countryguidebook.model.Language;
import com.codecool.countryguidebook.model.*;
import org.springframework.context.annotation.Bean;
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
                filter(country -> ((country.getGeographic().getPopulation() > population.get("min")) && (country.getGeographic().getPopulation() <= population.get("max"))))
          .collect(Collectors.toList());
    }

    @Override
    public List<Country> findByLanguage(List<Country> countries, List<Language> languages) {
        return countries.stream().
                filter(country -> languages.stream()
                        .anyMatch(language -> country.getUnits().getLanguages().contains(language)))
                .collect(Collectors.toList());

    }

    @Override
    public List<Country> findByCurrency(List<Country> countries, List<Currency> currencies) {
        return  countries.stream()
                .filter(country -> currencies.stream()
                        .anyMatch(currency -> country.getUnits().getCurrencies().contains(currency)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Country> filter(FilterCriteria filterCriteria) {
        List<Country> filteredCountries = this.countries;

        if (!filterCriteria.getPopulation().isEmpty()) {
            filteredCountries = findByPopulation(filteredCountries, filterCriteria.getPopulation());
        }

        if (!filterCriteria.getLanguages().isEmpty()) {
            filteredCountries = findByLanguage(filteredCountries, filterCriteria.getLanguages());
        }

        if (!filterCriteria.getCurrency().isEmpty()) {
            filteredCountries = findByCurrency(filteredCountries, filterCriteria.getCurrency());
        }

        return filteredCountries; //filteredCountries.stream().map(Country::getAlpha3Code).collect(Collectors.toList());
    }

    @Override
    public String findCountryByName(String name) {
        Country resultCountry = countries.stream().filter(country -> country.getGeographic().getCapital().equals(name)).findFirst().orElse(null);
        if (resultCountry != null) {
            return resultCountry.getName();
        }
        return null;
    }

    public Country getCountry(String countryCode){
        return countries.stream().filter(country -> country.getGeographic().getAlpha3Code().toString().equals(countryCode.toUpperCase())).findFirst().orElse(null);
    }

    public List<Country> getCountries() {
        return countries;
    }


    public void clear() {
        countries.clear();
    }

}
