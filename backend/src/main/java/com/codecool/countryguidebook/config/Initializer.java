package com.codecool.countryguidebook.config;

import com.codecool.countryguidebook.dao.CountryDaoMem;
import com.codecool.countryguidebook.model.Country;
import com.codecool.countryguidebook.model.CountryCode;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

@Component
public class Initializer {

    @Autowired
    private CountryDaoMem countryDaoMem;



    private static final String apiUrl = "https://restcountries.eu/rest/v2/alpha/";

    public void createEUCountriesFromJson() throws IOException, JSONException {
        for (CountryCode countryCode : CountryCode.values()) {
            JSONObject country = readJsonFromUrl(apiUrl + countryCode);
            Country country1 = Country.createCountry(country);
            countryDaoMem.add(country1);
        }
    }


    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
}
