import React from 'react';
import Guide from "./Guide";


function Geographic(props) {
    const {description, capital, population, area, timeZones, callingCodes} = props.geographic;
    return (
        <div id="Geographic">
            <Guide title="Geographic">

            </Guide>
        </div>
    );
}

export default Geographic;