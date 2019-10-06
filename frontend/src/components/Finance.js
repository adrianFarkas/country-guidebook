import React from 'react';
import Iframe from "react-iframe";

function Finance(props) {
    const {description, stateDebtMillionEuro, averageSalaryEUR, minimumWageEUR} = props.finance;

    return (
        <div className="detail-card" id="Finance">

            <h1>Finance</h1>
            <hr/>
            <div className="detail-card-left-div">
                <Iframe
                    url="https://en.wikipedia.org/w/index.php?title=Economy_of_Hungary&printable=yes&fbclid=IwAR3sV-WlGUrv9zIz0qYObhIA6aWjlkrAnK86o-YSJBezDIR1-dYjbL_gSCA"
                    width="1000px"
                    height="1000px"
                    id="myId"
                    className="myClassname"
                    display="initial"
                    position="relative"/>
                {/*<div dangerouslySetInnerHTML={{ __html: description }}></div>*/}
            </div>
            <div className="detail-card-right-div">
                <h4>State debt in million Euro</h4>
                <img
                    src={stateDebtMillionEuro}
                    className="details-card-right-images" alt=""/>
                <h4>Average Salary in {props.currency}</h4>
                <img
                    src={averageSalaryEUR}
                    className="details-card-right-images" alt=""/>
                <h4>Minimum Wage in Euro</h4>
                <img
                    src={minimumWageEUR}
                    className="details-card-right-images" alt=""/>

            </div>
        </div>
    );
}

export default Finance;
