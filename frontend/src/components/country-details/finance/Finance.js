import React, {useContext} from 'react';
import Guide from "../Guide";
import CorruptionIndex from "./CorruptionIndex";
import FinanceAttributes from "./FinanceAttributes";
import {DetailsContext} from "../../../contexts/DetailsContext";

function Finance(props) {
    const {country} = useContext(DetailsContext);
    const {annualGdp, corruptionIndex, debt, gdpCapita} = country.details.finance;

    const style = {
        width: "50%",
        margin:"0 auto",
        boxShadow: "0px 0px 17px -10px rgba(0, 11, 109, 0.75)",
        borderRadius: "20px",
        padding: "20px",
        backgroundColor: "#f7fcff"

    };

    return (
        <Guide title="Finance" id="Finance">
            <div style={style}>
                <CorruptionIndex value={corruptionIndex}/>
                <FinanceAttributes attributes={{annualGdp, debt, gdpCapita}} />
            </div>
        </Guide>
    );
}

export default Finance;
