import React, {Component} from "react";
import "./App.css";
import "./commons/preload";
import api from "./api/service/WeatherApi"
import SelectScreen from "./component/SelectScreen"

let promise = api.get(2);
promise.then(
    json => {
        console.log("json get Weather: ", json);
    }
);

class App extends Component {
    that = this;

    constructor() {
        super();
        this.state = {
            screen: "select"
        }

        this.selectScreen = this.selectScreen.bind(this);
    }

    selectScreen(name) {
        this.setState({screen: name})
    }

    render() {
        if (this.state.screen === "select") {
            return (
                <SelectScreen selectScreen = {this.selectScreen} />
            );
        } else if (this.state.screen === "end-user") {
            return <p> End User screen </p>
        }
    }
}

export default App;
