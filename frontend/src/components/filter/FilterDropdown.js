import React, {Component} from 'react';

class FilterDropdown extends Component {
    render() {
        // const { category, handleChange } = this.props
        return (
            <div className="selection">
                <label className="label">Sort by {this.props.category}</label>
                <select className="options" name={this.props.category}>
                    <option value="FRENCH">French</option>
                    <option value="Euro">Euro</option>
                    <option value="3">Option 3</option>
                    <option value="4">Option 4</option>
                    <option value="5">Option 5</option>
                </select>
            </div>
        );
    }
}

export default FilterDropdown;