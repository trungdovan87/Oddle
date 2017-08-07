package com.oddle.tdv.boot.filter;

import com.oddle.tdv.communication.base.EResponseCode;
import com.oddle.tdv.communication.base.SubCode;
import com.oddle.tdv.communication.code.CodeConst;
import com.oddle.tdv.communication.request.UserRequest;
import com.oddle.tdv.exception.OddleException;

public class UserDataInputValidator {
    public boolean validateRegister(UserRequest request) {
        if (request.getId() != null) {
            throw new OddleException(EResponseCode.WRONG_INPUT_FORMAT,
                    new SubCode(CodeConst.CODE_ID_IS_NOT_NULL, String.format(CodeConst.MSG_ID_IS_NOT_NULL, request.getId()))
            );
        }
        return true;
    }
}
