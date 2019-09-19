package com.codecool.countryguidebook.model;

import com.codecool.countryguidebook.model.countrybuilder.Finance;
import com.codecool.countryguidebook.model.countrybuilder.Geographic;
import com.codecool.countryguidebook.model.countrybuilder.Health;
import com.codecool.countryguidebook.model.countrybuilder.Units;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class Country {

    public Geographic geographic;
    public Units units = new Units();
    private String name;

    // not in JSON
    private String description;
    private String flag;
    private Level safety;

    public String getCapital() {
        return capital;
    }

    private String capital;


    public Country createCountry(JSONObject json) throws JSONException {

        Country country = new Country();
        country.name =json.get("name").toString();
        country.capital = json.get("capital").toString();
        Finance finance = new Finance();
        units.createUnits(json);
        Health health = new Health();
        Geographic geographic = new Geographic();
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
