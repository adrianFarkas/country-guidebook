import React, {Component} from 'react';
import FilterDropdown from "./FilterDropdown";
import "../../css/filter.css"
import {Card} from "react-bootstrap";
import FilterSlider from "./FilterSlider";

class FilterForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
            min: 0,
            max: 100000,
            values: [0, 100000]
        };
        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(event, newValue){
        this.setState({values: newValue});
    };

    render() {
        const { min, max, values } = this.state;
        return (
            <div className="col col-sm-4 filter-form">
                <Card className="filters">
                    <form className="selectors">
                        <FilterDropdown/>
                        <FilterDropdown/>
                        <FilterSlider handleChange={this.handleChange} value={values} min={min} max={max}/>
                    </form>
                </Card>
            </div>
        );
    }
}

export default FilterForm;