package com.buddhist.daily.po;

import lombok.Getter;
import lombok.Setter;
import org.beetl.sql.core.annotatoin.Table;

/**
 * @Auther: wangyulin
 * @Date: 2018/7/28 13:59
 * @Description:
 */
@Table(name = "city")
@Setter
@Getter
public class City {

    private long id;

    private String provinceId;

    private String cityName;

    private String description;

}
