import React from 'react';
import Iframe from "react-iframe";

function Health(props) {
    const {description, stateHospital, thermalSpa, hospitalMap} = props.health;
    return (
        <div align={"center"}>
            <Iframe
                url="https://en.wikipedia.org/w/index.php?title=Healthcare_in_Hungary&printable=yes&fbclid=IwAR3sV-WlGUrv9zIz0qYObhIA6aWjlkrAnK86o-YSJBezDIR1-dYjbL_gSCA"
                width="1000px"
                height="1000px"
                id="Health Care"
                className="detail-card"
                display="initial"
                position="relative"/>
        </div>
    // {/*<div className="detail-card" id="Health Care">*/
    // }
    //
    // {/*    <h1>Health</h1>*/
    // }
    // {/*    <hr/>*/
    // }
    // {/*    <div className="detail-card-left-div">*/
    // }
    // {/*        <div dangerouslySetInnerHTML={{__html: description}}></div>*/
    // }
    // {/*    </div>*/
    // }
    // {/*    <div className="detail-card-right-div">*/
    // }
    // {/*        <h4>State Hospital</h4>*/
    // }
    // {/*        <img*/
    // }
    // {/*            src={stateHospital}*/
    // }
    // {/*            className="details-card-right-images"/>*/
    // }
    //
    // {/*        <h4>Thermal Spa in {props.country}</h4>*/
    // }
    // {/*        <img*/
    // }
    // {/*            src={thermalSpa}*/
    // }
    // {/*            className="details-card-right-images"/>*/
    // }
    // {/*        <h4>Main hospitals in {props.country}</h4>*/
    // }
    // {/*        <img*/
    // }
    // {/*            src={hospitalMap}*/
    // }
    // {/*            className="details-card-right-images"/>*/
    // }
    //
    //
    // {/*    </div>*/
    // }
    //  {/*</div>*/
    //  }

);
}

export default Health;