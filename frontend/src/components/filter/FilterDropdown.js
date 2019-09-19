import React, {Component} from 'react';

class FilterDropdown extends Component {

    capitalizeIfLanguage(letter) {
        if (letter.length > 3) {
            const lowercase = letter.toLowerCase();
            return lowercase.charAt(0).toUpperCase() + lowercase.slice(1)
        }
        return letter;
    }

    render() {
        const { category, data } = this.props;
        return (
            <div className="selection">
                <label className="label">Sort by {category}</label>
                <select className="options" name={category}>
                    <option value="default">Default</option>
                    {data.map((option, index) =>
                        <option key={index} value={option}>{this.capitalizeIfLanguage(option)}</option>)}
                </select>
            </div>
        );
    }
}

export default FilterDropdown;