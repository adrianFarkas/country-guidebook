package com.codecool.countryguidebook.model.countrybuilder;

import com.codecool.countryguidebook.model.Country;
import com.codecool.countryguidebook.model.Language;
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
public class Units {
    @Id
    @GeneratedValue
    private List<String> currencies;
    private List<Language> languages;

    @OneToOne
    private Country country;

    /*public Units createUnits(JSONObject json) throws JSONException {
        JSONArray currencies = (JSONArray) json.get("currencies");
        JSONArray languages = (JSONArray) json.get("languages");
        this.currencies = new ArrayList<>();
        this.languages = new ArrayList<>();
        for (int i = 0; i < currencies.length(); i++) {
            this.currencies.add(currencies.getJSONObject(i).get("name").toString());
        }
        for (int i = 0; i < languages.length(); i++) {
            this.languages.add(Language.valueOf(languages.getJSONObject(i).get("name").toString().toUpperCase().split("\\s+")[0]));
        }
        return this;
    }*/
}