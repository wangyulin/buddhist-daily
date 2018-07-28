package com.buddhist.daily.config.ds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangyulin
 * on 25/11/2017.
 */
public class DataSourceContextHolder {
    public static final Logger log = LoggerFactory.getLogger(DataSourceContextHolder.class);

    /** 默认数据源*/
    public static final String DEFAULT_DS = "writeDB";

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    /** 设置数据源名*/
    public static void setDB(String dbType) {
        log.info("切换到{}数据源", dbType);
        contextHolder.set(dbType);
    }

    /** 获取数据源名*/
    public static String getDB() {
        return (contextHolder.get());
    }

    /** 清除数据源名*/
    public static void clearDB() {
        log.info("恢复数据源");
        contextHolder.remove();
        log.info("恢复之后的数据源 {}", contextHolder.get());
    }
}
