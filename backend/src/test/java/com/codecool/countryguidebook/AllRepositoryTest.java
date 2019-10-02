package com.codecool.countryguidebook;

import com.codecool.countryguidebook.model.Country;
import com.codecool.countryguidebook.model.CountryCode;
import com.codecool.countryguidebook.model.Language;
import com.codecool.countryguidebook.model.countrybuilder.*;
import com.codecool.countryguidebook.repository.CountryRepository;
import com.codecool.countryguidebook.repository.FinanceRepository;
import com.codecool.countryguidebook.repository.GeographicRepository;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class AllRepositoryTest {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private GeographicRepository geographicRepository;

    @Autowired
    private FinanceRepository financeRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void addCountryToRepository() {
        Country country = Country.builder()
                .name("Hungary")

                .build();

        countryRepository.save(country);

        List<Country> countries = countryRepository.findAll();
        assertThat(countries).hasSize(1);
    }

    @Test
    public void transientIsNotSaved() {
        Country country = Country.builder()
                .name("Hungary")
                .flag("flag")
                .build();
        countryRepository.save(country);
        entityManager.clear();
        List<Country> countries = countryRepository.findAll();
        assertThat(countries).allMatch(country1 -> country1.getFlag() == null);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void countryNameShouldBeNotNull() {
        Country country = Country.builder()
                .flag("flag")
                .build();

        Country country2 = Country.builder()
                .flag("flag")
                .build();

        countryRepository.save(country);
        countryRepository.save(country2);

        List<Country> countries = countryRepository.findAll();
        assertThat(countries).anyMatch(country1 -> country1.getName() == null);

    }

    @Test
    public void geographicIsPersistedWithCountry() {

        Geographic geographic = Geographic.builder()
                .alpha3Code(CountryCode.HUN)
                .build();


        Finance finance = Finance.builder()
                .minimumWageEUR(1000)
                .build();

        Units units = Units.builder()
                .language(Language.HUNGARIAN)
                .build();

        Health health = Health.builder()
                .healthCare(Level.POOR)
                .build();


        Country country = Country.builder()
                .name("Hungary")
                .geographic(geographic)
                .finance(finance)
                .units(units)
                .health(health)
                .build();

        countryRepository.save(country);

        List<Country> countries = countryRepository.findAll();

        assertThat(countries)
                .hasSize(1)
                .anyMatch(country1 -> country1.getGeographic().getId() > 0L)
                .anyMatch(finance1 -> finance1.getId() > 0L)
                .anyMatch(units1 -> units1.getId() > 0L)
                .anyMatch(health1 -> health1.getId() > 0L);

    }

    @Test
    public void geographicIsPersistedAndDeletedWithCountry() {


        Geographic geographic = Geographic.builder()
                .alpha3Code(CountryCode.HUN)
                .build();

        Country country = Country.builder()
                .name("Hungary")
                .geographic(geographic)
                .build();

        countryRepository.save(country);
        assertThat(geographicRepository.findAll())
                .hasSize(1)
                .anyMatch(geographic1 -> geographic1.getAlpha3Code().equals(CountryCode.HUN));

        countryRepository.deleteAll();

        assertThat(geographicRepository.findAll()).hasSize(0);
    }

    @Test
    public void financeIsPersistedAndDeletedWithCountry() {


        Finance finance = Finance.builder()
                .minimumWageEUR(1000)
                .build();

        Country country = Country.builder()
                .name("Hungary")
                .finance(finance)
                .build();

        countryRepository.save(country);
        assertThat(financeRepository.findAll())
                .hasSize(1)
                .anyMatch(finance1 -> finance1.getMinimumWageEUR()==1000);

        countryRepository.deleteAll();

        assertThat(financeRepository.findAll()).hasSize(0);
    }

    @Test
    public void findAllCountry() {

        Country country1 = Country.builder()
                .name("Country1")
                .build();

        Country country2 = Country.builder()
                .name("Country2")
                .build();

        countryRepository.save(country1);
        countryRepository.save(country2);

        List<Country> allCountries = countryRepository.findAll();

        assertThat(allCountries).hasSize(2);

    }

    @Test
    public void findAllCountryByGeographicPopulationBetween() {

        Geographic geographic1 = Geographic.builder()
                .population(1000000)
                .build();

        Geographic geographic2 = Geographic.builder()
                .population(2000000)
                .build();

        Country country1 = Country.builder()
                .name("Country1")
                .geographic(geographic1)
                .build();

        Country country2 = Country.builder()
                .name("Country2")
                .geographic(geographic2)
                .build();


        countryRepository.save(country1);
        countryRepository.save(country2);

        List<Country> allByGeographicPopulationBetween = countryRepository.countries(500000L, 1500000L);

        assertThat(allByGeographicPopulationBetween).hasSize(1);

    }
}
/*
@DataJpaTest
@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)
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

        List<Country> countries = countryRepository.findAll();
        assertThat(countries).hasSize(1);
    }
}

 */