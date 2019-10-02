package com.codecool.countryguidebook.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterCriteria {
    private List<Currency> currency;
    private List<Language> languages;
    private Long population_min;
    private Long population_max;

}
