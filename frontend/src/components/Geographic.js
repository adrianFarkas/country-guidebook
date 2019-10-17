import React from 'react';
import Guide from "./Guide";
import {Typography} from "@material-ui/core";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {
    faChartArea,
    faClock,
    faEnvelopeOpenText,
    faMapMarked,
    faPhone,
    faStreetView
} from "@fortawesome/free-solid-svg-icons";

function Geographic(props) {
    const {description, capital, population, area, timeZones, callingCodes} = props.geographic;
    return (
        <Guide title="Geographic" id="Geographic">
            <div className={"card"} align={"center"}>
                <FontAwesomeIcon icon={faEnvelopeOpenText} size={"3x"}/><br/>
                <Typography variant="body1" align={"justify"}>{description}</Typography>
            </div>
            <div className={"card"} align={"center"} style={{width: "20%", display: "inline-grid"}}>
                <FontAwesomeIcon icon={faMapMarked} size={"3x"}/><br/>
                <Typography variant="body1">{capital}</Typography>
            </div>
            <div className={"card"} align={"center"} style={{width: "20%", display: "inline-grid"}}>
                <FontAwesomeIcon icon={faStreetView} size={"3x"}/><br/>
                <Typography variant="body1">{population} people</Typography>
            </div>
            <div className={"card"} align={"center"} style={{width: "20%", display: "inline-grid"}}>
                <FontAwesomeIcon icon={faChartArea} size={"3x"}/><br/>
                <Typography variant="body1">{area} km2</Typography>
            </div>
            <div className={"card"} align={"center"} style={{width: "20%", display: "inline-grid"}}>
                <FontAwesomeIcon icon={faClock} size={"3x"}/><br/>
                <Typography variant="body1">{timeZones[0]} hour(s)</Typography>
            </div>
            <div className={"card"} align={"center"} style={{width: "20%", display: "inline-grid"}}>
                <FontAwesomeIcon icon={faPhone} size={"3x"}/><br/>
                <Typography variant="body1">(+{callingCodes})</Typography>
            </div>
        </Guide>
    );
}

export default Geographic;