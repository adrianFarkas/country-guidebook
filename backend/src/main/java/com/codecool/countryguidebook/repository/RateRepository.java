package com.codecool.countryguidebook.repository;

import com.codecool.countryguidebook.model.CountryCode;
import com.codecool.countryguidebook.model.CountryGuideUser;
import com.codecool.countryguidebook.model.countrybuilder.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface RateRepository extends JpaRepository<Rate, Long> {

    Optional<Rate> findByCountry_Geographic_Alpha3Code(CountryCode countryCode);

    @Modifying
    @Query("UPDATE Rate r SET r.rate = :rate WHERE r.id = :id")
    void updateRateById(Long id, Integer rate);

    Optional<Rate> findByCountry_Geographic_Alpha3CodeAndCountryGuideUser_Id(CountryCode countryCode, Long id);

    List<Rate> findAllByCountry_Geographic_Alpha3Code(CountryCode countryCode);
}
