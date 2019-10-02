package com.codecool.countryguidebook.model.countrybuilder;

import com.codecool.countryguidebook.model.Country;
import com.codecool.countryguidebook.model.Currency;
import com.codecool.countryguidebook.model.Language;
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
public class Units {
    @Id
    @GeneratedValue
    private Long id;
    @Singular
    @ElementCollection
    private List<Currency> currencies;
    @Singular
    @ElementCollection
    private List<Language> languages;

    @OneToOne
    private Country country;
}