import React, {Component} from 'react';
import FilterDropdown from "./FilterDropdown";
import "../../css/filter.css"
import {Button, Card} from "react-bootstrap";
import FilterSlider from "./FilterSlider";

class FilterForm extends Component {

    render() {
        const { min, max, values } = this.props.slider;
        return (
            <div className="col col-sm-4 filter-form">
                <Card className="filters">
                    <form onSubmit={this.props.submitHandle} className="selectors">
                        <FilterDropdown category="languages"/>
                        <FilterDropdown category="currency"/>
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