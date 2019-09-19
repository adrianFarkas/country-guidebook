package com.codecool.countryguidebook.model.countrybuilder;

import com.codecool.countryguidebook.model.Country;
import com.codecool.countryguidebook.model.Language;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class Units {
    private List<String> currencies;
    private List<Language> languages;
    private Country country;


    JSONArray currencies = (JSONArray) json.get("currencies");
    JSONArray languages = (JSONArray) json.get("languages");

    country.currencies = new ArrayList<>();
    country.languages = new ArrayList<>();
        for (int i = 0; i < currencies.length(); i++) {
        country.currencies.add(currencies.getJSONObject(i).get("name").toString());
    }
        for (int i = 0; i < languages.length(); i++) {
        country.languages.add(Language.valueOf(languages.getJSONObject(i).get("name").toString().toUpperCase().split("\\s+")[0]));
    }

    public List<String> getCurrencies() {
        return currencies;
    }

    public List<Language> getLanguages() {
        return languages;
    }

}
