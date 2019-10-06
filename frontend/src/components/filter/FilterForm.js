import React, {useContext} from 'react';
import FilterDropdown from "./FilterDropdown";
import {Button} from "react-bootstrap";
import FilterSlider from "./FilterSlider";
import {RootContext} from "../../contexts/RootContext";

function FilterForm(props) {
    const {state, filterCountries} = useContext(RootContext);
    const {languages, currencies} = state;

    const submitHandle = (event) => {
        event.preventDefault();
        const form = event.target;
        const languages = !form.languages.value ? [] : form.languages.value.split(","),
            currency = !form.currency.value ? [] : form.currency.value.split(","),
            population = form.slider.value.split(",");
        filterCountries(languages, currency, population);

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

export default FilterForm;