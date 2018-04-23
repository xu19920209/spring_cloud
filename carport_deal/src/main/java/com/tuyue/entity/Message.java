package com.tuyue.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author xukangkai123
 * @since 2018-04-12
 */
public class Message extends Model<Message> {

    private static final long serialVersionUID = 1L;

    /**
     * Fid
     */
    @TableId(value = "fid", type = IdType.AUTO)
    private Integer fid;
    /**
     * AID
     */
    private Integer aid;
    /**
     * Bid
     */
    private Integer bid;
    /**
     * 时间
     */
    @TableField("creat_time")
    private Date creatTime;
    /**
     * 类型(1商修改2买家修改,3联系4降价5发货6催货7商家关闭交易)
     */
    private Integer type;
    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;
    /**
     * 订单号
     */
    @TableField("order_no")
    private String orderNo;
    /**
     * 电话
     */
    private String phone;
    /**
     * 车位标题
     */
    private String title;
    /**
     * 1应用消息2系统消息
     */
    @TableField("message_type")
    private Integer messageType;


    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    @Override
    protected Serializable pkVal() {
        return this.fid;
    }

    @Override
    public String toString() {
        return "Message{" +
        "fid=" + fid +
        ", aid=" + aid +
        ", bid=" + bid +
        ", creatTime=" + creatTime +
        ", type=" + type +
        ", userName=" + userName +
        ", orderNo=" + orderNo +
        ", phone=" + phone +
        ", title=" + title +
        ", messageType=" + messageType +
        "}";
    }
}
