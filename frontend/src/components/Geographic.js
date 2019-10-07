import React from 'react';
import Iframe from "react-iframe";

function Geographic() {
    return (
        <div>
            <div align={"center"}>
                <Iframe
                    url="https://en.wikipedia.org/w/index.php?title=Education_in_Hungary&printable=yes&fbclid=IwAR3sV-WlGUrv9zIz0qYObhIA6aWjlkrAnK86o-YSJBezDIR1-dYjbL_gSCA"
                    width="1000px"
                    height="1000px"
                    id="Education"
                    className="detail-card"
                    display="initial"
                    position="relative"/>
            </div>
        </div>
    );
}

export default Geographic;