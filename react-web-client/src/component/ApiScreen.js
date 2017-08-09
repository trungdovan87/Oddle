import React, {Component} from "react";
import api from "../api/service/WeatherApi"

class ApiScreen extends Component {
    constructor() {
        super();
        this.state = {
        };
        // this.onTextChange = this.onTextChange.bind(this);
    }

    onTextChange = (event) => {
        let that = this;
        api.searchWeather(event.target.value).then(
            json => {
                if (json.status === 0) {
                    that.setState({cities: json.data})
                } else {
                    alert("Error: " + json);
                }
            }
        );
    };

    componentDidMount() {
        this.nameInput.focus();
    }

    _convertCityToLI(city) {

        return (
            <li key={city.cityId}>
                <b> {city.cityName} </b> ({city.createDate})

                <br/>
                temp: {city.temperature} degree | {city.status} | {city.windy} m/s | {city.humidity}% | {city.pressure} hpa

            </li>
        )
    }

    _result() {
        if (this.state.cities === undefined) {
            return <div> Type city name to search </div>;
        }  else if (this.state.cities.length === 0) {
            return <div> No result </div>
        } else {
            return (
                <ul>
                    {this.state.cities.map(this._convertCityToLI)}
                </ul>
            )
        }
    }


    render() {
        return (
            <div>
                <h1>End-User Screen</h1>
                <input type="text" onChange={this.onTextChange} ref={(input) => {
                    this.nameInput = input;
                }}/>
                <p/>
                {this._result()}
                <p>---------------</p>
                <a href=""
                   onClick={(e) => { e.preventDefault(); this.props.selectScreen("home")}}
                >
                    HOME
                </a>
            </div>
        );
    }
}

export default ApiScreen;