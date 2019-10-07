import React from 'react';
import Iframe from "react-iframe";

function Health(props) {
    const {description, stateHospital, thermalSpa, hospitalMap} = props.health;
    return (
        <div align={"center"}>
            <Iframe
                url="https://en.wikipedia.org/w/index.php?title=Healthcare_in_Hungary&printable=yes"
                width="auto"
                height="auto"
                id="Health Care"
                className="detail-card"
                display="initial"
                position="relative"/>
        </div>
);
}

export default Health;