package com.codecool.countryguidebook.model;

import com.codecool.countryguidebook.model.countrybuilder.Finance;
import com.codecool.countryguidebook.model.countrybuilder.Geographic;
import com.codecool.countryguidebook.model.countrybuilder.Health;
import com.codecool.countryguidebook.model.countrybuilder.Units;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Country {

    @OneToOne(mappedBy = "country", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    public Geographic geographic;
    @OneToOne(mappedBy = "country", cascade = CascadeType.PERSIST)
    public Units units;
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne(mappedBy = "country", cascade = CascadeType.PERSIST)
    private Finance finance;

    @OneToOne(mappedBy = "country", cascade = CascadeType.PERSIST)
    private Health health;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(columnDefinition = "text")
    private String description;

    @Transient
    private String flag;

}
