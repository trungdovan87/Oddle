package com.oddle.tdv.exception;

import com.oddle.tdv.communication.base.EResponseCode;
import com.oddle.tdv.communication.base.SubCode;

public class OddleException extends RuntimeException {
    private EResponseCode code;
    private SubCode subCode;

    public OddleException(EResponseCode code, SubCode subCode) {
        this.code = code;
        this.subCode = subCode;
    }

    public EResponseCode getCode() {
        return code;
    }

    public SubCode getSubCode() {
        return subCode;
    }
}
