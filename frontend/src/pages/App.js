import React, {Component} from 'react';
import Header from "../components/Header";
import EuMap from "../components/EuMap";
import axios from "axios";

import FilterForm from "../components/filter/FilterForm";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            countryCodes: [],
            languages: [],
            currencies: [],
            slider: {
                min: 0,
                max: 0,
                values: [0, 0]
            },
        };
        this.submitHandle = this.submitHandle.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }


    componentDidMount() {
        axios.get("http://localhost:8080/all")
            .then((res => this.setStateData(res.data)))
    }

    setStateData(data) {
        const population = this.getPropertiesFromCountries(data["countries"], "population");
        const min = Math.min(...population), max = Math.max(...population);
        this.setState({
            countryCodes: this.getPropertiesFromCountries(data["countries"], "alpha3Code"),
            languages: data["languages"],
            currencies: data["currencies"],
            slider: {
                min: min,
                max: max,
                values: [min, max]
            }
        })
    }

    getPropertiesFromCountries(countryList, property) {
        const properties = [];
        countryList.map(country => properties.push(country[property]));
        return properties;
    }

    handleChange(e, newValue) {
        this.setState(prevState => prevState.slider.values = newValue);
    }

    submitHandle(event) {
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
            .then(res => this.setState(prevState =>
                prevState.countryCodes = this.getPropertiesFromCountries(res.data, "alpha3Code")));
    }

    render() {
        const {slider, countryCodes, languages, currencies} = this.state;
        return (
            <div className="App">
                <Header text="Country Guide"/>
                <FilterForm
                    languages={languages}
                    currencies={currencies}
                    slider={slider}
                    handleChange={this.handleChange}
                    submitHandle={this.submitHandle}
                />
                <EuMap
                    countryCodes={countryCodes}
                />
            </div>
        );
    }
}

export default App;
