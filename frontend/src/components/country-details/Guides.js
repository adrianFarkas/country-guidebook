import React from 'react';
import Geographic from "./geography/Geographic";
import Sights from "./sights/Sights";
import Education from "./education/Education";
import Health from "./health/Health";
import Finance from "./finance/Finance";

function Guides(props) {

    const {geographic, sights, education, health, finance} = props.country;

    return (
        <div className="guides">
            <Geographic country={props.country.name} geographic={geographic}/>
            <Education education={education} />
            <Health health={health} />
            <Finance finance={finance} />
            <Sights sights={sights} />
        </div>
    );
}

export default Guides;