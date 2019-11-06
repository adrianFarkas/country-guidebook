import React from 'react';
import Geographic from "./geography/Geographic";
import Sights from "./sights/Sights";
import Education from "./education/Education";
import Health from "./health/Health";
import Finance from "./finance/Finance";

function Guides(props) {

    return (
        <div className="guides">
            <Geographic/>
            <Education />
            <Health />
            <Finance />
            <Sights />
        </div>
    );
}

export default Guides;