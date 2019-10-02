package com.codecool.countryguidebook.config;

import com.codecool.countryguidebook.model.Country;
import com.codecool.countryguidebook.model.CountryCode;
import com.codecool.countryguidebook.model.Currency;
import com.codecool.countryguidebook.model.countrybuilder.Geographic;
import com.codecool.countryguidebook.model.countrybuilder.Units;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Initializer {

    private static final String apiUrl = "https://restcountries.eu/rest/v2/alpha/";
    private static Gson gson = new Gson();
    private static Type stringListType = new TypeToken<List<String>>(){}.getType();

    private static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {

            InputStream is = new URL(url).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String jsonText = readAll(rd);
            return new JSONObject(jsonText);
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static void createEUCountriesFromJson() throws IOException, JSONException {
        for (CountryCode countryCode : CountryCode.values()) {
            JSONObject countryJson = readJsonFromUrl(apiUrl + countryCode);
            Country country = Country.builder().build();

            Units units = buildUnits(countryJson, country);
        }
    }

    private static Units buildUnits(JSONObject countryJson, Country country) throws JSONException {
        Units.UnitsBuilder units = Units.builder();
        JSONArray currencies = countryJson.getJSONArray("currencies");
        JSONArray languages = countryJson.getJSONArray("languages");

        for (int i = 0; i < currencies.length(); i++) {
            JSONObject jsonObject = (JSONObject) currencies.get(i);
            String code = jsonObject.getString("code");
            units.currency(Currency.valueOf(code));
        }

        for (int i = 0; i < languages.length(); i++) {
            JSONObject jsonObject = (JSONObject) languages.get(i);
            String name = jsonObject.getString("name");
            units.currency(Currency.valueOf(name));
        }

        units.country(country);
        return units.build();
    }

    public static void main(String[] args) throws IOException, JSONException {
        createEUCountriesFromJson();
    }
}
