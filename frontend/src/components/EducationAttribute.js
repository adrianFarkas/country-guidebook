import React from 'react';
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {Typography} from "@material-ui/core";

function EducationAttribute(props) {
    const {text, icon} = props;

    const cardStyle = {
        width: "230px",
        height: "230px",
        display: "inline-grid",
        border: "2% #f3f3f3 solid",
        boxShadow: "0px 1px 3px rgba(0, 0, 0, 0.3)",
        transition: "all 0.3s linear",
        cursor: "pointer",
        backgroundColor: "#1db420",
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
        fontWeight: "bold",
        fontSize: "1.5rem"
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

export default EducationAttribute;