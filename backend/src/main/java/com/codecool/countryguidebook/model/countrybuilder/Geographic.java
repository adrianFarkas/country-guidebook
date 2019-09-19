package com.codecool.countryguidebook.model.countrybuilder;

import com.codecool.countryguidebook.model.CountryCode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Geographic {
    private static Geographic geographic;
    private CountryCode alpha3Code;
    private String capital;
    private String subregion;
    private long population;
    private int area;
    private List<String> timezones;
    private List<String> callingCodes;

    public static Geographic getGeographic() {
        return geographic;
    }

    public Geographic createGeographic(JSONObject json) throws JSONException {
        geographic.timezones = new ArrayList<>();
        geographic.callingCodes = new ArrayList<>();
        geographic.alpha3Code = CountryCode.valueOf(json.get("alpha3Code").toString());
        geographic.area = (int) Double.parseDouble(json.get("area").toString());
        JSONArray callingCodes = (JSONArray) json.get("callingCodes");
        for (int i = 0; i < callingCodes.length(); i++) {
            geographic.callingCodes.add(callingCodes.get(0).toString());
        }
        JSONArray timezones = (JSONArray) json.get("timezones");
        for (int i = 0; i < timezones.length(); i++) {
            geographic.timezones.add(timezones.get(0).toString());
        }
        geographic.population = Long.parseLong(json.get("population").toString());
        geographic.capital = json.get("capital").toString();
        geographic.subregion = json.get("subregion").toString();
        return geographic;
    }

    public CountryCode getAlpha3Code() {
        return alpha3Code;
    }

    public String getCapital() {
        return capital;
    }

    public String getSubregion() {
        return subregion;
    }

    public long getPopulation() {
        return population;
    }

    public int getArea() {
        return area;
    }

    public List<String> getTimezones() {
        return timezones;
    }

    public List<String> getCallingCodes() {
        return callingCodes;
    }
}
