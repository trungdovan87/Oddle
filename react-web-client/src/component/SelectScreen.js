import React, {Component} from "react";

class SelectScreen extends Component {
    render() {
        return (
            <div>
                <button onClick={() => this.props.selectScreen("end-user")}> End User</button>
                <button> Admin</button>
            </div>
        );
    }
}

export default SelectScreen;