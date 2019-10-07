import React from 'react';
import Iframe from "react-iframe";

function Education() {
    return (
        <div align={"center"}>
            <Iframe
                url="https://en.wikipedia.org/w/index.php?title=Education_in_Hungary&printable=yes&fbclid=IwAR3sV-WlGUrv9zIz0qYObhIA6aWjlkrAnK86o-YSJBezDIR1-dYjbL_gSCA"
                width="auto"
                height="auto"
                id="Education"
                className="detail-card"
                display="initial"
                position="relative"/>
        </div>
    );
}

export default Education;