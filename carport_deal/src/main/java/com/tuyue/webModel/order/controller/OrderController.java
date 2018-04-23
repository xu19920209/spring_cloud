package com.tuyue.webModel.order.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.tuyue.entity.Orders;
import com.tuyue.util.Result;
import com.tuyue.webModel.order.bean.OrderBean;
import com.tuyue.webModel.order.bean.OrdersCount;
import com.tuyue.webModel.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/4/10.
 */
@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    //@RequestMapping(value = "orderList",produces = {"application/json; charset=UTF-8"})
    public List<OrderBean> orderList(Integer aid, Integer currentPage, Integer pageSize, Integer type, Integer time, String str){
        Page<OrderBean> page=new Page();
        page.setCurrent(currentPage!=null?currentPage:1);
        page.setSize(pageSize!=null?pageSize:10);
        List<OrderBean> orderBeans = orderService.orderList(page, aid, type, time, str);
        System.out.println(page.getTotal());
        return orderBeans;
    }

    /**
     * 添加订单
     * @param orders
     * @return
     */
    public Result inOrders(@RequestBody Orders orders){
        int i = orderService.inOrders(orders);
        if(i>0){
            return Result.success();
        }
        return Result.error();
    }

    /**
     * 修改订单
     * @param orders
     * @return
     */
    public Result upOrders(@RequestBody Orders orders){
        int i = orderService.upOrders(orders);
        if(i>0){
            return Result.success();
        }
        return Result.error();
    }


    /**
     * 删除订单
     * @param orderId
     * @param type 1是商家删除2买家删除
     * @return
     */

    public Result delOrder(int orderId,int type){
        int i = orderService.delOrder(orderId,type);
        if(i>0){
            return Result.success();
        }
        return Result.error();
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
    public Result orderList(Integer currentPage, Integer pageSize,Integer aid, Integer type, Integer time, String str,int status) throws Exception{
        Page<OrderBean> page=new Page();
        page.setCurrent(currentPage!=null?currentPage:1);
        page.setSize(pageSize!=null?pageSize:10);
        if(status==2){
            List<OrderBean> orderBeans = orderService.orderList(page, aid, type, time, str);
            return Result.success(orderBeans);
        }else{
            List<OrderBean> orderBeans = orderService.orderListMerchant(page, aid, type, time, str);
            return Result.success(orderBeans);
        }

    }
    /**
     * 关闭交易
     * @param orderId
     * @param msg
     * @return
     */
    public Result closeOrder(int orderId,String msg) throws Exception{
        msg=new String(msg.getBytes("ISO-8859-1"),"UTF-8");
        int i = orderService.closeOrder(orderId, msg);
        if(i>0){
            return Result.success();
        }
        return Result.error();
    }

    /**
     * 发货
     * @param orderId
     * @param imgUrl
     * @return
     */
    public Result deliverGoods(int orderId,String imgUrl) throws Exception{
        int i = orderService.deliverGoods(orderId, imgUrl);
        if(i>0){
            return Result.success();
        }
        return Result.error();
    }


    /**
     * 修改车位回显信息商家或者买家
     * @param orderId
     * @param type 1商家2买家
     * @return
     */
    public Result upOrderDetails(int orderId,int type)throws Exception{
        OrderBean orderBean = orderService.upOrderDetails(orderId, type);
        return Result.success(orderBean);
    }


    /**
     * 查询 商家或者买家订单类型数量
     */
    public Result orderTypeNum(int aid, int type){
        List<OrdersCount> ordersCounts = orderService.orderTypeNum(aid, type);
        return Result.success(ordersCounts);
    }

    /**
     * 根据车牌归属省查询用的最多的车牌号
     * @param carHome
     * @return
     */
    public Result selectCarNumber(String carHome){
        String s = orderService.selectCarNumber(carHome);
        return Result.success(s);
    }

    /**
     * 催促发货提醒
     * @param orderId
     * @return
     */
    public Result urgeOrder(int orderId) throws Exception {
        return  orderService.urgeOrder(orderId);
    }



    /**
     * 确认收货
     * @param orderId
     * @param aid
     * @return
     */
    public Result confirmOrder(int orderId ,int aid) throws Exception{
        int i = orderService.confirmOrder(orderId, aid);
        if(i>0){
            return Result.success();
        }
        return Result.error();
    }

    /**
     * 追加评价回显信息
     * @param orderId
     * @param aid
     * @return
     */
    public Result appraiseBack(int orderId, int aid ) throws Exception{
        return orderService.appraiseBack(orderId,aid);
    }

    /**
     * 根据订单号查询订单详情（支付的时候）
     * @param orderNumber
     * @return
     */
    public Result orderDelByNumber(String orderNumber) throws Exception{
        return orderService.orderDelByNumber(orderNumber);
    }

    /**
     * 商家回复评论回显信息
     * @param orderId
     * @return
     */
    public Result replyEcho(Integer orderId) throws Exception{
        return orderService.replyEcho(orderId);
    }
}
