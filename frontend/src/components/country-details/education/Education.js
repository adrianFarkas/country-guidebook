import React from 'react';
import {faBalanceScaleLeft, faBookReader, faBrain, faMoneyBill} from "@fortawesome/free-solid-svg-icons";
import Guide from "../Guide";
import EducationAttribute from "./EducationAttribute";

function Education(props) {
    const {averageIq, compulsoryYears, expenditure, spending} = props.education;
    return (
        <Guide title="Education" id="Education">
            <EducationAttribute icon={faBrain} value={averageIq} text={"Average IQ"}/>
            <EducationAttribute icon={faBookReader} value={compulsoryYears + " year(s)"} text={"Compulsory Years"}/>
            <EducationAttribute icon={faBalanceScaleLeft} value={expenditure + " %"} text={"Expenditure of Total Government "}/>
            <EducationAttribute icon={faMoneyBill} value={spending + " M $"} text={"Education expenditure"}/>
        </Guide>
    );
}

export default Education;