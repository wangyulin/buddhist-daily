package com.buddhist.daily.utils;

/**
 * Created by wangyulin on 21/12/2017.
 */
public class BusinessException extends Exception {

    private String code;

    public BusinessException(String code) {
        super(BusinessExceptionCode.businessCodeMsg.get(code));
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
