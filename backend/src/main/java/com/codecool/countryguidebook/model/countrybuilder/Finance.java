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
public class Finance {
    private static Finance finance;
    private int stateDebtMillionEuro;
    private String mainLabor;
    private int avarageWorkingTimePerYearInHour;
    private int avarageSalaryEUR;
    private int minimumWageEUR;


}
