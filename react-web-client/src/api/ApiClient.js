import PartnerApi from './service/PartnerApi'
import {HOST} from '../commons/env'

class ApiClient {
    /**
     * @type {string}
     */
    host;

    /**
     * @type {string}
     */
    token;

    constructor() {
        this.host = HOST;
    }

    /**
     *
     * @returns {boolean}
     */
    isLogged() {
        return !!this.token;
    }

    /**
     *
     * @param {string} username
     * @param {string} password
     * @returns {Promise.<TResult>}
     */
    login(username, password) {    
        let url = String.format(this.host + '/login?username={0}&password={1}', username, password);
        return fetch(url)
        .then(response => {
            if (response.status === 200) {
                return response.text().then(text => {
                    console.log("success --- text: ", text) 
                    this.token = text                     
                    return this.token;
                })
            } else {                
                console.log("Fail --- status: ", response.status) 
                this.token = undefined
                throw new Error("Unable To Login");
            }
        })    
    }

    /**
     *
     * @returns {PartnerApi}
     */
    getPartnerApi() {
        return new PartnerApi(this.host, this.token);
    }
}

const apiClient = new ApiClient()

export default apiClient;