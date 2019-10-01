package com.codecool.countryguidebook.repository;

import com.codecool.countryguidebook.model.countrybuilder.Finance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinanceRepository extends JpaRepository<Finance, Long> {
}
