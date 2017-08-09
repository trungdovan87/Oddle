import AbstractApi from '../AbstractApi'
import {HOST} from '../../commons/env'

class WeatherApi extends AbstractApi {
    constructor(host) {
        super(host, undefined);
        this._context = "/"
    }

    /**
     *
     * @param {number} cityId
     * @returns {Promise.<Object>}
     */
    getCity(cityId) {
        let params = {};
        params['cityId'] = cityId;
        return this._httpGet(this._createUrlWithoutToken(this._context + "api/weather/get", params));
    }

    /**
     *
     * @param {number} cityId
     * @returns {Promise.<Object>}
     */
    searchWeather(cityName) {
        let params = {};
        params['name'] = cityName;
        return this._httpGet(this._createUrlWithoutToken(this._context + "api/weather/search", params));
    }
}

const api = new WeatherApi(HOST);

export default api;