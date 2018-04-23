package com.tuyue.webModel.carport.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.tuyue.webModel.carport.bean.CarportBean;
import com.tuyue.webModel.carport.bean.ParamSearch;
import com.tuyue.webModel.carport.service.CarportService;
import com.tuyue.entity.Carport;
import com.tuyue.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.Map;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/3/14.
 */
@RestController
@RequestMapping("BCarportOut")
public class CarportController {
    @Autowired
    private CarportService carportService;
    /**
     * 添加车位
     * @param carport
     * @return
     */
    @RequestMapping("PublishHire")
    public Result addCarport(@RequestBody CarportBean carport){
        return carportService.addCarport(carport);
    }

    /**
     * 修改车位
     * @param carport
     * @return
     */
    @RequestMapping("upCarport")
    public Result upCarport(@RequestBody CarportBean carport){
        return carportService.upCarport(carport);
    }
    /**
     * 查询车位
     */
    @RequestMapping(value = "selectCarport")
    public Result selectCarport(@RequestBody ParamSearch paramSearch) throws Exception {
        System.out.println(paramSearch.toString());
        Page page=new Page();
        page.setCurrent(paramSearch.getCurrentPage()!=null?paramSearch.getCurrentPage():1);
        page.setSize(paramSearch.getPageSize()!=null?paramSearch.getPageSize():10);
        return carportService.selectCarport(page,paramSearch);
    }

    /**
     * 车位详情
     * @param bid
     * @param aid
     * @param IP
     * @return
     */
    @RequestMapping(value = "carPortDetils")
    public Result carPortDetils(Integer bid,Integer aid,String IP) throws InstantiationException, IllegalAccessException {
        return carportService.carPortDetils(bid, aid, IP);
    }

}
