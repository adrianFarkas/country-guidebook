import React from 'react';
import Geographic from "./Geographic";
import Sights from "./Sights";
import Education from "./Education";
import Health from "./Health";
import Finance from "./Finance";

function Guides(props) {

    const {geographic, sights, education, health} = props.country;

    return (
        <div className="guides">
            <Geographic country={props.country.name} geographic={geographic}/>
            <Education education={education} />
            <Health health={health} />
            <Finance />
            <Sights sights={sights} />
        </div>
    );
}

export default Guides;