import AbstractApi from '../AbstractApi'
import {HOST} from '../../commons/env'

class WeatherApi extends AbstractApi {
    constructor(host) {
        super(host, undefined);
        this._context = "/partner"
    }

    /**
     *
     * @param {string} cityId
     * @returns {Promise.<Object>}
     */
    get(cityId) {
        let params = {};
        params['cityId'] = cityId;
        return this._httpGet(this._createUrlWithoutToken(this._context + "/api/weather/get", params));
    }
}

const api = new WeatherApi(HOST);

export default api;