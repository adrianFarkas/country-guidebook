import React from 'react';
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";

function GeographicAttribute(props) {
    const {text, icon} = props;

    const cardStyle = {
        width: "230px",
        height: "230px",
        display: "inline-grid",
        boxShadow: "4px 4px 10px rgba(0, 0, 0, 0.3)",
        transition: "all 0.3s linear",
        cursor: "pointer",
        backgroundColor: "#45a2b4",
        padding: "2px",
        align: "center",
        margin: "2%",
        borderRadius: "50%",
        color: "#ffffff"
    };

    const iconStyle = {
        align: "center",
        marginTop: "20%"
    };

    const textStyle = {
        fontFamily: "Verdana",
        fontSize: "1.15rem"
    };

    return (
        <div style={cardStyle}>
            <div style={iconStyle}>
                <FontAwesomeIcon icon={icon} size={"4x"}/><br/>
            </div>
            <div style={textStyle}>{text}</div>
        </div>
    );
}

export default GeographicAttribute;