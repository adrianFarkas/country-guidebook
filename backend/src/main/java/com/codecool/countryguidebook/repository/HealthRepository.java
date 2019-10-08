package com.codecool.countryguidebook.repository;

import com.codecool.countryguidebook.model.countrybuilder.Health;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthRepository extends JpaRepository<Health, Long> {
}
