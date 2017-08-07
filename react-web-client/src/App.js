import React, {Component} from "react";
import logo from "./logo.svg";
import "./App.css";
import "./commons/preload";
import apiClient from "./api/ApiClient";

let result = apiClient.login('admin1', '123456');

result.then(
    token => {
        let api = apiClient.getPartnerApi()
        let promise = api.add({name: 'My Name'})
        promise
            .then(json => {
                console.log("json add: ", json)
            });
    }
).catch(error => console.log("error!!! ", error));

class App extends Component {
    render() {
        return (
            <div className="App">
                <div className="App-header">
                    <img src={logo} className="App-logo" alt="logo"/>
                    <h2>Welcome to React</h2>
                </div>
                <p className="App-intro">
                    To get started, edit <code>src/App.js</code> and save to reload.
                </p>
            </div>
        );
    }
}

export default App;
