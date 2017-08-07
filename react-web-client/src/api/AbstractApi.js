import fetch from "isomorphic-fetch";

class AbstractApi {
    /**
     *
     * @type {string}
     * @protected
     */
    _context;
    /**
     * @type {string}
     * @protected
     */
    _token;

    /**
     * @type {string}
     * @protected
     */
    _host;

    /**
     *
     * @param {string} host
     * @param {string} token
     */
    constructor(host, token) {
        this._host = host;
        this._token = token;
    }

    /**
     *
     * @param {Object} params
     * @returns {string}
     * @private
     */
    _createQuery(params) {
        let esc = encodeURIComponent;
        return Object.keys(params)
            .map(k => esc(k) + '=' + esc(params[k]))
            .join('&');
    }

    /**
     *
     * @param {boolean} withToken
     * @param {string} subUrl
     * @param {Object} params
     * @returns {string}
     * @private
     */
    _createUrl(withToken, subUrl, params = {}) {
        if (withToken)
            params['token-id'] = this._token;
        return this._host + subUrl + "?" + this._createQuery(params);
    }

    /**
     *
     * @param {string} subUrl
     * @param {Object} params
     * @returns {string}
     * @protected
     */
    _createUrlWithToken(subUrl, params = {}) {
        return this._createUrl(true, subUrl, params);
    }

    /**
     *
     * @param {string} subUrl
     * @param {Object} params
     * @returns {string}
     * @protected
     */
    _createUrlWithoutToken(subUrl, params = {}) {
        return this._createUrl(false, subUrl, params);
    }

    /**
     *
     * @param {string} url
     * @returns {Promise.<Object>}
     * @protected
     */
    _httpGet(url) {
        return fetch(url)
            .then(response => response.json());
    }

    /**
     *
     * @param {string} url
     * @param {Object} payload
     * @returns {Object}
     * @protected
     */
    _httpPost(url, payload) {
        let data = JSON.stringify(payload);

        return fetch(url,
            {
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                method: "POST",
                body: data
            }).then(response => response.json());
    }
}

export default AbstractApi;