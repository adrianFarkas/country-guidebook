import React from 'react';
import Iframe from "react-iframe";

function Education(props) {
    const {description, spending, federal, educationIndex} = props.units;
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
    //     <div className="detail-card" id="Education">
    //
    //         <h1>Education</h1>
    //         <hr/>
    //         <div className="detail-card-left-div">
    //             <div dangerouslySetInnerHTML={{ __html: description }}></div>
    //         </div>
    //         <div className="detail-card-right-div">
    //             <h4>Public spending on education</h4>
    //             <img
    //                 src={spending}
    //                 className="details-card-right-images"/>
    //
    //             <h4>Federal educational system</h4>
    //             <img
    //                 src={federal}
    //                 className="details-card-right-images"/>
    //             <h4>2020 education index</h4>
    //             <img
    //                 src={educationIndex}
    //                 className="details-card-right-images"/>
    //
    //         </div>
    //     </div>
    );
}

export default Education;