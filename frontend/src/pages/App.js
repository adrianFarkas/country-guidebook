import React, {Component, useEffect, useState} from 'react';
import Header from "../components/Header";
import EuMap from "../components/EuMap";
import "../css/main.css"
import FilterForm from "../components/filter/FilterForm";
import axios from "axios"

function App() {
    const [countryCodes, setCountryCodes] = useState([]);
    const [languages, setLanguages] = useState([]);
    const [currencies, setCurrencies] = useState([]);
    const [slider, setSlider] = useState({min: 0, max: 0, values: [0, 0]});

    const setStateData = data => {
        const population = getPropertiesFromCountries(data["countries"], "population");
        const min = Math.min(...population), max = Math.max(...population);
        setCountryCodes(getPropertiesFromCountries(data["countries"], "alpha3Code"));
        setLanguages(data["languages"]);
        setCurrencies(data["currencies"]);
        setSlider({min: min, max: max, values: [min, max]});
    };

    useEffect(() => {
        axios.get("http://localhost:8080/all")
            .then((res => setStateData(res.data)))
    }, []);

    const handleChange = (e, newValue) => {
        setSlider({min: slider.min, max: slider.max, values: newValue});
    };

    const submitHandle = (event) => {
        event.preventDefault();
        const form = event.target;
        const languages = form.languages.value,
            currency = form.currency.value,
            populationRange = form.slider.value.split(",");
        const data = {
            "languages": languages === "default" ? []: [languages],
            "currency": currency === "default" ? []: [currency],
            "population": {
                "min": populationRange[0],
                "max": populationRange[1]
            }
        };
        axios.post("http://localhost:8080/filter-countries", data)
            .then(res => setCountryCodes(getPropertiesFromCountries(res.data, "alpha3Code")));
    };

    return (
        <div className="App">
            <Header text="Country Guide"/>
            <FilterForm
                languages={languages}
                currencies={currencies}
                slider={slider}
                handleChange={handleChange}
                submitHandle={submitHandle}
            />
            <EuMap
                countryCodes={countryCodes}
            />
        </div>
    );
}

function getPropertiesFromCountries(countryList, property) {
    const properties = [];
    countryList.map(country => properties.push(country[property]));
    return properties;
}

export default App;
