import React from 'react';

function Health(props) {
    const {description, stateHospital, thermalSpa, hospitalMap} = props.health;
    return (
        <div className="detail-card" id="Health Care">

            <h1>Health</h1>
            <hr/>
            <div className="detail-card-left-div">
                {description}
            </div>
            <div className="detail-card-right-div">
                <h4>State Hospital</h4>
                <img
                    src={stateHospital}
                    className="details-card-right-images"/>

                <h4>Thermal Spa in {props.country}</h4>
                <img
                    src={thermalSpa}
                    className="details-card-right-images"/>
                <h4>Main hospitals in {props.country}</h4>
                <img
                    src={hospitalMap}
                    className="details-card-right-images"/>


            </div>
        </div>
    );
}

export default Health;