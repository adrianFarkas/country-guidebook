import React from 'react';
import Finance from "./Finance";
import Education from "./Education";
import Geographic from "./Geographic";
import Health from "./Health";

function Guides(props) {
    return (
        <div className="guides">
            <Finance/>
            <Geographic/>
            <Education/>
            <Health/>
        </div>
    );
}

export default Guides;

