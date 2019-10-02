package com.codecool.countryguidebook.repository;

import com.codecool.countryguidebook.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {

    @Query("select distinct c from Country c where c.geographic.population>=:from and c.geographic.population<=:to")
    List<Country> countries(@Param("from") Long from, @Param("to") Long to);
  //  List<Country> findAllByGeographic(Long from, Long to);
  //  List<Country> findAllByGeographic_PopulationIsBetween(Long from, Long to);


}
