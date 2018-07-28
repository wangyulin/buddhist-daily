package com.buddhist.daily.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangyulin on 21/12/2017.
 */
public class BusinessExceptionCode {

    public static final String CITY_IS_NOT_EXISTED = "CITY_IS_NOT_EXISTED ";
    public static final Map<String, String > businessCodeMsg = new HashMap<String, String>(){{
        put(CITY_IS_NOT_EXISTED, "该City不存在");
    }};

}
