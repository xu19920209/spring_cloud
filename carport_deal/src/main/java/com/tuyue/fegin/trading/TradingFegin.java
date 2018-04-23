package com.tuyue.fegin.trading;
import com.tuyue.commonBean.TradingArea;
import com.tuyue.fegin.user.UserHystric;
import com.tuyue.util.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/3/13.
 */
@Component
@FeignClient(value = "common",fallback =TradingHystric.class)
public interface TradingFegin {
    /**
     * @Author: 徐慷慨
     * @Description:根据商圈名精确查找商圈
     * @Date: 14:14 2018/3/21
     */
    @RequestMapping(value = "/trading/selectByName")
    Result selectByName(@RequestParam("name") String name);

    @RequestMapping(value = "/trading/addTrading")
    public Result addTrading(TradingArea tradingArea);

    /**
     * 根据商圈名模糊查找
     * @param tradingArea
     * @return
     */
    @RequestMapping(value = "/trading/tradingList")
    public Result tradingList(TradingArea tradingArea);
}
