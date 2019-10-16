import React from 'react';
import Geographic from "./Geographic";

function Guides(props) {

    const {geographic} = props.country;

    return (
        <div className="guides">
            <Geographic country={props.country.name} geographic={geographic}/>
        </div>
    );
}

export default Guides;