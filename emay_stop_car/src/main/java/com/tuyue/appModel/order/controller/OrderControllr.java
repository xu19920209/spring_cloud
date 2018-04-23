package com.tuyue.appModel.order.controller;
import com.tuyue.fegin.bean.Orders;
import com.tuyue.fegin.carPort.OrderFegin;
import com.tuyue.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/4/19.
 */
@RestController
@RequestMapping("order")
public class OrderControllr {
    @Autowired
    private OrderFegin orderFegin;
    /**
     * 添加订单
     * @param orders
     * @return
     */
    @RequestMapping(value = "inOrders",produces = {"application/json; charset=UTF-8"})
    public Result inOrders(@RequestBody Orders orders){
        return orderFegin.inOrders(orders);
    }

    /**
     * 修改订单
     * @param orders
     * @return
     */
    @RequestMapping(value = "upOrders",produces = {"application/json; charset=UTF-8"})
    public Result upOrders(@RequestBody Orders orders){
        return orderFegin.upOrders(orders);
    }

    /**
     * 删除订单
     * @param orderId
     * @return
     */
    @RequestMapping(value = "delOrder",produces = {"application/json; charset=UTF-8"})
    public Result delOrder(int orderId){
        return orderFegin.delOrder(orderId,2);
    }

    /**
     * 订单列表
     * @param aid
     * @param currentPage
     * @param pageSize
     * @param type
     * @param time
     * @return
     */
    @RequestMapping(value = "orderList",produces ={"application/json; charset=UTF-8"})
    public Result orderList(@RequestParam(defaultValue ="1") Integer currentPage,
                            @RequestParam(defaultValue ="10")Integer pageSize,
                            Integer aid, Integer type, Integer time, String str) throws Exception{
        return orderFegin.orderList(currentPage,pageSize,aid,type,time,str,2);
    }
    /**
     * 关闭交易
     * @param orderId
     * @param msg
     * @return
     */
    @RequestMapping(value = "closeOrder",produces = {"application/json; charset=UTF-8"})
    public Result closeOrder(int orderId,String msg) throws Exception{
        return orderFegin.closeOrder(orderId,msg);
    }



    /**
     * 修改车位回显信息商家或者买家
     * @param orderId
     * @param // 1商家2买家
     * @return
     */
    @RequestMapping(value = "upOrderDetails",produces = {"application/json; charset=UTF-8"})
    public Result upOrderDetails(int orderId)throws Exception{
        return orderFegin.upOrderDetails(orderId,2);
    }


    /**
     * 查询 商家或者买家订单类型数量
     */
    @RequestMapping(value = "orderTypeNum",produces = {"application/json; charset=UTF-8"})
    public Result orderTypeNum(int aid){
        return orderFegin.orderTypeNum(aid,2);
    }
    /**
     * 根据车牌归属省查询用的最多的车牌号
     * @param carHome
     * @return
     */
    @RequestMapping(value = "selectCarNumber",produces = {"application/json; charset=UTF-8"})
    public Result selectCarNumber(String carHome){
        return orderFegin.selectCarNumber(carHome);
    }
    /**
     * 催促发货提醒
     * @param orderId
     * @return
     */
    @RequestMapping(value = "urgeOrder",produces = {"application/json; charset=UTF-8"})
    public Result urgeOrder(int orderId) throws Exception{
        return orderFegin.urgeOrder(orderId);
    }


    /**
     * 确认收货
     * @param orderId
     * @param aid
     * @return
     */
    @RequestMapping(value = "confirmOrder",produces = {"application/json; charset=UTF-8"})
    public Result confirmOrder(int orderId ,int aid) throws Exception{
        return orderFegin.confirmOrder(orderId,aid);
    }
    /**
     * 追加评价回显信息
     * @param orderId
     * @param aid
     * @return
     */
    @RequestMapping(value = "appraiseBack",produces = {"application/json; charset=UTF-8"})
    public Result appraiseBack(int orderId, int aid ) throws Exception{
        return orderFegin.appraiseBack(orderId,aid);
    }

    /**
     * 根据订单号查询订单详情（支付的时候）
     * @param orderNumber
     * @return
     */
    @RequestMapping(value = "orderDelByNumber",produces = {"application/json; charset=UTF-8"})
    public Result orderDelByNumber(String orderNumber) throws Exception{
        return orderFegin.orderDelByNumber(orderNumber);
    }
}
