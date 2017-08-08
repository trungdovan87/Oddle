import AbstractApi from '../AbstractApi'

class PartnerApi extends AbstractApi {

    constructor(host, token) {
        super(host);
        this._context = "/partner"
    }

    /**
     *
     * @param {number} status
     * @param {string} fromCreateDate
     * @param {string} toCreateDate
     * @returns {Promise.<Object>}
     */
    list(status, fromCreateDate, toCreateDate) {
        let params = {};
        if (status !== undefined)
            params['status'] = status;
        if (fromCreateDate !== undefined)
            params['fromCreateDate'] = fromCreateDate;
        if (toCreateDate !== undefined)
            params['toCreateDate'] = toCreateDate;
        return this._httpGet(this._createUrlWithToken(this._context + "/list", params));
    }

    add(data){
        return this._httpPost(this._createUrlWithToken(this._context + "/add"), data)
    }
}

export default PartnerApi;