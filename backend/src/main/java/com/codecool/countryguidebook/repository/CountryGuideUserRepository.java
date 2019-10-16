package com.codecool.countryguidebook.repository;

import com.codecool.countryguidebook.model.CountryGuideUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryGuideUserRepository extends JpaRepository<CountryGuideUser, Long> {

    Optional<CountryGuideUser> findByUserName(String username);
}
