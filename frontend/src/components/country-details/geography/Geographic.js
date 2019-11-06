import React, {useContext} from 'react';
import Guide from "../Guide";
import {faChartArea, faClock, faMapMarked, faPhone, faStreetView} from "@fortawesome/free-solid-svg-icons";
import GeographicAttribute from "./GeographicAttribute";
import GeographicDescription from "./GeographicDescription";
import {DetailsContext} from "../../../contexts/DetailsContext";

function Geographic(props) {
    const {country} = useContext(DetailsContext);
    const {description, capital, population, area, timeZones, callingCodes} = country.details.geographic;

    return (
        <Guide title="Geographic" id="Geographic">
            <div align={"center"}>
            <GeographicDescription text={description}/>
            </div>
            <GeographicAttribute icon={faMapMarked} text={capital}/>
            <GeographicAttribute icon={faStreetView} text={population + " people"}/>
            <GeographicAttribute icon={faChartArea} text={area + " km2"}/>
            <GeographicAttribute icon={faClock} text={timeZones[0] + " hour(s)"}/>
            <GeographicAttribute icon={faPhone} text={"(+" + callingCodes + ")"}/>
        </Guide>
    );
}

export default Geographic;