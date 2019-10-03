import React from 'react';

function SightCard(props) {
    const {index, picture, city, address, title} = props.property;
    return (
        <div id={`card-${index}`} className="card">
            <img src={picture} alt={city} />
            <div className="card-title">{title}</div>
            <div className="details">
                <p className="location">
                    {city}<br />
                    {address}
                </p>
            </div>
        </div>
    )
}

export default SightCard;