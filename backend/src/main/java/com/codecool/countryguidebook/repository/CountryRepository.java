package com.codecool.countryguidebook.repository;

import com.codecool.countryguidebook.model.Country;
import com.codecool.countryguidebook.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {

    @Query("select distinct c from Country c where c.geographic.population>=:from and c.geographic.population<=:to")
    List<Country> countries(@Param("from") Long from, @Param("to") Long to);

   // @Query("select distinct c from Country c join c.units.languages l where l IN ('HUNGARIAN', 'GERMAN') ")
    @Query("select distinct c from Country c join c.units.languages l where l IN (:languages) ")
    List<Country> getCountriesWithGivenLanguages(@Param("languages") List<Language> languages);


}
