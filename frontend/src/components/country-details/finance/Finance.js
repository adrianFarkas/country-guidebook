import React from 'react';
import Guide from "../Guide";
import CorruptionIndex from "./CorruptionIndex";
import FinanceAttributes from "./FinanceAttributes";

function Finance(props) {
    const {annualGdp, corruptionIndex, debt, gdpCapita} = props.finance;

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
