package com.codecool.countryguidebook;

import com.codecool.countryguidebook.model.Country;
import com.codecool.countryguidebook.model.CountryCode;
import com.codecool.countryguidebook.model.Currency;
import com.codecool.countryguidebook.model.Language;
import com.codecool.countryguidebook.model.countrybuilder.*;
import com.codecool.countryguidebook.repository.CountryRepository;
import com.codecool.countryguidebook.repository.FinanceRepository;
import com.codecool.countryguidebook.repository.GeographicRepository;
import com.codecool.countryguidebook.repository.UnitsRepository;
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


import java.util.Arrays;
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
    private UnitsRepository unitsRepository;

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



        Country country1 = Country.builder()
                .name("Country1")
                .build();

        Country country2 = Country.builder()
                .name("Country2")
                .build();

        Geographic geographic1 = Geographic.builder()
                .population(1000000)
                .country(country1)
                .build();

        Geographic geographic2 = Geographic.builder()
                .population(2000000)
                .country(country2)
                .build();

        country1.setGeographic(geographic1);
        country2.setGeographic(geographic2);

        countryRepository.save(country1);
        countryRepository.save(country2);

        List<Country> allByGeographicPopulationBetween = countryRepository.countries(500000L, 1500000L);

        assertThat(allByGeographicPopulationBetween).hasSize(1);

    }

    @Test
    public void getCountriesByLanguage()
    {


        Country country1 = Country.builder()
                .name("Countr1")
                .build();

        Country country2 = Country.builder()
                .name("Country2")
                .build();

        Units units = Units.builder()
                .language(Language.HUNGARIAN)
                .country(country1)
                .build();

        Units units2 = Units.builder()
                .language(Language.GERMAN)
                .country(country2)
                .build();


            country1.setUnits(units);
            country2.setUnits(units2);

        countryRepository.save(country1);
        countryRepository.save(country2);

        List<Language> languages = Arrays.asList(Language.HUNGARIAN, Language.GERMAN);

        List<Country> countries = countryRepository.getCountriesWithGivenLanguages(languages);

        assertThat(countries).hasSize(2);
    }

    @Test
    public void findCountryByCurrency() {

        Country country1 = Country.builder()
                .name("Country1")
                .build();

        Units units1 = Units.builder()
                .country(country1)
                .currency(Currency.EUR)
                .build();

        country1.setUnits(units1);

        countryRepository.save(country1);


//        List<Currency> currencies = Arrays.asList(Currency.EUR);
        List<Country> countries = countryRepository.countries(Currency.EUR);
        assertThat(countries).hasSize(1);
    }
}
