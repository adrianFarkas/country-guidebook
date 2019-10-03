import React from 'react';
import Finance from "./Finance";
import Education from "./Education";
import Geographic from "./Geographic";

function Guides(props) {
    return (
        <div className="guides">
            <Finance/>
            <Geographic/>
            <Education/>
        </div>
    );
}

export default Guides;

