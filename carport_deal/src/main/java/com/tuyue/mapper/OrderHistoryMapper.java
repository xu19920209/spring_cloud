package com.tuyue.mapper;

import com.tuyue.entity.OrderHistory;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xukangkai123
 * @since 2018-04-09
 */
@Repository
public interface OrderHistoryMapper extends BaseMapper<OrderHistory> {
    /**
     * 查询商家或者买家修改订单的历史记录
     * @param OrderId
     * @param type 1商家 2 买家
     * @return
     */
    public OrderHistory selectUpType(Integer OrderId,Integer type);

    /**
     * 查询改订单今天的提醒次数
     * @param orderId
     * @param time
     * @return
     */
    public int selectAlertNum(int orderId,String time);
}
