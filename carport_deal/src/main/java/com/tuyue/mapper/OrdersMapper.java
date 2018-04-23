package com.tuyue.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.tuyue.entity.Orders;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tuyue.webModel.order.bean.OrderBean;
import com.tuyue.webModel.order.bean.OrdersCount;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author xukangkai123
 * @since 2018-04-09
 */
@Repository
public interface OrdersMapper extends BaseMapper<Orders> {
    /**
     * 删除商家或者买家的订单1商家2买家
     *
     * @param orderId
     * @param type
     * @return
     */
    public int delOrdersByUser(int orderId, int type);

    /**
     * 买家订单列表
     *
     * @param aid
     * @param type 订单类型
     * @param time 时间 1三月2一年3所有
     * @return str 输入框输入的值
     */
    public List<OrderBean> orderList(Pagination page, @Param("aid") Integer aid, @Param("type") Integer type, @Param("time") Integer time, @Param("str") String str);

    /**
     * 商家订单列表
     *
     * @param aid
     * @param type 订单类型
     * @param time 时间 1三月2一年3所有
     * @return str 输入框输入的值
     */
    public List<OrderBean> orderListMerchant(Page<OrderBean> page, Integer aid, Integer type, Integer time, String str);
    /**
     * 查询 商家或者买家订单类型数量
     */
    public List<OrdersCount> orderTypeNum(int aid, int type);

    /**
     * 根据省查询使用最多的车牌号
     * @param string
     * @return
     */
    public Map<String,Object> selectCarNumber(String string);

    /**
     * 根据订单号查询订单
     * @param orderNumber
     * @return
     */
    public Orders selectByOrderNumber(String orderNumber);

    /**
     * 下订单时修改订单信息
     * @return
     */
    public int upOrderByNumber(String orderNumber);
}
