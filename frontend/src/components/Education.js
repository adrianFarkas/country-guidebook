import React from 'react';
import {faBalanceScaleLeft, faBookReader, faBrain, faMoneyBill} from "@fortawesome/free-solid-svg-icons";
import Guide from "./Guide";
import EducationAttribute from "./EducationAttribute";

function Education(props) {
    const {averageIq, compulsoryYears, expenditure, spending} = props.education;
    return (
        <Guide title="Education" id="Education">
            <EducationAttribute icon={faBrain} text={averageIq}/>
            <EducationAttribute icon={faBookReader} text={compulsoryYears + " year(s)"}/>
            <EducationAttribute icon={faBalanceScaleLeft} text={expenditure + " %"}/>
            <EducationAttribute icon={faMoneyBill} text={spending + " M $"}/>
        </Guide>
    );
}

export default Education;