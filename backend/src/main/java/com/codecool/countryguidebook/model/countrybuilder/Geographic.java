package com.codecool.countryguidebook.model.countrybuilder;

import com.codecool.countryguidebook.model.CountryCode;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class Geographic {
    private CountryCode alpha3Code;
    private String capital;
    private String subregion;
    private long population;
    private int area;
    private List<String> timezones;
    private List<String> callingCodes;

    country.timezones = new ArrayList<>();
    country.callingCodes = new ArrayList<>();
    country.name = json.get("name").toString();
    country.alpha3Code = CountryCode.valueOf(json.get("alpha3Code").toString());
    country.area = (int) Double.parseDouble(json.get("area").toString());
    JSONArray callingCodes = (JSONArray) json.get("callingCodes");
        for (int i = 0; i < callingCodes.length(); i++) {
        country.callingCodes.add(callingCodes.get(0).toString());
    }
    JSONArray timezones = (JSONArray) json.get("timezones");
        for (int i = 0; i < timezones.length(); i++) {
        country.timezones.add(timezones.get(0).toString());
    }
    country.population = Long.parseLong(json.get("population").toString());
    country.capital = json.get("capital").toString();
    country.subregion = json.get("subregion").toString();

    public int getArea() {
        return area;
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


    public List<String> getTimezones() {
        return timezones;
    }

    public List<String> getCallingCodes() {
        return callingCodes;
    }

}
