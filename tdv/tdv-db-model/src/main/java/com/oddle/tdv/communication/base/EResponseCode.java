package com.oddle.tdv.communication.base;

public enum EResponseCode {

    SUCCESS(0, "Success"),
    WRONG_INPUT_FORMAT(101, "Wrong input format"),
    WRONG_DATA(102, "Wrong data");


    private final int status;
    private final String error;
    EResponseCode(int status, String error) {
        this.status = status;
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }
}
