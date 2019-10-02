package com.codecool.countryguidebook.repository;

import com.codecool.countryguidebook.model.Country;
import com.codecool.countryguidebook.model.Currency;
import com.codecool.countryguidebook.model.FilterCriteria;
import com.codecool.countryguidebook.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {

  /*  @Query("select distinct c from Country c " +
            "join c.units.languages l " +
            "join c.units.currencies curr " +
            "where c.geographic.population>= :#{#param.population.min} and c.geographic.population<= :#{#param.population.max}" +
            " AND l IN (:#{#param.languages})" +
            "AND curr IN (:#{#param.currencies})")
    List<Country> filter(@Param("param") FilterCriteria filterCriteria);
*/

      @Query("select distinct c from Country c " +
            "join c.units.languages l " +
            "join c.units.currencies curr " +
            "where c.geographic.population>= :popfrom and c.geographic.population<= :popto" +
            " AND l IN (:languages)" +
            "AND curr IN (:currencies)")
    List<Country> filter(@Param("popfrom") Long popfrom, @Param("popto") Long popto, @Param("languages") List<Language> languages, @Param("currencies") List<Currency> currencies);



    @Query("select distinct c from Country c where c.geographic.population>=:from and c.geographic.population<=:to")
    List<Country> countries(@Param("from") Long from, @Param("to") Long to);

    @Query("select distinct c from Country c join c.units.languages l where l IN (:languages) ")
    List<Country> getCountriesWithGivenLanguages(@Param("languages") List<Language> languages);

    @Query("select distinct c from Country c join c.units.currencies curr where curr = (:currency)")
    List<Country> countries(@Param("currency") List<Currency> currency);


/*
@Query("select distinct c from Country c " +
        "join fetch c.units u " +
        "join fetch u.currencies cu " +
        "where cu = :currency")
List<Country> countries(@Param("currency") List<Currency> currency);
 */
}
