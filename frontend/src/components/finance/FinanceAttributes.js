import React from 'react';
import FinanceAttribute from "./FinanceAttribute";
import {faBalanceScaleLeft, faFileInvoiceDollar, faPiggyBank} from "@fortawesome/free-solid-svg-icons";

function FinanceAttributes(props) {
    const {annualGdp, debt, gdpCapita} = props.attributes;

    const cardStyle = {
        display: "flex",
        width: "700px",
        margin:" 60px auto 0",
        height: "100px",
        textAlign: "center"

    };

    const numberFormat = (number) => {
        return number.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".");
    };

    return (
        <div style={cardStyle}>
            <FinanceAttribute
                title={"Annual GDP (million dollar)"}
                value={numberFormat(annualGdp)}
                icon={faBalanceScaleLeft}
            />
            <FinanceAttribute
                title={"Debt (million dollar)"}
                value={numberFormat(debt)}
                icon={faFileInvoiceDollar}
            />
            <FinanceAttribute
                title={"GDP / Capita (dollar)"}
                value={numberFormat(gdpCapita)}
                icon={faPiggyBank}
            />
        </div>
    );
}

export default FinanceAttributes;