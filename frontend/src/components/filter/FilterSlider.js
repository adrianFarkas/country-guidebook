import React, {useContext} from 'react';
import {Slider, Typography, TextField} from "@material-ui/core";
import {RootContext} from "../../contexts/RootContext";

function FilterSlider(props) {
    const  { state, dispatch } = useContext(RootContext);
    const  { min, max, values } = state.slider;

    const handleChange = (e, newValue) => {
        const data = {min, max, values: newValue};
            dispatch({type: "CHANGE_SLIDER", data});
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

export default FilterSlider;