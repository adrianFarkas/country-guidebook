package com.codecool.countryguidebook.model.countrybuilder;

import com.codecool.countryguidebook.model.Country;
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

    @Enumerated
    private Level healthCare;

    @OneToOne
    private Country country;

}
