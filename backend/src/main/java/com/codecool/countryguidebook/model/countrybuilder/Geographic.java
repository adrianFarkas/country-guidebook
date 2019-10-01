package com.codecool.countryguidebook.model.countrybuilder;

import com.codecool.countryguidebook.model.Country;
import com.codecool.countryguidebook.model.CountryCode;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.List;

@Component
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Geographic {
    @Id
    @GeneratedValue
    private CountryCode alpha3Code;
    private String capital;
    private String subRegion;
    private long population;
    private int area;
    private List<String> timeZones;
    private List<String> callingCodes;

    @OneToOne
    private Country country;

/*    public Geographic createGeographic(JSONObject json) throws JSONException {
        this.timezones = new ArrayList<>();
        this.callingCodes = new ArrayList<>();
        this.alpha3Code = CountryCode.valueOf(json.get("alpha3Code").toString());
        this.area = (int) Double.parseDouble(json.get("area").toString());
        JSONArray callingCodes = (JSONArray) json.get("callingCodes");
        for (int i = 0; i < callingCodes.length(); i++) {
            this.callingCodes.add(callingCodes.get(0).toString());
        }
        JSONArray timezones = (JSONArray) json.get("timezones");
        for (int i = 0; i < timezones.length(); i++) {
            this.timezones.add(timezones.get(0).toString());
        }
        this.population = Long.parseLong(json.get("population").toString());
        this.capital = json.get("capital").toString();
        this.subregion = json.get("subregion").toString();
        return this;
    }*/
}
