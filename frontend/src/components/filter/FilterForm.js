import React from 'react';
import FilterDropdown from "./FilterDropdown";
import "../../css/filter.css"
import {Button} from "react-bootstrap";
import FilterSlider from "./FilterSlider";
import {connect} from "react-redux";
import axios from "axios"
import {filterCountries} from '../../actions/index'

function FilterForm(props) {
    const {languages, currencies} = props;

    const submitHandle = (event) => {
        event.preventDefault();
        const form = event.target;
        const languages = !form.languages.value ? [] : form.languages.value.split(","),
            currency = !form.currency.value ? [] : form.currency.value.split(","),
            populationRange = form.slider.value.split(",");
        const data = {
            "languages": languages,
            "currency": currency,
            "population_min" : populationRange[0],
            "population_max" : populationRange[1]
        //    "population": {
         //       "min": populationRange[0],
        //        "max": populationRange[1]
            //}
        };
        axios.post("http://localhost:8080/filter-countries", data)
            .then(res => props.filterCountries(res.data));
    };

    return (
        <div className="filters">
            <div className="filter-title">Filter</div>
            <form onSubmit={submitHandle} className="selectors">
                <FilterDropdown name="languages" data={languages} category="languages"/>
                <FilterDropdown name="currency" data={currencies} category="currencies"/>
                <FilterSlider />
                <Button variant="primary" type="submit" block>Filter</Button>
            </form>
        </div>
    );
}


const mapStateToProps = (state) => {
    return state;
};

export default connect(mapStateToProps,{filterCountries})(FilterForm);