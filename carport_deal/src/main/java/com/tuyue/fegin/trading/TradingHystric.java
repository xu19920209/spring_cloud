package com.tuyue.fegin.trading;

import com.tuyue.commonBean.TradingArea;
import com.tuyue.util.Result;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/3/13.
 */
@Component
public class TradingHystric implements TradingFegin {
    @Override
    public Result selectByName(String name) {
        return  Result.error(3,"在商圈服务查询失败");
    }
    @Override
    public Result addTrading( TradingArea tradingArea){
        return  Result.error(3,"在商圈服务添加失败");
    }
    @Override
    public Result tradingList(TradingArea tradingArea){
        return  Result.error(3,"在商圈服务查询失败");
    }
}
