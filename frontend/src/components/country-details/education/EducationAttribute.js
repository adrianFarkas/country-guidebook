import React from 'react';
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";

function EducationAttribute(props) {
    const {text, icon, value} = props;

    const cardStyle = {
        width: "15rem",
        height: "15rem",
        display: "inline-grid",
        border: "2% #f3f3f3 solid",
        boxShadow: "0.25rem 0.25rem 0.75rem rgba(0, 0, 0, 0.3)",
        transition: "all 0.3s linear",
        backgroundColor: "#1db420",
        padding: "0.25rem",
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
        fontSize: "1.5rem"
    };

    return (
        <div style={cardStyle}>
            <div style={iconStyle}>
                <FontAwesomeIcon icon={icon} size={"3x"}/><br/>
                <div style={{marginTop: "20px"}}>{text}</div>
            </div>
            <div style={textStyle}>{value}</div>
        </div>
    );
}

export default EducationAttribute;