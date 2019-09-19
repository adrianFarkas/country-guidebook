package com.codecool.countryguidebook.model.countrybuilder;

import com.codecool.countryguidebook.model.Language;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Units {
    private Units units;
    private List<String> currencies;
    private List<Language> languages;

    public Units createUnits(JSONObject json) throws JSONException {
        JSONArray currencies = (JSONArray) json.get("currencies");
        JSONArray languages = (JSONArray) json.get("languages");
        this.units.currencies = new ArrayList<>();
        this.units.languages = new ArrayList<>();
        for (int i = 0; i < currencies.length(); i++) {
            units.currencies.add(currencies.getJSONObject(i).get("name").toString());
        }
        for (int i = 0; i < languages.length(); i++) {
            units.languages.add(Language.valueOf(languages.getJSONObject(i).get("name").toString().toUpperCase().split("\\s+")[0]));
        }
        return units;
    }

    public List<String> getCurrencies() {
        return currencies;
    }

    public List<Language> getLanguages() {
        return languages;
    }
}
