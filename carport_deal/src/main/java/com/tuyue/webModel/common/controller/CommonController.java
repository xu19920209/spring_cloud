package com.tuyue.webModel.common.controller;


import com.tuyue.util.Result;
import com.tuyue.webModel.common.service.TradingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2017/11/23.
 */
@Controller
@ResponseBody
@RequestMapping("common")
public class CommonController {
@Autowired
private TradingService tradingService;
        ;
    /**
     * @Author: 徐慷慨
     * @Description:商圈列表
     * @Date: 16:33 2017/11/23
     */
    @RequestMapping("businessList")
    public Result businessList(String businessCircles) throws Exception{
        if(businessCircles!=null){
        businessCircles = new String(businessCircles.getBytes("iso8859-1"), "utf-8");
    }
        return tradingService.TradingList(businessCircles);
    }

}
