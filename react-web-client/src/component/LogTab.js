import React, {Component} from "react";
import api from "../api/service/WeatherApi";

class WeatherTab extends Component {
    constructor() {
        super();
        this.state = {};
    }

    _callApiGetLogByCityId = (id) => {
        let that = this;
        api.getLogByCityId(id).then( (json) => {
            if (json.status === 0) {
                that.setState({logs: json.data});
            } else {
                alert("delete log Failure, error:\n" + JSON.stringify(json, null, 2));
            }
        })
    };

    _getLogByCitId = () => {
        let id = parseInt(this.idInput.value.trim(), 10);
        if (!isNaN(id)) {
            this._callApiGetLogByCityId(id);
        } else {
            alert(this.idInput.value + " is not Number");
        }
    };

    _deleteLog(id) {
        if (confirm("Do you want to delete log with id = " + id + " city?")) {
            api.deleteLog(id).then( (json)=> {
                if (json.status === 0) {
                    this._getLogByCitId();
                    alert("delete log SUCCESS")
                } else {
                    alert("delete log Failure, error:\n" + JSON.stringify(json, null, 2));
                }
            });
        }
    }

    _convertLogToLI = (log) => {
        return (
            <li key={log.id}>
                <b> {log.cityName} </b> ({log.createDate}): id log = {log.id}

                <br/>
                temp: {log.temperature} degree | {log.status} | {log.windy} m/s | {log.humidity}% | {log.pressure} hpa | --
                <button onClick={() => this._deleteLog(log.id)}>delete</button>
            </li>
        )
    };

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
    };

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

                <button onClick={this._getLogByCitId}>Get Log</button>
                {this._result()}
            </div>
        )
    }
}

export default WeatherTab
