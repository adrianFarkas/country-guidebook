package com.codecool.countryguidebook.model;

import com.codecool.countryguidebook.repository.CountryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class AllRepositoryTest {

    @Mock
    private CountryRepository countryRepository;

    @Test
    public void addCountryToRepository() {
        Country country = Country.builder()
                .name("Hungary")
                .build();

        Mockito.when(countryRepository.save(Mockito.any(Country.class))).thenReturn(country);
        countryRepository.save(country);
        verify(countryRepository, times(1)).save(Mockito.any(Country.class));
    }
}