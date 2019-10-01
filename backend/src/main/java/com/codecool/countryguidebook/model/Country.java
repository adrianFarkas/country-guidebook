package com.codecool.countryguidebook.model;

import com.codecool.countryguidebook.model.countrybuilder.Finance;
import com.codecool.countryguidebook.model.countrybuilder.Geographic;
import com.codecool.countryguidebook.model.countrybuilder.Health;
import com.codecool.countryguidebook.model.countrybuilder.Units;
import lombok.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Country {

    public Geographic geographic;
    public Units units;
    private Finance finance;
    private Health health;

    private String name;

    private String description;
    private String flag;
    private String capital;
    private int stateDebtMillionEuro;
    private String mainLabor;
    private int averageWorkingTimePerYearInHour;


}
