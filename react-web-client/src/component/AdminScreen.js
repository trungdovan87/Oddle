import React, {Component} from "react";
import WeatherTab from "./WeatherTab";
import CityTab from "./CityTab";
import LogTab from "./LogTab";


class AdminScreen extends Component {
    constructor() {
        super();
        this.state = {
            tab: "city"
        };
        // this.onTextChange = this.onTextChange.bind(this);
    }

    _tabs() {
        if (this.state.tab === "weather") {
            return (
                <WeatherTab/>
            );
        } else if (this.state.tab === "city") {
            return (
                <CityTab/>
            );
        } if (this.state.tab === "log") {
            return (
                <LogTab/>
            );
        }
    }

    selectTab = (nameTab) => {
        this.setState({tab: nameTab});
    }

    render() {
        return (
            <div>
                <h1> Admin Screen</h1>
                <a href=""
                   onClick={(e) => { e.preventDefault(); this.selectTab("weather")}}
                > Weather </a>
                --|--
                <a href=""
                   onClick={(e) => { e.preventDefault(); this.selectTab("city")}}
                > City </a>
                --|--
                <a href=""
                   onClick={(e) => { e.preventDefault(); this.selectTab("log")}}
                > Log </a>

                {this._tabs()}
            </div>
        )

    }
}

export default AdminScreen;