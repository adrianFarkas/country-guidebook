import React, {useContext} from 'react';
import {faBalanceScaleLeft, faBookReader, faBrain, faMoneyBill} from "@fortawesome/free-solid-svg-icons";
import Guide from "../Guide";
import EducationAttribute from "./EducationAttribute";
import {DetailsContext} from "../../../contexts/DetailsContext";

function Education(props) {
    const {country} = useContext(DetailsContext);
    const {averageIq, compulsoryYears, expenditure, spending} = country.details.education;

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