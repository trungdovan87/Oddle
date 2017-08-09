package com.oddle.tdv.boot.filter;

import com.oddle.tdv.communication.base.EResponseCode;
import com.oddle.tdv.communication.base.SubCode;
import com.oddle.tdv.communication.code.CodeConst;
import com.oddle.tdv.communication.request.WeatherRequest;
import com.oddle.tdv.exception.OddleException;

public class WeatherDataInputValidator {
    public boolean validateSave(WeatherRequest request) {
//        if (request.getCityId() == null) {
//            throw new OddleException(EResponseCode.WRONG_INPUT_FORMAT,
//                    new SubCode(CodeConst.CODE_CITY_ID_IS_NULL, CodeConst.MSG_CITY_ID_IS_NULL));
//        }
        return true;
    }
}
