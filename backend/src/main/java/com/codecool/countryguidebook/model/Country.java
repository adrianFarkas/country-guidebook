package com.codecool.countryguidebook.model;

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
    private int area;
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


    static Country createCountry(JSONObject json) throws JSONException {

        Country country = new Country();

        JSONObject[] currenci = (JSONObject[]) json.get("currencies");
        JSONObject[] langu = (JSONObject[]) json.get("languages");
        country.currencies = new ArrayList<>();
        country.languages = new ArrayList<>();

        for (JSONObject jsonObject : currenci
        ) {
            country.currencies.add(jsonObject.get("name").toString());
        }
        for (JSONObject jsonObject : langu
        ) {
            country.languages.add(Language.valueOf(jsonObject.get("name").toString()));
        }
        country.name = json.get("name").toString();
        country.alpha3Code = CountryCode.valueOf(json.get("alpha3Code").toString());
        country.area = Integer.valueOf(json.get("area").toString());
        String[] callingC = (String[]) json.get("callingCodes");
        country.callingCodes = new ArrayList<>(Arrays.asList(callingC));
        String[] tzones = (String[]) json.get("timezones");
        country.timezones = new ArrayList<>(Arrays.asList(tzones));
        country.population = Long.parseLong(json.get("population").toString());
        country.capital = json.get("capital").toString();
        country.subregion = json.get("subregion").toString();
        return country;
    }


    public String getName() {
        return name;
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

    public List<String> getCurrencies() {
        return currencies;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public int getAvarageSalaryEUR() {
        return avarageSalaryEUR;
    }

    public int getMinimumWageEUR() {
        return minimumWageEUR;
    }

    public String getDescription() {
        return description;
    }

    public Level getHealtCare() {
        return healtCare;
    }

    public String getFlag() {
        return flag;
    }

    public Level getSafety() {
        return safety;
    }

    public int getStateDebtMillionEuro() {
        return stateDebtMillionEuro;
    }

    public String getMainLabor() {
        return mainLabor;
    }

    public int getAvarageWorkingTimePerYearInHour() {
        return avarageWorkingTimePerYearInHour;
    }

    public void setAvarageSalaryEUR(int avarageSalaryEUR) {
        this.avarageSalaryEUR = avarageSalaryEUR;
    }

    public void setMinimumWageEUR(int minimumWageEUR) {
        this.minimumWageEUR = minimumWageEUR;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHealtCare(Level healtCare) {
        this.healtCare = healtCare;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setSafety(Level safety) {
        this.safety = safety;
    }

    public void setStateDebtMillionEuro(int stateDebtMillionEuro) {
        this.stateDebtMillionEuro = stateDebtMillionEuro;
    }

    public void setMainLabor(String mainLabor) {
        this.mainLabor = mainLabor;
    }

    public void setAvarageWorkingTimePerYearInHour(int avarageWorkingTimePerYearInHour) {
        this.avarageWorkingTimePerYearInHour = avarageWorkingTimePerYearInHour;
    }
}
