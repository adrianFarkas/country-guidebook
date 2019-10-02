package com.codecool.countryguidebook.repository;

import com.codecool.countryguidebook.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {

    List<Country> findAllCountryByGeographicPopulationBetween(Long from, Long to);
}
