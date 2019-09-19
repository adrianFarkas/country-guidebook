package com.codecool.countryguidebook.model.countrybuilder;

import com.codecool.countryguidebook.model.Language;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Units {
    private List<String> currencies;
    private List<Language> languages;

    public Units createUnits(JSONObject json) throws JSONException {
        JSONArray currencies = (JSONArray) json.get("currencies");
        JSONArray languages = (JSONArray) json.get("languages");
        this.currencies = new ArrayList<>();
        this.languages = new ArrayList<>();
        for (int i = 0; i < currencies.length(); i++) {
            this.currencies.add(currencies.getJSONObject(i).get("name").toString());
        }
        for (int i = 0; i < languages.length(); i++) {
            this.languages.add(Language.valueOf(languages.getJSONObject(i).get("name").toString().toUpperCase().split("\\s+")[0]));
        }
        return this;
    }

    public List<String> getCurrencies() {
        return currencies;
    }

    public List<Language> getLanguages() {
        return languages;
    }
}
