package com.buddhist.daily.controller;

import com.buddhist.daily.dto.PageDTO;
import com.buddhist.daily.dto.Msg;
import com.buddhist.daily.po.City;
import com.buddhist.daily.service.CityService;
import com.buddhist.daily.utils.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Auther: wangyulin
 * @Date: 2018/7/25 22:18
 * @Description:
 */
@RestController
@RequestMapping(value = "city")
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello world !";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Msg getCityById(@PathVariable(value = "id") Long id,
                            HttpServletRequest request,
                            HttpServletResponse response,
                            HttpSession session) {
        Msg msg = new Msg();
        City city = cityService.findById(id);
        msg.setData(city);
        return msg;
    }

    @RequestMapping(value = "page", method = RequestMethod.GET)
    public Msg page(@RequestParam(value = "pageNO", required = true) Long pageNO,
                              @RequestParam(value = "pageSize", required = true) Long pageSize) {
        PageDTO<City> cityPageDTO = new PageDTO<>(pageNO, pageSize);
        PageDTO<City>  page = cityService.page(cityPageDTO);
        Msg msg = new Msg(page);
        return msg;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Msg addCity(@RequestBody City city) {
        City res = cityService.addCity(city);
        Msg msg = new Msg(res);
        return msg;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    public Msg updateCity(@PathVariable(value = "id") Long id, @RequestBody City city) throws BusinessException {
        city.setId(id);
        Msg msg = new Msg();
        City res = cityService.updateCity(city);
        msg.setData(res);
        return msg;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public Msg deleteCityById(@PathVariable(value = "id") Long id) throws BusinessException {
        Msg msg = new Msg();
        City city = cityService.deleteCityById(id);
        msg.setData(city);
        return msg;
    }

}
