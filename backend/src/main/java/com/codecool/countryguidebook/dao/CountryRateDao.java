package com.codecool.countryguidebook.dao;

import com.codecool.countryguidebook.model.Country;
import com.codecool.countryguidebook.model.CountryCode;
import com.codecool.countryguidebook.model.CountryGuideUser;
import com.codecool.countryguidebook.model.countrybuilder.Rate;
import com.codecool.countryguidebook.repository.CountryGuideUserRepository;
import com.codecool.countryguidebook.repository.CountryRepository;
import com.codecool.countryguidebook.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Stream;

@Component
public class CountryRateDao {
    private final String SUCCESS = "{success: true}";

    @Autowired
    private RateRepository rateRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CountryGuideUserRepository userRepository;

    public String handleRate(Rate rate, CountryCode countryCode) {
        Rate actRate = getExistingRate(countryCode);
        if (actRate != null) {
            updateRate(actRate, rate.getRate());
        } else {
            saveRate(rate,countryCode);
        }
        return SUCCESS;
    }

    private void updateRate(Rate rate, Integer newValue) {
        rateRepository.updateRateById(rate.getId(), newValue);
    }

    private Rate getExistingRate(CountryCode countryCode) {
        Optional<Rate> rate = rateRepository.findByCountry_Geographic_Alpha3CodeAndCountryGuideUser_Id(countryCode, getAuthenticatedUser().getId());
        return rate.orElse(null);

    }

    private void saveRate(Rate rate, CountryCode countryCode) {
        rate.setCountry(getActualCountry(countryCode));
        rate.setCountryGuideUser(getAuthenticatedUser());
        rateRepository.save(rate);
    }

    private CountryGuideUser getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userRepository.findByUserName(username).get();
    }

    private Country getActualCountry(CountryCode countryCode) {
        return countryRepository.findCountryByGeographic_Alpha3Code(countryCode);
    }
}
