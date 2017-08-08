package com.oddle.tdv.service.filter;

import com.oddle.tdv.communication.base.PageableData;

public class ApiStorageValidator {
    public boolean validateGet(long cityId) {
        return true;
    }

    public boolean validateSearch(PageableData<String> request) {
        return true;
    }
}
