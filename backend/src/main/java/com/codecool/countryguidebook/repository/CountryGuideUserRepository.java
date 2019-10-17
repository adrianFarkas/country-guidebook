package com.codecool.countryguidebook.repository;

import com.codecool.countryguidebook.model.CountryGuideUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CountryGuideUserRepository extends JpaRepository<CountryGuideUser, Long> {

    Optional<CountryGuideUser> findByUserName(String username);
    Optional<CountryGuideUser> findByEmail(String email);

    @Modifying
    @Query("DELETE from CountryGuideUser c where c.userName=?1")
    void deleteByUserName(String username);
}
