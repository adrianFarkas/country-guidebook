package com.codecool.countryguidebook.repository;

import com.codecool.countryguidebook.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
