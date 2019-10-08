import React from 'react';

function Geographic(props) {
    const {description, capital, population, area, timeZones, callingCodes, mapLink} = props.geographic;
    return (
        <div className="detail-card" id="Geographic">

            <h1>Geographic</h1>
            <hr/>
            <div className="detail-card-left-div">
                <div dangerouslySetInnerHTML={{ __html: description }}></div>

            </div>
            <div className="detail-card-right-div">
                <h4>Geography of {props.country}</h4>
                <img
                    src={mapLink}
                    className="details-card-right-images"/>

                <h4>Capital</h4>
                {capital}

                <h4>Population:</h4>
                {population}

                <h4>Area:</h4>
                {area} m<sup>2</sup>

                <h4>Timezone</h4>
                {timeZones[0]}

                <h4>Calling Code</h4>
                {callingCodes[0]}


            </div>
        </div>
    );
}

export default Geographic;