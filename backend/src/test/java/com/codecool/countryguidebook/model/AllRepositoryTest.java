package com.codecool.countryguidebook.model;

import com.codecool.countryguidebook.repository.CountryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class AllRepositoryTest {

/*    @MockBean
    private CountryRepository countryRepository;*/

    @Test
    public void addCountryToRepository () {
        Country country = Country.builder()
                .name("Hungary")
                .build();

/*        countryRepository.save(country);
        List<Country> countries = countryRepository.findAll();

        assertThat(countries).hasSize(1);*/
    }
}