import React, {Component} from 'react';
import {Slider, Typography, TextField} from "@material-ui/core";

class FilterSlider extends Component {

    render() {
        const  { min, max, value } = this.props;
        return (
            <div className="range-slider">
                <Typography id="range-slider" gutterBottom>
                    Population
                </Typography>
                <Slider
                    name="slider"
                    value={value}
                    min={min}
                    max={max}
                    onChange={this.props.handleChange}
                    aria-labelledby="range-slider"
                    style={{color: "#428bca"}}
                />
                <TextField
                    className="population-number"
                    label="Min"
                    value={value[0]}
                    margin="normal"
                    variant="outlined"
                    disabled
                />
                <TextField
                    className="population-number"
                    label="Max"
                    value={value[1]}
                    margin="normal"
                    variant="outlined"
                    disabled
                />
            </div>
        );
    }
}

export default FilterSlider;