package com.codecool.countryguidebook.model;


import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
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

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();
}
