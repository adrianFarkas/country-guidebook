package com.codecool.countryguidebook.repository;

import com.codecool.countryguidebook.model.countrybuilder.Geographic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeographicRepository extends JpaRepository<Geographic, Long> {
}
