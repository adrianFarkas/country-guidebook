package com.codecool.countryguidebook.model.countrybuilder;

import com.codecool.countryguidebook.model.Country;
import com.codecool.countryguidebook.model.CountryGuideUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Rate {

    @Id
    @GeneratedValue
    private Long id;

    private Integer rate;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private Country country;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private CountryGuideUser countryGuideUser;
}
