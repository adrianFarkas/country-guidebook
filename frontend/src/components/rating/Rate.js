import React from 'react';
import Rating from "@material-ui/lab/Rating";
import Box from "@material-ui/core/Box";

function Rate(props) {
    const {hover, value, handleChange, handleClick, disabled, title} = props;

    const labels = {
        1: 'Poor',
        2: 'Fair',
        3: 'Good',
        4: 'Very Good',
        5: 'Excellent',
    };

    const style = {
        width: "300px",
        display: 'flex',
        alignItems: 'center',
        fontWeight: "bold"
    };

    const titleBox = disabled ? <Box ml={1}>{title}</Box> : <Box ml={1}>{labels[hover !== 0 ? hover : value]}</Box>;


    return (
        <div style={style}>
            <Rating
                name="hover-side"
                value={value}
                precision={1}
                onChangeActive={handleChange}
                onMouseUp={handleClick}
                disabled={disabled ? disabled : false}
            />
            {titleBox}
        </div>
    );
}

export default Rate;