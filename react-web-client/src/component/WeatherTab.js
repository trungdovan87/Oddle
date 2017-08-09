import React, {Component} from "react";
import api from "../api/service/WeatherApi";

class WeatherTab extends Component {

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

    _convertCityToLI = (city) => {
        let that = this;
        return (
            <li key={city.cityId}>
                <b> {city.cityName} </b> ({city.createDate})

                <br/>
                temp: {city.temperature} degree | {city.status} | {city.windy} m/s | {city.humidity}% | {city.pressure} hpa | --
                {
                    that.state.editId === undefined ?
                        <button onClick={() => {that.setState({editId : city.cityId, updateText : JSON.stringify(city, null, 2)})}}> Edit </button>
                        : <div></div>
                }
            </li>
        )
    }

    _edit = () => {
        let that = this;
        if (this.state.editId === undefined) {
            return <div></div>;
        }
        return (
          <div>
              <p> <b> Edit city</b></p>
              <textarea style = {{width: 500, height: 300}}  onChange={(event) => that.setState({updateText : event.target.value})} >{this.state.updateText}</textarea>
              <br/>
              <button>Update</button>
              <button onClick={() => that.setState({editId : undefined, updateText : undefined})}>Cancel</button>
          </div>
        );
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
                <p> Search</p>
                <input type="text" onChange={this.onTextChange} ref={(input) => {
                    this.nameInput = input;
                }}/>
                {this._result()}
                {this._edit()}

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
export default WeatherTab