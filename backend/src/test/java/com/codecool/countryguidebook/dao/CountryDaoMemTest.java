package com.codecool.countryguidebook.dao;

import com.codecool.countryguidebook.model.Country;
import com.codecool.countryguidebook.model.CountryCode;
import com.codecool.countryguidebook.model.Language;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CountryDaoMemTest {


    private List<Language> hun = Collections.singletonList(Language.HUNGARIAN);
    private List<Language> ger = Collections.singletonList(Language.GERMAN);
    private List<Language> gerHun = Arrays.asList(Language.HUNGARIAN, Language.GERMAN);
    private List<Language> gerHIta = Arrays.asList(Language.ITALIAN, Language.GERMAN);
    private List<Language> fra = Collections.singletonList(Language.FRENCH);
    private List<Language> ita = Collections.singletonList(Language.ITALIAN);

    @Before
    public void init(){

    }

    @Test
    public void addCountryToDao(){
        CountryDaoMem countryDaoMem = new CountryDaoMem();
        Country c1 = new Country("Hungary", CountryCode.HUN,456, "EUR", hun);
        countryDaoMem.add(c1);
        Country c2 = new Country("Germany", CountryCode.DEU, 1200, "EUR", gerHun);
        countryDaoMem.add(c2);
        Assert.assertEquals(2, countryDaoMem.getCountries().size());
    }

    @Test
    public void filterCountriesByPopulationWithRange(){
        CountryDaoMem countryDaoMem = new CountryDaoMem();
        Country c1 = new Country("Hungary", CountryCode.HUN,456, "EUR", hun);
        countryDaoMem.add(c1);
        Country c2 = new Country("Germany", CountryCode.DEU, 1200, "EUR", gerHun);
        countryDaoMem.add(c2);
        Assert.assertEquals(1, countryDaoMem.findByPopulation(countryDaoMem.getCountries(),100,600).size());
        Assert.assertEquals(1, countryDaoMem.findByPopulation(countryDaoMem.getCountries(),1000,2000).size());
        Assert.assertEquals(2, countryDaoMem.findByPopulation(countryDaoMem.getCountries(),100,2111).size());
    }

    @Test
    public void filterCountriesByLanguages(){
        CountryDaoMem countryDaoMem = new CountryDaoMem();
        Country c1 = new Country("Hungary", CountryCode.HUN,456, "EUR", hun);
        countryDaoMem.add(c1);
        Country c2 = new Country("Germany", CountryCode.DEU, 1200, "EUR", gerHun);
        countryDaoMem.add(c2);
        Assert.assertEquals(2, countryDaoMem.findByLanguage(countryDaoMem.getCountries(),hun).size());
        Assert.assertEquals(1, countryDaoMem.findByLanguage(countryDaoMem.getCountries(),ger).size());
        Assert.assertEquals(0, countryDaoMem.findByLanguage(countryDaoMem.getCountries(),ita).size());

    }

}