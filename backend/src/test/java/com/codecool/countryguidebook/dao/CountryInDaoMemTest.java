package com.codecool.countryguidebook.dao;


import com.codecool.countryguidebook.model.Country;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class CountryInDaoMemTest {

    @Autowired
    private Country country;

    @Autowired
    private CountryDaoMem countryDaoMem;

    @Test
    public void whenUserIdIsProvided_thenRetrievedNameIsCorrect() {
        Mockito.when(country.getName()).thenReturn("Greece");
        String testcountry = countryDaoMem.findCountryByName("Greece");
        Assert.assertEquals("Athens", testcountry);
    }
}
