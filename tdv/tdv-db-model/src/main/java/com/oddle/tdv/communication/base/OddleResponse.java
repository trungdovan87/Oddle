package com.oddle.tdv.communication.base;

public class OddleResponse<T> {
    private int status;
    private String error;
    private String message;
    private Integer subCode;
    private T data;

    public static <T> OddleResponse createSuccessResponse(T data) {
        EResponseCode success = EResponseCode.SUCCESS;
        return new OddleResponse<>(success.getStatus(), success.getError(), 0, success.getError(), data);
    }

    public OddleResponse(int status, String error, Integer subCode, String message,  T data) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.subCode = subCode;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getSubCode() {
        return subCode;
    }

    public void setSubCode(Integer subCode) {
        this.subCode = subCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
