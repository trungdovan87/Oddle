import React, {Component} from "react";
import "./App.css";
import "./commons/preload";
import SelectScreen from "./component/SelectScreen"
import ApiScreen from "./component/ApiScreen"

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
        if (this.state.screen === "home") {
            return (
                <SelectScreen selectScreen = {this.selectScreen} />
            );
        } else if (this.state.screen === "end-user") {
            return <ApiScreen selectScreen = {this.selectScreen}/>
        } else if (this.state.screen === "admin") {
            return <p> Admin screen </p>
        }
    }
}

export default App;
