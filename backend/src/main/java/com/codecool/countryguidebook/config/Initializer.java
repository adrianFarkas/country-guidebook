package com.codecool.countryguidebook.config;

import com.codecool.countryguidebook.model.Country;
import com.codecool.countryguidebook.model.CountryCode;
import com.codecool.countryguidebook.model.Currency;
import com.codecool.countryguidebook.model.Language;
import com.codecool.countryguidebook.model.countrybuilder.*;
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
import java.util.LinkedList;
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
            Finance finance = buildFinance(country);
            List<Sight> sights = createSights(country);
            country.setFinance(finance);
            Health health = buildHealth(country);
            country.setSights(sights);
            country.setHealth(health);
            country.setUnits(units);
            country.setGeographic(geographic);
            country.setLogo("lanchid.jpg");
            countries.add(country);
        }
        return countries;
    }

    private List<Sight> createSights(Country country) {
        String[] images = new String[] {"buda-castle.jpg", "buda-hills.jpg", "aggtelek.jpg", "szechenyi-bath.jpg", "eger-castle.jpg", "danube.jpg"};
        String[] city = new String[] {"Budapest", "Budapest", "Aggtelek", "Budapest", "Eger", "Budapest"};
        String[] name = new String[] {"Buda Castle", "Buda Hills", "Aggtelek National Park and Caves", "Széchenyi Bath", "Eger Castle", "The Danube"};
        List<Sight> sights = new LinkedList<>();
        for (int i = 0; i < 6; i++) {
            Sight sight = Sight.builder()
                    .country(country)
                    .name(name[i])
                    .city(city[i])
                    .imageName(images[i])
                    .build();
            sights.add(sight);
        }
        return sights;
    }

    private Finance buildFinance(Country country) {
        Finance finance = Finance.builder()
                .description(descriptionForFinance())
                .stateDebtMillionEuro("https://d3fy651gv2fhd3.cloudfront.net/charts/hungary-government-debt-to-gdp.png?s=hundebt2gdp&v=201904231545V20190821&lang=all")
                .averageSalaryEUR("https://d3fy651gv2fhd3.cloudfront.net/charts/hungary-wages.png?s=hungarywag&v=201910020957V20190821")
                .minimumWageEUR("https://d3fy651gv2fhd3.cloudfront.net/charts/hungary-minimum-wages.png?s=hungaryminwag&v=201904021542V20190821")
                .country(country)
                .build();
        return finance;
    }

    private Health buildHealth(Country country) {
        Health health = Health.builder()
                .country(country)
                .description(descriptionForHealth())
                .stateHospital("https://upload.wikimedia.org/wikipedia/commons/thumb/7/79/Balatonf%C3%BCred%2C_Sz%C3%ADvk%C3%B3rh%C3%A1z.jpg/1920px-Balatonf%C3%BCred%2C_Sz%C3%ADvk%C3%B3rh%C3%A1z.jpg")
                .thermalSpa("https://upload.wikimedia.org/wikipedia/commons/thumb/3/36/H%C3%A9v%C3%ADz_1.jpg/1920px-H%C3%A9v%C3%ADz_1.jpg")
                .hospitalMap("https://www.jewishgen.org/yizkor/Brichah/images/bri138.jpg")
                .country(country)
                .build();
        return health;
    }

    private String descriptionForHealth() {
        return "Állami Szívkórház (\"State Heart Hospital\") in Balatonfüred, resort town by Lake Balaton Hungary has a\n" +
                "                tax-funded universal healthcare system, organized by the state-owned National Health Insurance Fund\n" +
                "                (Hungarian: Országos Egészségbiztosítási Pénztár (OEP)). According to the OECD 100% of the total\n" +
                "                population is covered by universal health insurance, which is absolutely free for children (all\n" +
                "                people under 16), mothers or fathers with baby, students, pensioners (everyone over 62), people with low\n" +
                "                income, handicapped people (including physical and mental disorders), priests and other church\n" +
                "                employees. Health in Hungary can be described with a rapidly increasing life expectancy (7.48 years\n" +
                "                for men and 4.92 years for women between 1993 and 2013) and a very low infant mortality rate (4.6 per\n" +
                "                1,000 live births in 2014). According to the OECD Hungary spent 7.8% of its GDP on health care in\n" +
                "                2012. Total health expenditure was 1,688.7 US$ per capita in 2011, 1,098.3 US$ governmental-fund (65%)\n" +
                "                and 590.4 US$ private-fund (35%). Doctors' pay is the lowest from among the OECD countries. General\n" +
                "                practitioners are paid 1.4 times the average wage and hospital specialists 1.6 times.\n" +
                "                <br/><br/>\n" +
                "                The first hospitals go back to the 13th-century mining towns of Hungary. The first mining health\n" +
                "                insurance was founded by János Thurzó in 1496. The first modern insurer was established in 1907, named\n" +
                "                Országos Munkásbetegsegélyező és Balesetbiztosító Pénztár (\"National Workers' Sick-benefit and Accident\n" +
                "                Fund\"). The first steps to overall health insurance took place in the Horthy era with the creation of\n" +
                "                Országos Társadalombiztosítási Intézet (lit. \"National Social Insurance Institution\") in 1928 (This is\n" +
                "                the predecessor of present-day Országos Egészségbiztosítási Pénztár.). Social services were complete to\n" +
                "                1938, at that time the Hungarian social health insurance system was the most progressive and charitable\n" +
                "                in East-Central Europe. After the World War II the Communist government fully nationalized social\n" +
                "                insurance. Since then the Hungarian healthcare system has been state-owned, overall and available for\n" +
                "                all of the people. The free-market shift initiated after the end of communist rule 30 years ago put a\n" +
                "                strain on the largely centralised, wholly tax-funded public health system, which required far-reaching\n" +
                "                reforms. These resulted in the creation of the National Healthcare Fund (Hungarian: Országos\n" +
                "                Egészségbiztosítási Pénztár), in 1993. The OEP, predominantly based on a social insurance system,\n" +
                "                is the public organization currently controlling the management of health care in Hungary. 83% of the\n" +
                "                financing for health care comes from taxes and other public revenues. Participation in the insurance\n" +
                "                scheme is mandatory for everyone in the workforce, including the self-employed. Most private\n" +
                "                hospitals also operate under the OEP framework. Because of past hiring policies, Hungarian hospitals\n" +
                "                often have redundancies of doctors, and a lack of nurses, resulting in an unproductive misuse of human\n" +
                "                resources. So-called \"gratitude payments\", another communist legacy, require in practice a cash\n" +
                "                payment to have access to better treatments. According to the survey conducted by the Euro health\n" +
                "                consumer index in 2015 Hungary was among the European countries in which unofficial payments to doctors\n" +
                "                were reported most commonly. Medical treatment deemed \"medically necessary\" is provided free of\n" +
                "                charge for European citizens in the country.";
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

        units.country(country)
                .description(descriptionForEducation())
                .spending("https://d3fy651gv2fhd3.cloudfront.net/charts/hungary-public-spending-on-education-total-percent-of-government-expenditure-wb-data.png?s=hun.se.xpd.totl.gb.zs%3aworldbank&lbl=0&v=201910310000V20190821")
                .federal("https://slideplayer.com/slide/12739656/77/images/4/Hungarian+educational+system.jpg")
                .educationIndex("http://budapestbeacon.com/wp-content/uploads/2014/09/WEF2014.png");
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
                .description(descriptionForGeographic())
                .mapLink("https://upload.wikimedia.org/wikipedia/commons/c/c7/Hungary-CIA_WFB_Map.png");


        return geographicBuilder.build();
    }

    private String descriptionForFinance() {
        return "Hungary is an OECD high-income mixed economy with a very high human development index and a skilled labour force,\n" +
                "                with the 13th lowest income inequality in the world; furthermore it is the 14th most complex economy according to the\n" +
                "                Economic Complexity Index. The Hungarian economy is the 57th-largest economy in the world (out of 188 countries measured by IMF)\n" +
                "                with $265.037 billion annual output, and ranks 49th in the world in terms of GDP per capita measured by purchasing power parity.\n" +
                "                Hungary is an export-oriented market economy with a heavy emphasis on foreign trade; thus the country is the 35th largest export economy in the world.\n" +
                "                The country had more than $100 billion of exports in 2015, with a high trade surplus of $9.003 billion, of which 79% went to the EU and 21% was extra-EU trade.\n" +
                "                <br/><br/>Hungary's productive capacity is more than 80% privately owned, with 39.1% overall taxation, which funds the country's welfare economy. On the expenditure side,\n" +
                "                household consumption is the main component of GDP and accounts for 50% of its total, followed by gross fixed capital formation with 22% and government\n" +
                "                expenditure with 20%. In 2009 Hungary, due to strong economic difficulties, had to request the help of the IMF for about € 9 billion.\n" +
                "                Hungary continues to be one of the leading nations in Central and Eastern Europe for attracting foreign direct investment:\n" +
                "                the inward FDI in the country was $119.8 billion in 2015, while Hungary invests more than $50 billion abroad. As of 2015,\n" +
                "                the key trading partners of Hungary were Germany, Austria, Romania, Slovakia, France, Italy, Poland and the Czech Republic.\n" +
                "                Major industries include food processing, pharmaceuticals, motor vehicles, information technology, chemicals, metallurgy, machinery,\n" +
                "                electrical goods, and tourism (in 2014 Hungary welcomed 12.1 million international tourists). <br/><br/>Hungary is the largest electronics\n" +
                "                producer in Central and Eastern Europe. Electronics manufacturing and research are among the main drivers of innovation and economic\n" +
                "                growth in the country. In the past 20 years Hungary has also grown into a major center for mobile technology, information security, and\n" +
                "                related hardware research.The employment rate in the economy was 68.7% in January 2017, the employment structure shows the\n" +
                "                characteristics of post-industrial economies, 63.2% of the employed workforce work in the service sector, industry contributed by 29.7%,\n" +
                "                while agriculture employed 7.1%. The unemployment rate was 3.8% in September–November 2017, down from 11% during the financial crisis of\n" +
                "                2007–08. Hungary is part of the European single market which represents more than 508 million consumers. Several domestic commercial policies\n" +
                "                are determined by agreements among European Union members and by EU legislation.";
    }

    private String descriptionForGeographic() {
        return " Hungary is a landlocked country in East-Central Europe with a land area of 93,030 square km.\n" +
                " It measures about 250 km from north to south and 524 km from east to west.\n" +
                " It has 2,106 km of boundaries, shared with Austria to the west, Serbia, Croatia and Slovenia to the\n" +
                " south and southwest,\n" +
                " Romania to the southeast, Ukraine to the northeast, and Slovakia to the north.\n" +
                " <br/><br/>Hungary's modern borders were first established after World War I when, by the terms of the Treaty of\n" +
                " Trianon in 1920, it lost more than\n" +
                " 71% of what had formerly been the Kingdom of Hungary, 58.5% of its population, and 32% of the\n" +
                " Hungarians. The country secured some\n" +
                " boundary revisions from 1938 to 1941: In 1938 the First Vienna Award gave back territory from\n" +
                " Czechoslovakia, in 1939 Hungary occupied Carpatho-Ukraine.\n" +
                "                In 1940 the Second Vienna Award gave back Northern Transylvania and finally Hungary occupied the Bácska\n" +
                "                and Muraköz regions during the Invasion of Yugoslavia.\n" +
                "                However, Hungary lost these territories again with its defeat in World War II. After World War II, the\n" +
                "                Trianon boundaries were restored with a small revision that benefited Czechoslovakia.\n" +
                "                <br/><br/>Most of the country has an elevation of less than 200 m. Although Hungary has several moderately high\n" +
                "                ranges of mountains,\n" +
                "                those reaching heights of 300 m or more cover less than 2% of the country. The highest point in the\n" +
                "                country is Kékes (1,014 m) in the\n" +
                "                Mátra Mountains northeast of Budapest. The lowest spot is 77.6 m above sea level, located in the south\n" +
                "                of Hungary, near Szeged.\n" +
                "                <br /> <br />The major rivers in the country are the Danube and Tisza. The Danube is navigable within Hungary for 418\n" +
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
                "                <br/><br/>Hungary has three major geographic regions (which are subdivided to seven smaller ones): the Great\n" +
                "                Alföld,\n" +
                "                lying east of the Danube River; the Transdanubia, a hilly region lying west of the Danube and extending\n" +
                "                to the Austrian\n" +
                "                foothills of the Alps; and the North Hungarian Mountains, which is a mountainous and hilly country\n" +
                "                beyond the northern boundary of the Great Hungarian Plain.\n" +
                "                <br/><br/>The country's best natural resource is fertile land, although soil quality varies greatly. About 70% of\n" +
                "                the country's total\n" +
                "                territory is suitable for agriculture; of this portion, 72% is arable land. Hungary lacks extensive\n" +
                "                domestic sources of\n" +
                "                energy and raw materials needed for industrial development.";
    }

    private String descriptionForEducation() {
        return "Education in Hungary is predominantly public, run by the Ministry of Human Resources. Preschool\n" +
                "                kindergarten education is compulsory and provided for all children between three and six years old,\n" +
                "                after which school attendance is also compulsory until age of sixteen.[1] Primary education usually\n" +
                "                lasts for eight years. Secondary education includes three traditional types of schools focused on\n" +
                "                different academic levels: the Gymnasium enrols the most gifted children and prepares students for\n" +
                "                university studies; the secondary vocational schools for intermediate students lasts four years and the\n" +
                "                technical school prepares pupils for vocational education and the world of work. The system is partly\n" +
                "                flexible and bridges exist, graduates from a vocational school can achieve a two years program to have\n" +
                "                access to vocational higher education for instance.[2] The Trends in International Mathematics and\n" +
                "                Science Study (TIMSS) rated 13–14-year-old pupils in Hungary among the bests in the world for maths and\n" +
                "                science. Most of the Hungarian universities are public institutions, and students traditionally study\n" +
                "                without fee payment. The general requirement for university is the Matura. The Hungarian public higher\n" +
                "                education system includes universities and other higher education institutes, that provide both\n" +
                "                education curricula and related degrees up to doctoral degree and also contribute to research\n" +
                "                activities. Health insurance for students is free until the end of their studies. English and German\n" +
                "                language is important in Hungarian higher education, there are a number of degree programs that are\n" +
                "                taught in these languages, which attracts thousands of exchange students every year. Hungary's higher\n" +
                "                education and training has been ranked 44 out of 148 countries in the Global competitiveness Report\n" +
                "                2014.\n" +
                "                <br /> <br />Today there are 67 higher education institutions in Hungary, ranging from small colleges to top research\n" +
                "                universities. These universities and colleges are maintained either by the state, private organizations\n" +
                "                or a church. In accordance with the objectives of the Bologna process the degree structure of tertiary\n" +
                "                education is based on three cycles. Nearly all study fields lead first to a Bachelor’s degree (usually 3\n" +
                "                years), and after a further study period to a Master’s degree (2 years). However, there are some\n" +
                "                exceptions: medicine, pharmacy, dental and veterinary studies, architecture, law, teacher training, and\n" +
                "                certain arts-, crafts- and design-related study programmes, which retain a long single-cycle structure\n" +
                "                of 5 or 6 years of study. The first-cycle programmes last 6–8 semesters (3–4 years, 180–240 credit\n" +
                "                points) and lead to a bachelor's degree (in Hungarian: alapfokozat). The second cycle, leading to a\n" +
                "                master's degree (in Hungarian: mesterfokozat), lasts 2–4 semesters (1–2 years, 60–120 credit points).\n" +
                "                Two-year-long vocational higher education programmes (in Hungarian: felsőoktatási szakképzés) are also\n" +
                "                available on an optional basis prior to first-cycle programmes and lead to advanced vocational\n" +
                "                qualifications. The 120 credit points gained in vocational higher education programmes are compatible\n" +
                "                for recognition in the first (Bachelor) cycle. Any Bachelor’s or master's degree can be followed by\n" +
                "                specialised higher education courses (in Hungarian: szakirányú továbbképzés). These do not lead to\n" +
                "                another degree but offer the option of specialisation in a particular field of study. Courses can be\n" +
                "                studied full-time, part-time or through distance learning. A four-year doctoral programme is a\n" +
                "                post-graduate course to follow any Master’s or equivalent qualification. Hungary has a long tradition of\n" +
                "                higher education reflecting the existence of established knowledge\n" +
                "                economy. <br/><br/>The established universities in Hungary include some of the oldest in the world, the first was\n" +
                "                the University of Pécs founded in 1367 which is still functioning, although in the year 1276, the\n" +
                "                university of Veszprém was destroyed by the troops of Peter Csák, but it was never rebuilt. Sigismund\n" +
                "                established Óbuda University in 1395. Another, Universitas Istropolitana, was established 1465 in\n" +
                "                Pozsony by Mattias Corvinus. Nagyszombat University was founded in 1635 and moved to Buda in 1777 and it\n" +
                "                is called Eötvös Loránd University today. The world's first institute of technology was founded in\n" +
                "                Selmecbánya, Kingdom of Hungary in 1735, its legal successor is the University of Miskolc. The Budapest\n" +
                "                University of Technology and Economics is considered the oldest institute of technology in the world\n" +
                "                with university rank and structure, its legal predecessor the Institutum Geometrico-Hydrotechnicum was\n" +
                "                founded in 1782 by Emperor Joseph II.";
    }
}

