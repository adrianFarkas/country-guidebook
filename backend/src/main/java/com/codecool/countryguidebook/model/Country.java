package com.codecool.countryguidebook.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class Country {

    private String name;

    // extra things which is not in the json

    private String description;
    private String flag;
    private Level safety;


    public static Country createCountry(JSONObject json) throws JSONException {

        Country country = new Country();

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
