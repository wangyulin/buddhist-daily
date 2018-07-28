package com.buddhist.daily.service.impl;

import com.buddhist.daily.dto.PageDTO;
import com.buddhist.daily.config.ds.DS;
import com.buddhist.daily.dao.CityDao;
import com.buddhist.daily.po.City;
import com.buddhist.daily.service.CityService;
import com.buddhist.daily.utils.BusinessException;
import com.buddhist.daily.utils.BusinessExceptionCode;
import org.beetl.sql.core.db.KeyHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @Auther: wangyulin
 * @Date: 2018/7/28 14:31
 * @Description:
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Override
    @DS("readDB")
    public City findById(long id) {
        City city = cityDao.createQuery().andEq("id", id).single();
        return city;
    }

    @Override
    public City addCity(City city) {
        KeyHolder holder = cityDao.insertReturnKey(city);
        return cityDao.single(holder.getKey());
    }

    @Override
    public City updateCity(City city) throws BusinessException {
        City query = cityDao.single(city.getId());
        if(Objects.isNull(query)) {
            throw new BusinessException(BusinessExceptionCode.CITY_IS_NOT_EXISTED);
        }
        cityDao.updateById(city);
        return cityDao.single(city.getId());
    }

    @Override
    public City deleteCityById(long id) throws BusinessException {
        City res = cityDao.single(id);
        if(Objects.isNull(res)) {
            throw new BusinessException(BusinessExceptionCode.CITY_IS_NOT_EXISTED);
        }
        cityDao.deleteById(id);
        return res;
    }

    @Override
    public PageDTO<City> page(PageDTO<City> pageParam) {
        long startRow = (pageParam.getPageNO() - 1L) * pageParam.getPageSize() + 1L;
        if(pageParam.getPageNO() < 1L) {
            pageParam.setPageNO(1L);
        }
        List<City> cityList = cityDao.createQuery().limit(startRow, pageParam.getPageSize()).select();
        Long total = cityDao.createQuery().count();
        pageParam.setTotal(total);
        pageParam.setData(cityList);
        return pageParam;
    }
}
