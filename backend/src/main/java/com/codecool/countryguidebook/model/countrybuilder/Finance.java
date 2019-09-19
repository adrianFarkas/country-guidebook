package com.codecool.countryguidebook.model.countrybuilder;

public class Finance {
    // not in JSON
    private static Finance finance;
    private int stateDebtMillionEuro;
    private String mainLabor;
    private int avarageWorkingTimePerYearInHour;
    private int avarageSalaryEUR;
    private int minimumWageEUR;

    public Finance() {
        this.stateDebtMillionEuro = getStateDebtMillionEuro();
        }


    public int getAvarageSalaryEUR() {
        return avarageSalaryEUR;
    }

    public void setAvarageSalaryEUR(int avarageSalaryEUR) {
        this.avarageSalaryEUR = avarageSalaryEUR;
    }

    public int getMinimumWageEUR() {
        return minimumWageEUR;
    }

    public void setMinimumWageEUR(int minimumWageEUR) {
        this.minimumWageEUR = minimumWageEUR;
    }

    public int getStateDebtMillionEuro() {
        return 100;
    }

    public void setStateDebtMillionEuro(int stateDebtMillionEuro) {
        this.stateDebtMillionEuro = stateDebtMillionEuro;
    }

    public String getMainLabor() {
        return mainLabor;
    }

    public void setMainLabor(String mainLabor) {
        this.mainLabor = mainLabor;
    }

    public int getAvarageWorkingTimePerYearInHour() {
        return avarageWorkingTimePerYearInHour;
    }

    public void setAvarageWorkingTimePerYearInHour(int avarageWorkingTimePerYearInHour) {
        this.avarageWorkingTimePerYearInHour = avarageWorkingTimePerYearInHour;
    }
}
