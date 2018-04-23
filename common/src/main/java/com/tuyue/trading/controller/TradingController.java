package com.tuyue.trading.controller;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.tuyue.entity.TradingArea;
import com.tuyue.trading.service.TradingService;
import com.tuyue.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/3/8.
 */
@RestController
@RequestMapping("/trading")
public class TradingController {
    @Autowired
    private TradingService tradingService;
    @RequestMapping(value = "/addTrading")
    public Result addTrading(@RequestBody TradingArea tradingArea){
        return tradingService.addTrading(tradingArea);
    }
    @RequestMapping(value = "/tradingList")
    public Result tradingList(TradingArea tradingArea){
        return tradingService.tradingList(tradingArea);
    }
    @RequestMapping(value = "/selectById")
    public Result selectById(Integer id){
        return tradingService.selectById(id);
    }


    //根据商圈名精确查找商圈
    @RequestMapping(value = "/selectByName")
    Result selectByName(@RequestParam("name") String name){
        return tradingService.selectByName(name);
    }
}
