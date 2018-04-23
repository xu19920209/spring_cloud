package com.tuyue.trading.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.tuyue.entity.TradingArea;
import com.tuyue.mapper.TradingAreaMapper;
import com.tuyue.trading.service.TradingService;
import com.tuyue.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/3/8.
 */
@Service
public class TradingServiceImpl implements TradingService {
    @Autowired
    private TradingAreaMapper tradingAreaMapper;

    @Override
    public Result addTrading(TradingArea tradingArea) {
        Integer business_circles = tradingAreaMapper.selectCount(new EntityWrapper<TradingArea>().eq("business_circles", tradingArea.getBusinessCircles()));
        if(business_circles>0){
            return Result.error(2,"改商圈已被添加过了") ;
        }
        Integer insert = tradingAreaMapper.insert(tradingArea);
        if(insert>0){
            return Result.success(1,"SUCCESS",tradingArea.getComBusinesId());
        }
        return Result.error(2,"ERROR") ;
    }

    @Override
    public Result tradingList(TradingArea tradingArea) {
        List<TradingArea> tradingAreas = tradingAreaMapper.tradingList(tradingArea);
        return Result.success(1,"SUCCESS",tradingAreas);
    }
    @Override
    public Result selectById(int id){
        TradingArea tradingArea = tradingAreaMapper.selectById(id);
        return Result.success(1,"SUCCESS",tradingArea);
    }
    //根据商圈名精确查找商圈
    @Override
    public Result selectByName(String name){
        TradingArea tradingArea = tradingAreaMapper.selectByName(name);
        if(tradingArea!=null){
            return Result.success(1,"SUCCESS",tradingArea);
        }else{
            return Result.error(2,"ERROR");
        }
    }
}
