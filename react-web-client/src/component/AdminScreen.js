import React, {Component} from "react";
import WeatherTab from "./WeatherTab";
import CityTab from "./CityTab";
import LogTab from "./LogTab";


class AdminScreen extends Component {
    constructor() {
        super();
        this.state = {
            tab: "log"
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

                <p>---------------</p>
                <a href=""
                   onClick={(e) => { e.preventDefault(); this.props.selectScreen("home")}}
                >
                    HOME
                </a>
            </div>
        )

    }
}

export default AdminScreen;