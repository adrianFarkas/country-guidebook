package com.codecool.countryguidebook.model;

import com.codecool.countryguidebook.model.countrybuilder.Finance;
import com.codecool.countryguidebook.model.countrybuilder.Geographic;
import com.codecool.countryguidebook.model.countrybuilder.Health;
import com.codecool.countryguidebook.model.countrybuilder.Units;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Country {

    public Geographic geographic = new Geographic();
    public Units units = new Units();
    private String name;

    // not in JSON
    private String description;
    private String flag;
    private Level safety;
    private Finance finance;
    private Health health;
    private String capital;
    private int stateDebtMillionEuro;
    private String mainLabor;
    private int avarageWorkingTimePerYearInHour;

    @Bean
    public static Country createCountry(JSONObject json) throws JSONException {

        Country country = new Country();

        JSONArray currenci = (JSONArray) json.get("currencies");
        JSONArray langu = (JSONArray) json.get("languages");
        country.currencies = new ArrayList<>();
        country.languages = new ArrayList<>();
        country.timezones = new ArrayList<>();
        country.callingCodes = new ArrayList<>();

    public Country() {
    }

    public String getCapital() {
        return capital;
    }

    public Country createCountry(JSONObject json) throws JSONException {

        Country country = new Country();
        country.name = json.get("name").toString();
        country.alpha3Code = CountryCode.valueOf(json.get("alpha3Code").toString());
        country.area = (int) Double.parseDouble(json.get("area").toString());
        JSONArray callingC = (JSONArray) json.get("callingCodes");
        for (int i = 0; i < callingC.length(); i++) {
            country.callingCodes.add(callingC.get(0).toString());
        }
        JSONArray tzones = (JSONArray) json.get("timezones");
        for (int i = 0; i < tzones.length(); i++) {
            country.timezones.add(tzones.get(0).toString());
        }
        country.population = Long.parseLong(json.get("population").toString());
        country.capital = json.get("capital").toString();
        finance = new Finance();
        units.createUnits(json);
        health = new Health();
        geographic.createGeographic(json);
        return country;
    }

    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

}
