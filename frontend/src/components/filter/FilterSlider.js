import React, {Component} from 'react';
import {Slider, Typography} from "@material-ui/core";

class FilterSlider extends Component {

    render() {
        const  { min, max, value } = this.props;
        return (
            <div className="range-slider">
                <Typography id="range-slider" gutterBottom>
                    Population
                </Typography>
                <Slider
                    value={value}
                    min={min}
                    max={max}
                    onChange={this.props.handleChange}
                    valueLabelDisplay="auto"
                    aria-labelledby="range-slider"
                />
            </div>
        );
    }
}

export default FilterSlider;