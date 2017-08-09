import React, {Component} from "react";
import "./App.css";
import "./commons/preload";
import api from "./api/service/WeatherApi"
import SelectScreen from "./component/SelectScreen"
import ApiScreen from "./component/ApiScreen"

// let promise = api.get(2);
// promise.then(
//     json => {
//         console.log("json get Weather: ", json);
//     }
// );

class App extends Component {

    constructor() {
        super();
        this.state = {
            screen: "end-user"
        };

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
            return <ApiScreen/>
        } else if (this.state.screen === "admin") {
            return <p> Admin screen </p>
        }
    }
}

export default App;
