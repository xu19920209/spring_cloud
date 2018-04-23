package com.tuyue.hourse.controller;

import com.netflix.discovery.converters.Auto;
import com.tuyue.entity.ComHourses;
import com.tuyue.hourse.service.HouseService;
import com.tuyue.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.validation.Validator;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/3/8.
 */
@RestController
@RequestMapping("/hourse")
public class HourseController {
    @Autowired
    private HouseService houseService;
    @RequestMapping(value = "addHourse")
    public Result addHourse(ComHourses comHouses) {
       return  houseService.addHourse(comHouses);
    }

    @RequestMapping(value = "/selectHourse")
    public Result selectHourse(@RequestBody ComHourses comHouses) {
        Result result = houseService.selectHourse(comHouses);
        return result;
    }

    @RequestMapping(value = "delHourse")
    public Result delHourse(@RequestParam(required = true) int id) {
        return  houseService.delHourse(id);
    }

    @RequestMapping(value ="upHourse")
    public Result upHourse(ComHourses comHouses) {
        return houseService.upHourse(comHouses);
    }

    @RequestMapping(value ="/selectById")
    public Result selectById(@RequestParam(required = true) Integer id){
        return  houseService.selectById(id);
    }
}
