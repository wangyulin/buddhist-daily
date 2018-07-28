package com.buddhist.daily.service;


import com.buddhist.daily.dto.PageDTO;
import com.buddhist.daily.po.City;
import com.buddhist.daily.utils.BusinessException;

/**
 * @Auther: wangyulin
 * @Date: 2018/7/28 14:31
 * @Description:
 */
public interface CityService {

    City findById(long id);

    City addCity(City city);

    City updateCity(City city) throws BusinessException;

    City deleteCityById(long id) throws BusinessException;

    PageDTO<City> page(PageDTO<City> pageParam);

}
