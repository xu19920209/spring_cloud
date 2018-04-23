package com.tuyue.fegin.carPort;

import com.baomidou.mybatisplus.plugins.Page;
import com.tuyue.fegin.bean.Orders;
import com.tuyue.util.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/4/18.
 */
@FeignClient(value = "carport-deal",fallback = OrderHystric.class)
public interface OrderFegin {
    /**
     * 添加订单
     * @param orders
     * @return
     */
    @RequestMapping("carport/order/inOrders")
    public Result inOrders(@RequestBody Orders orders);

    /**
     * 修改订单
     * @param orders
     * @return
     */
    @RequestMapping("carport/order/upOrders")
    public Result upOrders(@RequestBody Orders orders);


    /**
     * 删除订单
     * @param orderId
     * @param type 1是商家删除2买家删除
     * @return
     */
    @RequestMapping("carport/order/delOrder")
    public Result delOrder(@RequestParam("orderId")int orderId,@RequestParam("type")int type);


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
    public Result orderList(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize,
                            @RequestParam("aid") Integer aid,@RequestParam("type") Integer type,
                            @RequestParam("time")  Integer time, @RequestParam("str") String str,
                            @RequestParam("status") int status) throws Exception;
    /**
     * 关闭交易
     * @param orderId
     * @param msg
     * @return
     */
    @RequestMapping("carport/order/delOrder")
    public Result closeOrder(@RequestParam("orderId")int orderId,@RequestParam("msg")String msg) throws Exception;

    /**
     * 发货
     * @param orderId
     * @param imgUrl
     * @return
     */
    @RequestMapping("carport/order/deliverGoods")
    public Result deliverGoods(@RequestParam("orderId")int orderId,@RequestParam("imgUrl")String imgUrl) throws Exception;


    /**
     * 修改车位回显信息商家或者买家
     * @param orderId
     * @param type 1商家2买家
     * @return
     */
    @RequestMapping("carport/order/upOrderDetails")
    public Result upOrderDetails(@RequestParam("orderId")int orderId,@RequestParam("type")int type)throws Exception;


    /**
     * 查询 商家或者买家订单类型数量
     */
    @RequestMapping("carport/order/orderTypeNum")
    public Result orderTypeNum(@RequestParam("aid")int aid, @RequestParam("type")int type);

    /**
     * 根据车牌归属省查询用的最多的车牌号
     * @param carHome
     * @return
     */
    @RequestMapping("carport/order/selectCarNumber")
    public Result selectCarNumber(String carHome);

    /**
     * 催促发货提醒
     * @param orderId
     * @return
     */
    @RequestMapping("carport/order/urgeOrder")
    public Result urgeOrder(int orderId) throws Exception ;



    /**
     * 确认收货
     * @param orderId
     * @param aid
     * @return
     */
    @RequestMapping("carport/order/confirmOrder")
    public Result confirmOrder(@RequestParam("orderId")int orderId ,@RequestParam("aid")int aid) throws Exception;

    /**
     * 追加评价回显信息
     * @param orderId
     * @param aid
     * @return
     */
    @RequestMapping("carport/order/appraiseBack")
    public Result appraiseBack(@RequestParam("orderId")int orderId, @RequestParam("aid")int aid ) throws Exception;

    /**
     * 根据订单号查询订单详情（支付的时候）
     * @param orderNumber
     * @return
     */
    @RequestMapping("carport/order/orderDelByNumber")
    public Result orderDelByNumber(String orderNumber) throws Exception;

}
