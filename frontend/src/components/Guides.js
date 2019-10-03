import React from 'react';
import Finance from "./Finance";
import Education from "./Education";
import Health from "./Health";

function Guides(props) {
    return (
        <div className="guides">
            <Finance/>
            <Education/>
            <Health/>
        </div>
    );
}

export default Guides;

