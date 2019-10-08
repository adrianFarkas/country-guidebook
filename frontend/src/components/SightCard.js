import React from 'react';

function SightCard(props) {
    const {index, name, city, imageName} = props.property;
    return (
        <div id={`card-${index}`} className="card">
            <img src={"/static/img/sights/"+imageName} alt={city} />
            <div className="card-title">{name}</div>
            <div className="details">
                <p className="location">
                    {city}
                </p>
            </div>
        </div>
    )
}

export default SightCard;