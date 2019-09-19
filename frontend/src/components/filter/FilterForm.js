import React, {Component} from 'react';
import FilterDropdown from "./FilterDropdown";
import "../../css/filter.css"
import {Button, Card} from "react-bootstrap";
import FilterSlider from "./FilterSlider";

class FilterForm extends Component {

    render() {
        const {languages, currencies, slider}= this.props;
        const { min, max, values } = slider;
        return (
            <div className="col col-sm-4 filter-form">
                <Card className="filters">
                    <div className="filter-title">Filter</div>
                    <form onSubmit={this.props.submitHandle} className="selectors">
                        <FilterDropdown name="languages" data={languages} category="languages"/>
                        <FilterDropdown name="currency" data={currencies} category="currencies"/>
                        <FilterSlider
                            handleChange={this.props.handleChange}
                            value={values}
                            min={min}
                            max={max}/>
                        <Button variant="primary" type="submit" block>Filter</Button>
                    </form>
                </Card>
            </div>
        );
    }
}

export default FilterForm;