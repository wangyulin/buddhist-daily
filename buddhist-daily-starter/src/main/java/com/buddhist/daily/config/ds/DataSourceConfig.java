package com.buddhist.daily.config.ds;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * Created by wangyulin on 25/11/2017.
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "writeDS")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    @Primary
    public DataSource dataSource1() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "readDB")
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource dataSource2() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 动态数据源: 通过AOP在不同数据源之间动态切换
     * @return
     */
    @Bean(name = "dynamicDatasource")
    public DataSource dataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setDefaultTargetDataSource(dataSource1());

        HashMap dsMap = new HashMap(5);
        dsMap.put("writeDB", dataSource1());
        dsMap.put("readDB", dataSource2());

        dynamicDataSource.setTargetDataSources(dsMap);

        return dynamicDataSource;
    }
}