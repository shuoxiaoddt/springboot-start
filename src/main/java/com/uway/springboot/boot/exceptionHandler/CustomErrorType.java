package com.uway.springboot.boot.exceptionHandler;


/**
 * Created by uwayxs on 2017/10/31.
 */
public class CustomErrorType {
    private int statusValue;
    private String message;

    public CustomErrorType(int statusValue, String message) {
        this.statusValue = statusValue;
        this.message = message;
    }

    public int getStatusValue() {
        return statusValue;
    }

    public void setStatusValue(int statusValue) {
        this.statusValue = statusValue;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
