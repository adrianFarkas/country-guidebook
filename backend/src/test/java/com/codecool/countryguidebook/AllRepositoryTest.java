package com.codecool.countryguidebook;

import com.codecool.countryguidebook.dao.CountryGuideUserDao;
import com.codecool.countryguidebook.model.*;
import com.codecool.countryguidebook.model.countrybuilder.*;
import com.codecool.countryguidebook.repository.*;
import org.junit.Before;
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
import static org.junit.Assert.*;


@DataJpaTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class AllRepositoryTest {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CountryGuideUserRepository countryGuideUserRepository;


    private CountryGuideUserDao dao;

    @Before
    public void init() {
        dao = new CountryGuideUserDao(countryGuideUserRepository);
    }

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
    public void getCountriesByLanguage() {


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


        List<Currency> currencies = Arrays.asList(Currency.EUR);
        List<Country> countries = countryRepository.countries(currencies);
        assertThat(countries).hasSize(1);
    }


    @Test
    public void daoAddUserToDatabase() {
        CountryGuideUser countryGuideUser = CountryGuideUser.builder()
                .userName("user")
                .email("user@hu.hu")
                .password("password")
                .build();

        CountryGuideUserDao dao = new CountryGuideUserDao(countryGuideUserRepository);
        dao.saveUserToRepository(countryGuideUser);

    }

    @Test
    public void daoAddUserToDb() {
        CountryGuideUser countryGuideUser = CountryGuideUser.builder()
                .userName("user")
                .email("user@hu.hu")
                .password("password")
                .build();

        dao.saveUserToRepository(countryGuideUser);

        assertTrue(dao.checkUsernameExists(countryGuideUser.getUserName()));
    }

    @Test
    public void daoDeleteUserFromDatabase() {
        CountryGuideUser countryGuideUser = CountryGuideUser.builder()
                .userName("user")
                .email("user@hu.hu")
                .password("password")
                .build();

        dao.saveUserToRepository(countryGuideUser);

        assertTrue(dao.checkUsernameExists("user"));

        dao.deleteUserFromDb("user");
        assertFalse(dao.checkUsernameExists("user"));
    }

    @Test
    public void checkPasswordIsEncodedInDatabase() {
        String password = "password";
        CountryGuideUser countryGuideUser = CountryGuideUser.builder()
                .userName("user")
                .email("user@hu.hu")
                .password("password")
                .build();

        dao.saveUserToRepository(countryGuideUser);

        CountryGuideUser userFromDb = dao.getUserFromDbByName("user");

        assertNotEquals(userFromDb.getPassword(), password);
        assertTrue(userFromDb.getPassword().startsWith("{bcrypt"));

    }


}
