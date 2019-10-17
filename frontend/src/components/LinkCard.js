import React from 'react';
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";

function LinkCard(props) {
    return (
        <div className="link-wrapper">
            <div className="link-card-cont">
                <div className="link-card">
                    <a href={"#"+ props.title}>
                        <FontAwesomeIcon className="link-icon" size={"4x"} color={"#3d6ab4"} icon={props.icon}/>
                    </a>
                </div>
            </div>
            <div className="link-title">{props.title}</div>
        </div>
    );
}

export default LinkCard;