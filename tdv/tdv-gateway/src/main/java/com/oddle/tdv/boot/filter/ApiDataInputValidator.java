package com.oddle.tdv.boot.filter;

import com.oddle.tdv.communication.base.PageableData;

public class ApiDataInputValidator {
    public boolean validateGet(long cityId) {
        return true;
    }

    public boolean validateSearch(PageableData<String> request) {
        return true;
    }

}
