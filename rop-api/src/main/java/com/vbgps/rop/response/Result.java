package com.vbgps.rop.response;

import java.io.Serializable;

public class Result implements Serializable{
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String result = "0";
    private String message;
    //默认值
    private String errorCode="999";

    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }


}
