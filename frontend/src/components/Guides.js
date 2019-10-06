import React from 'react';
import Finance from "./Finance";
import Education from "./Education";
import Geographic from "./Geographic";
import Health from "./Health";
import Sights from "./Sights";
import Iframe from 'react-iframe';

function Guides(props) {

    const {units, sights, health, geographic, finance} = props.country;

    return (
        <div className="guides">
            <Geographic country={props.country.name} geographic={geographic}/>
            <Education units={units}/>
            <Sights sights={sights}/>
            <Health country={props.country.name} health={health}/>
            <Finance currency={units.currencies[0]} finance={finance}/>
            <Iframe url="http://www.youtube.com/embed/xDMP3i36naA"
                    width="450px"
                    height="450px"
                    id="myId"
                    className="myClassname"
                    display="initial"
                    position="relative"/>
        </div>
    );
}

export default Guides;

