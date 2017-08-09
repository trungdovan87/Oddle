import React, {Component} from "react";
import "./App.css";
import "./commons/preload";
import HomeScreen from "./component/HomeScreen"
import ApiScreen from "./component/ApiScreen"
import AdminScreen from "./component/AdminScreen";

class App extends Component {

    constructor() {
        super();
        this.state = {
            screen: "admin"
        };

        this.selectScreen = this.selectScreen.bind(this);
    }

    selectScreen(name) {
        this.setState({screen: name})
    }

    render() {
        if (this.state.screen === "home") {
            return (
                <HomeScreen selectScreen={this.selectScreen}/>
            );
        } else if (this.state.screen === "end-user") {
            return <ApiScreen selectScreen={this.selectScreen}/>
        } else if (this.state.screen === "admin") {
            return <AdminScreen selectScreen={this.selectScreen}/>
        }
    }
}

export default App;
