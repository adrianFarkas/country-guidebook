package com.codecool.countryguidebook.model;

import org.json.JSONException;
import org.json.JSONObject;


public class Country {

    private String name;
    private CountryCode alpha3Code;
    private String capital;
    private String subregion;
    private long population;
    private int area;
    private String[] timezones;
    private String[] callingCodes;
    private String[] currencies;
    private Language[] languages;

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

        JSONObject[] currencii = (JSONObject[]) json.get("currencies");
        JSONObject[] langu = (JSONObject[]) json.get("languages");
        int cl = currencii.length;
        int ll = langu.length;
        country.currencies = new String[cl];
        country.languages = new Language[ll];

        for (int i = 0; i < cl; i++) {
            country.currencies[i] = currencii[i].get("name").toString();
        }
        for (int i = 0; i < ll; i++) {
            country.languages[i] = Language.valueOf(langu[i].get("name").toString());
        }
        country.name = json.get("name").toString();
        country.alpha3Code = CountryCode.valueOf(json.get("alpha3Code").toString());
        country.area = Integer.valueOf(json.get("area").toString());
        country.callingCodes = (String[]) json.get("callingCodes");
        country.timezones = (String[]) json.get("timezones");
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

    public String[] getTimezones() {
        return timezones;
    }

    public String[] getCallingCodes() {
        return callingCodes;
    }

    public String[] getCurrencies() {
        return currencies;
    }

    public Language[] getLanguages() {
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
