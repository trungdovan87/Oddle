import React, {Component} from "react";
import api from "../api/service/WeatherApi";

class WeatherTab extends Component {
    constructor() {
        super();
        this.state = {};
    }

    _getCityById = () => {
        let id = parseInt(this.idInput.value.trim(), 10);
        let that = this;
        if (!isNaN(id)) {
            api.getLogByCityId(id).then( (json) => {
                if (json.status === 0) {
                    that.setState({logs: json.data});
                }
            })
        } else {
            alert(this.idInput.value + " is not Number");
        }
    }

    _convertLogToLI = (city) => {
        return (
            <li key={city.cityId}>
                <b> {city.cityName} </b> ({city.createDate})

                <br/>
                temp: {city.temperature} degree | {city.status} | {city.windy} m/s | {city.humidity}% | {city.pressure} hpa | --
                <button>delete</button>
            </li>
        )
    }

    _result = () => {
        if (this.state.logs === undefined) {
            return <div> Type city name to search </div>;
        }  else if (this.state.logs.length === 0) {
            return <div> No result </div>
        } else {
            return (
                <ul>
                    {this.state.logs.map(this._convertLogToLI)}
                </ul>
            )
        }
    }

    componentDidMount() {
        this.idInput.focus();
    }

    render(){
        return (
            <div>
                <p><b> Log Tab </b></p>
                id city:
                <input pattern="[0-9]*" ref={(input) => {
                    this.idInput = input;
                }}/>

                <button onClick={this._getCityById}>Get Log</button>
                {this._result()}
            </div>
        )
    }
}

export default WeatherTab
