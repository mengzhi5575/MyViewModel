package com.android.test.myviewmode.constant;

public class ErrorData {
    private int errorCode;
    private String msg;

    public ErrorData(int errorCode, String msg) {
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ErrorData{" +
                "errorCode=" + errorCode +
                ", msg='" + msg + '\'' +
                '}';
    }
}
