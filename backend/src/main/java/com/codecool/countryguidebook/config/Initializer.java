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
    private Type stringListType = new TypeToken<List<String>>() {
    }.getType();

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
                .country(country)
                .description(descritionForGeographic());


        return geographicBuilder.build();
    }

    private String descritionForGeographic() {
        return " <br/>Hungary is a landlocked country in East-Central Europe with a land area of 93,030 square km.\n" +
                " It measures about 250 km from north to south and 524 km from east to west.\n" +
                " It has 2,106 km of boundaries, shared with Austria to the west, Serbia, Croatia and Slovenia to the\n" +
                " south and southwest,\n" +
                " Romania to the southeast, Ukraine to the northeast, and Slovakia to the north.\n" +
                " <br/><br/>\n" +
                " Hungary's modern borders were first established after World War I when, by the terms of the Treaty of\n" +
                " Trianon in 1920, it lost more than\n" +
                " 71% of what had formerly been the Kingdom of Hungary, 58.5% of its population, and 32% of the\n" +
                " Hungarians. The country secured some\n" +
                " boundary revisions from 1938 to 1941: In 1938 the First Vienna Award gave back territory from\n" +
                " Czechoslovakia, in 1939 Hungary occupied Carpatho-Ukraine.\n" +
                "                In 1940 the Second Vienna Award gave back Northern Transylvania and finally Hungary occupied the Bácska\n" +
                "                and Muraköz regions during the Invasion of Yugoslavia.\n" +
                "                However, Hungary lost these territories again with its defeat in World War II. After World War II, the\n" +
                "                Trianon boundaries were restored with a small revision that benefited Czechoslovakia.\n" +
                "                <br/><br/>\n" +
                "                Most of the country has an elevation of less than 200 m. Although Hungary has several moderately high\n" +
                "                ranges of mountains,\n" +
                "                those reaching heights of 300 m or more cover less than 2% of the country. The highest point in the\n" +
                "                country is Kékes (1,014 m) in the\n" +
                "                Mátra Mountains northeast of Budapest. The lowest spot is 77.6 m above sea level, located in the south\n" +
                "                of Hungary, near Szeged.\n" +
                "                <br/><br/>\n" +
                "                The major rivers in the country are the Danube and Tisza. The Danube is navigable within Hungary for 418\n" +
                "                kilometers.\n" +
                "                The Tisza River is navigable for 444 km in the country. Less important rivers include the Drava along\n" +
                "                the Croatian border,\n" +
                "                the Rába, the Szamos, the Sió, and the Ipoly along the Slovakian border. Hungary has three major lakes.\n" +
                "                Lake Balaton, the largest,\n" +
                "                is 78 km long and from 3 to 14 km wide, with an area of 600 square km [1]. Hungarians often refer to it\n" +
                "                as the Hungarian Sea. It is\n" +
                "                Central Europe's largest freshwater lake and an important recreation area. Its shallow waters offer good\n" +
                "                summer swimming, and in winter\n" +
                "                its frozen surface provides excellent opportunities for winter sports. Smaller bodies of water are Lake\n" +
                "                Velence (26 square km) in Fejér\n" +
                "                County and Lake Fertő (Neusiedler See—about 82 square km within Hungary), and the artificial Lake Tisza.\n" +
                "                <br/><br/>\n" +
                "                Hungary has three major geographic regions (which are subdivided to seven smaller ones): the Great\n" +
                "                Alföld,\n" +
                "                lying east of the Danube River; the Transdanubia, a hilly region lying west of the Danube and extending\n" +
                "                to the Austrian\n" +
                "                foothills of the Alps; and the North Hungarian Mountains, which is a mountainous and hilly country\n" +
                "                beyond the northern boundary of the Great Hungarian Plain.\n" +
                "\n" +
                "                The country's best natural resource is fertile land, although soil quality varies greatly. About 70% of\n" +
                "                the country's total\n" +
                "                territory is suitable for agriculture; of this portion, 72% is arable land. Hungary lacks extensive\n" +
                "                domestic sources of\n" +
                "                energy and raw materials needed for industrial development.";
    }
}
