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
        api.createCity(cityName).then(json => {
            if (json.status === 0) {
                alert("add city SUCCESS")
            } else {
                alert("add city Failure, error:\n" + JSON.stringify(json, null, 2));
            }
        });
    };

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

    _deleteCity(id, name) {
        if (confirm("Do you want to delete '" + name +  "' city?")) {
            api.deleteCity(id).then( (json)=> {
                if (json.status === 0) {
                    alert("delete city SUCCESS")
                } else {
                    alert("delete city Failure, error:\n" + JSON.stringify(json, null, 2));
                }
            });
        }
    }

    _convertCityToLI = (city) => {
        let that = this;
        return (
            <li key={city.cityId}>
                <b> {city.cityName} </b> with id = {city.cityId}
                <button onClick={() => that._deleteCity(city.cityId, city.cityName)}> delete </button>
            </li>
        )
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

    render() {
        let that = this;
        return (
            <div>
                <p><b> City Tab </b></p>
                <input onChange={(e) => that.setState({addCityText: e.target.value})}/>
                <button onClick={() => {
                    if (confirm("Do you want to add city?"))
                        that._addCity(that.state.addCityText);
                }}>Add</button>

                <p> Search</p>
                <input type="text" onChange={this.onTextChange} ref={(input) => {
                    this.idInput = input;
                }}/>
                {this._result()}
            </div>
        )
    }
}
export default WeatherTab