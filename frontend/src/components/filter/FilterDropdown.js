import React from 'react';

function FilterDropdown(props) {

    const { category, data, name } = props;
    return (
        <div className="selection">
            <label className="label">{capitalizeIfNotISOCode(category)}</label>
            <select className="options" name={name}>
                <option value="default">Default</option>
                {data.map((option, index) =>
                    <option key={index} value={option}>{capitalizeIfNotISOCode(option)}</option>)}
            </select>
        </div>
    );
}

function capitalizeIfNotISOCode(letter) {
    if (letter.length > 3) {
        const lowercase = letter.toLowerCase();
        return lowercase.charAt(0).toUpperCase() + lowercase.slice(1)
    }
    return letter;
}



export default FilterDropdown;