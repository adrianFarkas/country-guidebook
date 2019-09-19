import React, {Component} from 'react';

class FilterDropdown extends Component {

    capitalizeIfNotISOCode(letter) {
        if (letter.length > 3) {
            const lowercase = letter.toLowerCase();
            return lowercase.charAt(0).toUpperCase() + lowercase.slice(1)
        }
        return letter;
    }

    render() {
        const { category, data, name } = this.props;
        return (
            <div className="selection">
                <label className="label">{this.capitalizeIfNotISOCode(category)}</label>
                <select className="options" name={name}>
                    <option value="default">Default</option>
                    {data.map((option, index) =>
                        <option key={index} value={option}>{this.capitalizeIfNotISOCode(option)}</option>)}
                </select>
            </div>
        );
    }
}

export default FilterDropdown;