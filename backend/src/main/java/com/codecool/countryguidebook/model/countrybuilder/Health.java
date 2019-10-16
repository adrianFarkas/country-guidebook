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

    private Integer skill;

    private Integer speed;

    private Integer equipment;

    private Integer satisfaction;

    @Column(columnDefinition = "text")
    private String description;


    @OneToOne
    @JsonIgnore
    private Country country;
}
