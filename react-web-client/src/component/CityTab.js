import React, {Component} from "react";
import api from "../api/service/WeatherApi"

class WeatherTab extends Component {
    constructor() {
        super();
        this.state = {
            addCityText: ""
        };
    }

    _addCity = (cityName) => {
        alert(cityName);
        api.createCity(cityName);
    };

    render() {
        let that = this;
        return (
            <div>
                <p><b> City Tab </b></p>
                <input onChange={(e) => that.setState({addCityText: e.target.value})}/>
                <button onClick={() => that._addCity(that.state.addCityText)}>Add</button>
            </div>
        )
    }
}
export default WeatherTab