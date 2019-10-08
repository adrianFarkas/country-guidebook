import React from 'react';

function LinkCard(props) {
    return (
        <div className="link-card">
            <a href={"#"+props.title}>
                <img src={props.img} width={100} height={100} alt="" title={props.title}/>
            </a>
        </div>
    );
}

export default LinkCard;