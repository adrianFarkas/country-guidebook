import React from 'react';
import {Typography} from "@material-ui/core";

function GeographicDescription(props) {
    const {text} = props;
    const cardStyle = {
            align: "center",
            width: "46%",
            transition: "all 0.3s linear",
            padding: "2px",
            textAlign: "justify",
            margin: "5%",
        }
    ;

    return (
        <div style={cardStyle}>
            <Typography variant="h6">{text}</Typography>
        </div>
    );
}

export default GeographicDescription;