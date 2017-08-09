import React, {Component} from "react";

class HomeScreen extends Component {
    render() {
        return (
            <div>
                <button onClick={() => this.props.selectScreen("end-user")}> End User</button>
                <button onClick={() => this.props.selectScreen("admin")}> Admin</button>
            </div>
        );
    }
}

export default HomeScreen;