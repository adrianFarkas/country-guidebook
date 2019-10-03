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
public class Health {

    @Id
    @GeneratedValue
    private long id;

    @Enumerated(EnumType.STRING)
    private Level healthCare;

    @Column(columnDefinition = "text")
    private String description;

    @OneToOne
    @JsonIgnore
    private Country country;
}
