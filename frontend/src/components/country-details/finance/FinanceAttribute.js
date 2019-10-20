import React from 'react';
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";

function FinanceAttribute(props) {
    return (
        <div style={{flex: "1"}}>
            <div><FontAwesomeIcon color={"#3b52d4"} icon={props.icon} /> {props.title}</div>
            <div style={{fontSize: "20px", fontWeight: "bold"}}>{props.value}</div>
        </div>
    );
}

export default FinanceAttribute;