package com.oddle.tdv.communication.base;

public class SubCode {
    public static final SubCode SUCCESS = new SubCode(0, "Success");

    private int subCode;
    private String message;

    public SubCode(int subCode, String message) {
        this.subCode = subCode;
        this.message = message;
    }

    public int getSubCode() {
        return subCode;
    }

    public String getMessage() {
        return message;
    }
}
