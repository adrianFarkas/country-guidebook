package com.codecool.countryguidebook.model.countrybuilder;

import com.codecool.countryguidebook.model.Country;
import com.codecool.countryguidebook.model.CountryCode;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
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
    private Long id;

    @Enumerated(EnumType.STRING)
    private CountryCode alpha3Code;

    private String capital;
    private String subRegion;
    private long population;
    private int area;

    @Column(columnDefinition = "text")
    private String description;

    private String mapLink;

    @Singular
    @ElementCollection
    private List<String> timeZones;

    @Singular
    @ElementCollection
    private List<String> callingCodes;

    @OneToOne
    @JsonIgnore
    private Country country;
}
