package com.tuyue.webModel.order.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.tuyue.entity.Orders;
import com.tuyue.util.Result;
import com.tuyue.webModel.order.bean.OrderBean;
import com.tuyue.webModel.order.bean.OrdersCount;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/4/9.
 */
public interface OrderService {
    /**
     * 添加订单
     * @param orders
     * @return
     */
    public int inOrders(Orders orders);

    /**
     * 修改订单
     * @param orders
     * @return
     */
    public int upOrders(Orders orders);


    /**
     * 删除订单
     * @param orderId
     * @param type 1是商家删除2买家删除
     * @return
     */

    public int delOrder(int orderId,int type);

    /**
     * 买家订单列表
     * @param aid
     * @param type  订单类型
     * @param time  时间 1三月2一年3所有
     * @return str 输入框输入的值
     */
    public List<OrderBean> orderList(Page<OrderBean> page,Integer aid, Integer type, Integer time, String str);

    /**
     * 商家订单列表
     * @param aid
     * @param type
     * @param time
     * @param str
     * @throws Exception
     */
    public List<OrderBean> orderListMerchant(Page<OrderBean> page,Integer aid, Integer type, Integer time, String str);

    /**
     * 关闭交易
     * @param orderId
     * @param msg
     * @return
     */
    public int closeOrder(int orderId,String msg) throws Exception;

    /**
     * 发货
     * @param orderId
     * @param imgUrl
     * @return
     */
    public int deliverGoods(int orderId,String imgUrl) throws Exception;


    /**
     * 修改车位回显信息商家或者买家
     * @param orderId
     * @param type 1商家2买家
     * @return
     */
    public OrderBean upOrderDetails(int orderId,int type)throws Exception;


    /**
     * 查询 商家或者买家订单类型数量
     */
    public List<OrdersCount> orderTypeNum(int aid, int type);

    /**
     * 根据车牌归属省查询用的最多的车牌号
     * @param carHome
     * @return
     */
    public String selectCarNumber(String carHome);

    /**
     * 催促发货提醒
     * @param orderId
     * @return
     */
    public Result urgeOrder(int orderId) throws Exception;



    /**
     * 确认收货
     * @param orderId
     * @param aid
     * @return
     */
    public int confirmOrder(int orderId ,int aid) throws Exception;

    /**
     * 追加评价回显信息
     * @param orderId
     * @param aid
     * @return
     */
    public Result appraiseBack(int orderId, int aid ) throws Exception;

    /**
     * 根据订单号查询订单详情（支付的时候）
     * @param orderNumber
     * @return
     */
    public Result orderDelByNumber(String orderNumber) throws Exception;

    /**
     * 商家回复评论回显信息
     * @param orderId
     * @return
     */
    public Result replyEcho(Integer orderId) throws Exception;
}
