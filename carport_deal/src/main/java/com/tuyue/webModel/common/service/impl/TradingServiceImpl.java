package com.tuyue.webModel.common.service.impl;

import com.tuyue.commonBean.TradingArea;
import com.tuyue.fegin.trading.TradingFegin;
import com.tuyue.util.Result;
import com.tuyue.webModel.common.service.TradingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/3/21.
 */
@Service
public class TradingServiceImpl implements TradingService {
    @Autowired
    private TradingFegin tradingFegin;
    /**
     * 根据名字模糊查询商圈名
     * @param name
     * @return
     */
    @Override
    public Result TradingList(String name){
        TradingArea tradingArea =new TradingArea();
        if(name!=null&&name.length()>0){
            tradingArea.setBusinessCircles(name);
        }
       return tradingFegin.tradingList(tradingArea);
    }
}
