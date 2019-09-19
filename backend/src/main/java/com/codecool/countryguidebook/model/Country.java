package com.codecool.countryguidebook.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Country {

    private String name;
    private CountryCode alpha3Code;
    private String capital;
    private String subregion;
    private long population;
    private String area;
    private List<String> timezones;
    private List<String> callingCodes;
    private List<String> currencies;
    private List<Language> languages;

    // extra things which is not in the json

    private int avarageSalaryEUR;
    private int minimumWageEUR;
    private String description;
    private Level healtCare;
    private String flag;
    private Level safety;
    private int stateDebtMillionEuro;
    private String mainLabor;
    private int avarageWorkingTimePerYearInHour;


    public static Country createCountry(JSONObject json) throws JSONException {

        Country country = new Country();

        JSONArray currencies = (JSONArray) json.get("currencies");
        JSONArray languages = (JSONArray) json.get("languages");
        country.currencies = new ArrayList<>();
        country.languages = new ArrayList<>();
        country.timezones = new ArrayList<>();
        country.callingCodes = new ArrayList<>();


        for (int i = 0; i < currencies.length(); i++
        ) {

            country.currencies.add(currencies.getJSONObject(i).get("name").toString());
        }

        for (int i = 0; i < languages.length(); i++) {
            country.languages.add(Language.valueOf(languages.getJSONObject(i).get("name").toString().toUpperCase().split("\\s+")[0]));
        }
        country.name = json.get("name").toString();
        country.alpha3Code = CountryCode.valueOf(json.get("alpha3Code").toString());
        country.area = json.get("area").toString();
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
        return country;
    }


    public String getName() {
        return name;
    }

    public String getArea() {
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

    public List<String> getCurrencies() {
        return currencies;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public int getAvarageSalaryEUR() {
        return avarageSalaryEUR;
    }

    public void setAvarageSalaryEUR(int avarageSalaryEUR) {
        this.avarageSalaryEUR = avarageSalaryEUR;
    }

    public int getMinimumWageEUR() {
        return minimumWageEUR;
    }

    public void setMinimumWageEUR(int minimumWageEUR) {
        this.minimumWageEUR = minimumWageEUR;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Level getHealtCare() {
        return healtCare;
    }

    public void setHealtCare(Level healtCare) {
        this.healtCare = healtCare;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Level getSafety() {
        return safety;
    }

    public void setSafety(Level safety) {
        this.safety = safety;
    }

    public int getStateDebtMillionEuro() {
        return stateDebtMillionEuro;
    }

    public void setStateDebtMillionEuro(int stateDebtMillionEuro) {
        this.stateDebtMillionEuro = stateDebtMillionEuro;
    }

    public String getMainLabor() {
        return mainLabor;
    }

    public void setMainLabor(String mainLabor) {
        this.mainLabor = mainLabor;
    }

    public int getAvarageWorkingTimePerYearInHour() {
        return avarageWorkingTimePerYearInHour;
    }

    public void setAvarageWorkingTimePerYearInHour(int avarageWorkingTimePerYearInHour) {
        this.avarageWorkingTimePerYearInHour = avarageWorkingTimePerYearInHour;
    }
}
