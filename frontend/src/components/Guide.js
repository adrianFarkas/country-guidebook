import React from 'react';

function Guide(props) {
    return (
        <div className="guide">
            <div className="guide-title">
                {props.title}
            </div>
            <div className="guide-title-underline"/>
            <div className="guide-content">
                {props.children}
            </div>
        </div>
    );
}

export default Guide;