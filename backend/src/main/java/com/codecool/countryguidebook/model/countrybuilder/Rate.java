package com.codecool.countryguidebook.model.countrybuilder;

import com.codecool.countryguidebook.model.Country;
import com.codecool.countryguidebook.model.CountryGuideUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Country country;

    @ManyToOne
    @JsonIgnore
    private CountryGuideUser countryGuideUser;
}
