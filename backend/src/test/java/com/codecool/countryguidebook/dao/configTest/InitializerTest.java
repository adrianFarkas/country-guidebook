package com.codecool.countryguidebook.dao.configTest;

import com.codecool.countryguidebook.config.Initializer;
import com.codecool.countryguidebook.dao.CountryDaoMem;
import com.codecool.countryguidebook.model.Country;
import org.json.JSONException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.util.Assert;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

public class InitializerTest {

    @Autowired
    private Initializer initializer;

    @Autowired
    private CountryDaoMem countryDaoMem;

    @Autowired
    private Country country;

    @Test
    @SuppressWarnings("unchecked")
    public void createEUCountriesTest() throws IOException, JSONException, NoSuchFieldException, IllegalAccessException {
        country.createEUCountriesFromJson();

        Field countries = CountryDaoMem.class.getDeclaredField("countries");

        countries.setAccessible(true);

        List<Country> realCountries = (List<Country>) countries.get(countryDaoMem);

        Assert.notNull(realCountries.get(0), "countries first element cannot be null, after the createEUCountriesFromJson method");
    }
}
