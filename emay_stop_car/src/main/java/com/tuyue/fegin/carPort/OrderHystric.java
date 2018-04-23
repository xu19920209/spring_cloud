package com.tuyue.fegin.carPort;

import com.tuyue.fegin.bean.Orders;
import com.tuyue.util.Result;
import org.springframework.stereotype.Component;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/4/19.
 */
@Component
public class OrderHystric implements OrderFegin {
    @Override
    public Result inOrders(Orders orders) {
        return Result.error(2,"车位服务出错了！");
    }

    @Override
    public Result upOrders(Orders orders) {
        return Result.error(2,"车位服务出错了！");
    }

    @Override
    public Result delOrder(int orderId, int type) {
        return Result.error(2,"车位服务出错了！");
    }

    @Override
    public Result orderList(Integer currentPage, Integer pageSize, Integer aid, Integer type, Integer time, String str, int status) throws Exception {
        return Result.error(2,"车位服务出错了！");
    }

    @Override
    public Result closeOrder(int orderId, String msg) throws Exception {
        return Result.error(2,"车位服务出错了！");
    }

    @Override
    public Result deliverGoods(int orderId, String imgUrl) throws Exception {
        return Result.error(2,"车位服务出错了！");
    }

    @Override
    public Result upOrderDetails(int orderId, int type) throws Exception {
        return Result.error(2,"车位服务出错了！");
    }

    @Override
    public Result orderTypeNum(int aid, int type) {
        return Result.error(2,"车位服务出错了！");
    }

    @Override
    public Result selectCarNumber(String carHome) {
        return Result.error(2,"车位服务出错了！");
    }

    @Override
    public Result urgeOrder(int orderId) throws Exception {
        return Result.error(2,"车位服务出错了！");
    }

    @Override
    public Result confirmOrder(int orderId, int aid) throws Exception {
        return Result.error(2,"车位服务出错了！");
    }

    @Override
    public Result appraiseBack(int orderId, int aid) throws Exception {
        return Result.error(2,"车位服务出错了！");
    }

    @Override
    public Result orderDelByNumber(String orderNumber) throws Exception {
        return Result.error(2,"车位服务出错了！");
    }
}
