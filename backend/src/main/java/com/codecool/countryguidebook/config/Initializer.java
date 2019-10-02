package com.codecool.countryguidebook.config;

import com.codecool.countryguidebook.model.Country;
import com.codecool.countryguidebook.model.CountryCode;
import com.codecool.countryguidebook.model.Currency;
import com.codecool.countryguidebook.model.Language;
import com.codecool.countryguidebook.model.countrybuilder.Geographic;
import com.codecool.countryguidebook.model.countrybuilder.Units;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.*;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class Initializer {

    private final String apiUrl = "https://restcountries.eu/rest/v2/alpha/";
    private Gson gson = new Gson();
    private Type stringListType = new TypeToken<List<String>>(){}.getType();

    private JSONObject readJsonFromUrl(String url) throws IOException, JSONException {

            InputStream is = new URL(url).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String jsonText = readAll(rd);
            return new JSONObject(jsonText);
    }

    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public List<Country> createEUCountriesFromJson() throws IOException, JSONException {
        List<Country> countries = new ArrayList<>();
        for (CountryCode countryCode : CountryCode.values()) {
            JSONObject countryJson = readJsonFromUrl(apiUrl + countryCode);
            Country country = Country.builder().name(countryJson.getString("name")).build();

            Units units = buildUnits(countryJson, country);
            Geographic geographic = buildGeographic(countryJson, country);

            country.setUnits(units);
            country.setGeographic(geographic);
            countries.add(country);
        }
        return countries;
    }

    private Units buildUnits(JSONObject countryJson, Country country) throws JSONException {
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
            units.language(Language.valueOf(name.toUpperCase().split("\\s+")[0]));
        }

        units.country(country);
        return units.build();
    }

    private Geographic buildGeographic(JSONObject countryJson, Country country) throws JSONException {
        Geographic.GeographicBuilder geographicBuilder = Geographic.builder();

        geographicBuilder.alpha3Code(CountryCode.valueOf(countryJson.getString("alpha3Code")))
                .capital(countryJson.getString("capital"))
                .area(countryJson.getInt("area"))
                .subRegion(countryJson.getString("subregion"))
                .population(countryJson.getInt("population"))
                .callingCodes(gson.fromJson(String.valueOf(countryJson.getJSONArray("callingCodes")), stringListType))
                .timeZones(gson.fromJson(String.valueOf(countryJson.getJSONArray("timezones")), stringListType))
                .country(country);

        return geographicBuilder.build();
    }
}
