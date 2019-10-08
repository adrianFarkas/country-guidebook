package com.codecool.countryguidebook.repository;

import com.codecool.countryguidebook.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {

    @Query("select distinct c from Country c " +
            "join c.units.languages l " +
            "join c.units.currencies curr " +
            "where c.geographic.population>= :#{#param.population_min} and c.geographic.population<= :#{#param.population_max}" +
            " AND l IN (:#{#param.languages})" +
            "AND curr IN (:#{#param.currency})")
    List<Country> filter(@Param("param") FilterCriteria filterCriteria);

    @Query("select distinct c from Country c where c.geographic.population>=:from and c.geographic.population<=:to")
    List<Country> countries(@Param("from") Long from, @Param("to") Long to);

    @Query("select distinct c from Country c join c.units.languages l where l IN (:languages) ")
    List<Country> getCountriesWithGivenLanguages(@Param("languages") List<Language> languages);

    @Query("select distinct c from Country c join c.units.currencies curr where curr = (:currency)")
    List<Country> countries(@Param("currency") List<Currency> currency);

    Country findCountryByGeographic_Alpha3Code(CountryCode countryCode);

/*
@Query("select distinct c from Country c " +
        "join fetch c.units u " +
        "join fetch u.currencies cu " +
        "where cu = :currency")
List<Country> countries(@Param("currency") List<Currency> currency);
 */
}
