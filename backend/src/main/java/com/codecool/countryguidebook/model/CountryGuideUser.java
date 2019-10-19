package com.codecool.countryguidebook.model;


import com.codecool.countryguidebook.model.countrybuilder.Rate;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CountryGuideUser {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String userName;

    @NotNull
    private String password;

    @NotNull
    private String email;

    @ElementCollection
    @OneToMany(mappedBy = "countryGuideUser")
    private Set<Rate> rates;

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();
}
