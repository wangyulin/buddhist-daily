package com.buddhist.daily.utils;

/**
 * Created by wangyulin on 16/11/2017.
 */
public class SystemException extends RuntimeException {

    private String code;

    public SystemException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

}
