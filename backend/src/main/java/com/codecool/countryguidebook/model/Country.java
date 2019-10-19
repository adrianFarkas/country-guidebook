package com.codecool.countryguidebook.model;

import com.codecool.countryguidebook.model.countrybuilder.*;
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
public class Country {

    @Id
    @GeneratedValue
    private Long id;

    @Setter
    @OneToOne(mappedBy = "country", cascade = CascadeType.PERSIST)
    private Geographic geographic;

    @Setter
    @OneToOne(mappedBy = "country", cascade = CascadeType.PERSIST)
    private Units units;

    @Setter
    @OneToOne(mappedBy = "country", cascade = CascadeType.PERSIST)
    private Finance finance;

    @Setter
    @OneToOne(mappedBy = "country", cascade = CascadeType.PERSIST)
    private Health health;

    @Setter
    @OneToOne(mappedBy = "country", cascade = CascadeType.PERSIST)
    private Education education;

    @Setter
    @ElementCollection
    @OneToMany(mappedBy = "country", cascade = CascadeType.PERSIST)
    private List<Sight> sights;

    @ElementCollection
    @OneToMany(mappedBy = "country")
    private List<Rate> rates;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(columnDefinition = "text")
    private String description;

    @Setter
    private String logo;

    @Transient
    private String flag;

}
