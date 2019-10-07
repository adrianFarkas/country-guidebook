import React from 'react';
import Iframe from "react-iframe";

function Finance() {
    return (
        <div align={"center"}>
            <Iframe
                url="https://en.wikipedia.org/w/index.php?title=Economy_of_Hungary&printable=yes&fbclid=IwAR3sV-WlGUrv9zIz0qYObhIA6aWjlkrAnK86o-YSJBezDIR1-dYjbL_gSCA"
                width="auto"
                height="auto"
                id="Finance"
                className="detail-card"
                display="initial"
                position="relative"/>
        </div>
    );
}

export default Finance;