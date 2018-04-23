package com.tuyue.trading.service;

import com.tuyue.entity.TradingArea;
import com.tuyue.util.Result;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/3/8.
 */
public interface TradingService {
    Result addTrading(TradingArea tradingArea);

    Result tradingList(TradingArea tradingArea);

    Result selectById(int id);
    //根据商圈名精确查找商圈
    Result selectByName(String name);
}
