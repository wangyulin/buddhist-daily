package com.buddhist.daily.dto;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: wangyulin
 * @Date: 2018/7/28 16:52
 * @Description:
 */
@Setter
@Getter
public class PageDTO<T> implements Serializable {

    private Long total;
    private Long pageNO;
    private Long pageSize;
    private Long offSet;
    private List<T> data;

    public PageDTO() {

    }

    public PageDTO(Long pageNO, Long pageSize) {
        this.pageNO = pageNO;
        this.pageSize = pageSize;
        this.total = 0L;
        this.data = Lists.newArrayList();
        this.offSet = (this.pageNO - 1) * this.pageSize;
    }

}
