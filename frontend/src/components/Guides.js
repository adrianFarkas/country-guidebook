import React from 'react';
import Geographic from "./Geographic";
import Sights from "./Sights";
import Education from "./Education";
import Health from "./Health";
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