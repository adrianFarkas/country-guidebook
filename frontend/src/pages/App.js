import React, {Component} from 'react';
import Header from "../components/Header";
import EuMap from "../components/EuMap";
import axios from "axios";

import FilterForm from "../components/filter/FilterForm";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            countries: [],
            countryCodes: [],
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
        axios.get("http://localhost:8080/")
            .then((res => this.setStateData(res)))
    }

    setStateData(response) {
        const countries = response.data;
        const population = this.getPropertiesFromCountries(countries, "population");
        const min = Math.min(...population), max = Math.max(...population);
        this.setState({
            countries: countries,
            countryCodes: this.getPropertiesFromCountries(countries, "alpha3Code"),
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
            "languages": [languages],
            "currency": [currency],
            "population": {
                "min": populationRange[0],
                "max": populationRange[1]
            }
        };
        axios.post("http://localhost:8080/filter", data)
            .then(res => console.log(res.data));
    }

    render() {
        const {slider, countryCodes} = this.state;
        return (
            <div className="App">
                <Header text="Country Guide"/>
                <FilterForm
                    handleChange={this.handleChange}
                    submitHandle={this.submitHandle}
                    slider={slider}/>
                <EuMap countryCodes={countryCodes}/>
            </div>
        );
    }
}

export default App;
