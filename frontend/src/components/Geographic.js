import React from 'react';
import Iframe from "react-iframe";

function Geographic() {
    return (
            <div align={"center"}>
                <Iframe
                    url="https://en.wikipedia.org/w/index.php?title=Geography_of_Hungary&printable=yes&fbclid=IwAR3sV-WlGUrv9zIz0qYObhIA6aWjlkrAnK86o-YSJBezDIR1-dYjbL_gSCA"
                    width="auto"
                    height="auto"
                    id="Geographic"
                    className="detail-card"
                    display="initial"
                    position="relative"/>
            </div>
    );
}

export default Geographic;