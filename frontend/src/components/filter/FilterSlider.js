import React from 'react';
import {Slider, Typography, TextField} from "@material-ui/core";
import {connect} from "react-redux";
import { changeSlider } from '../../actions/index';

function FilterSlider(props) {
    const  { min, max, values } = props;

    const handleChange = (e, newValue) => {
        props.changeSlider({min, max, values: newValue});
    };

    return (
        <div className="range-slider">
            <Typography id="range-slider" gutterBottom>
                Population
            </Typography>
            <Slider
                name="slider"
                value={values}
                min={min}
                max={max}
                onChange={handleChange}
                aria-labelledby="range-slider"
                style={{color: "#428bca"}}
            />
            <TextField
                className="population-number"
                label="Min"
                value={values[0]}
                margin="normal"
                variant="outlined"
                disabled
            />
            <TextField
                className="population-number"
                label="Max"
                value={values[1]}
                margin="normal"
                variant="outlined"
                disabled
            />
        </div>
    );
}

const mapStateToProps = (state) => {
    return state.slider;
};

export default connect(mapStateToProps, {changeSlider})(FilterSlider);