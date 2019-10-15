package com.codecool.countryguidebook.repository;

import com.codecool.countryguidebook.model.CountryGuideUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryGuideUserRepository extends JpaRepository<CountryGuideUsers, Long> {
}
