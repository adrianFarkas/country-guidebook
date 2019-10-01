package com.codecool.countryguidebook.model.countrybuilder;

import com.codecool.countryguidebook.model.Level;

public class Health {
    //not in JSON
    private Level healtCare;

    public Health() {
        this.healtCare = getHealtCare();
    }

    public Level getHealtCare() {
        return healtCare;
    }

    public void setHealtCare(Level healtCare) {
        this.healtCare = healtCare;
    }

}
