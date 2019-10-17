package com.codecool.countryguidebook.model.countrybuilder;

import com.codecool.countryguidebook.model.Country;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Education {

    @Id
    @GeneratedValue
    private long id;

    private Integer averageIq;

    private Integer compulsoryYears;

    private Integer expenditure;

    private Integer spending;

    @OneToOne
    @JsonIgnore
    private Country country;
}
