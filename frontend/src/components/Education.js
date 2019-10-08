import React from 'react';

function Education(props) {
    const {description, spending, federal, educationIndex} = props.units;
    return (
        <div className="detail-card" id="Education">

            <h1>Education</h1>
            <hr/>
            <div className="detail-card-left-div">
                <div dangerouslySetInnerHTML={{ __html: description }}></div>
            </div>
            <div className="detail-card-right-div">
                <h4>Public spending on education</h4>
                <img
                    src={spending}
                    className="details-card-right-images"/>

                <h4>Federal educational system</h4>
                <img
                    src={federal}
                    className="details-card-right-images"/>
                <h4>2020 education index</h4>
                <img
                    src={educationIndex}
                    className="details-card-right-images"/>

            </div>
        </div>
    );
}

export default Education;