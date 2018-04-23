package com.tuyue.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author xukangkai123
 * @since 2018-04-09
 */
@TableName("order_history")
public class OrderHistory extends Model<OrderHistory> {

    private static final long serialVersionUID = 1L;

    @TableField("order_id")
    private int orderId;
    @TableId(value = "history_id", type = IdType.AUTO)
    private int historyId;
    @TableField("up_time")
    private Date upTime;
    /**
     * 1商家修改2买家修改3买家提醒4发货5收货6商家关闭交易
     */
    private int type;


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    protected Serializable pkVal() {
        return this.historyId;
    }

    @Override
    public String toString() {
        return "OrderHistory{" +
        "orderId=" + orderId +
        ", historyId=" + historyId +
        ", upTime=" + upTime +
        ", type=" + type +
        "}";
    }
}
