import React from 'react';
import Finance from "./Finance";
import Education from "./Education";
import Geographic from "./Geographic";
import Health from "./Health";
import Sights from "./Sights";

function Guides(props) {
    return (
        <div className="guides">
            <Geographic/>
            <Education/>
            <Sights/>
            <Health/>
            <Finance/>
        </div>
    );
}

export default Guides;

