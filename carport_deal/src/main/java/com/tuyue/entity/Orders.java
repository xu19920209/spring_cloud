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
 * <p>
 * </p>
 *
 * @author xukangkai123
 * @since 2018-04-09
 */
public class Orders extends Model<Orders> {

    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;
    /**
     * 用户id
     */
    private Integer aid;
    /**
     * 地址id
     */
    @TableField("address_id")
    private Integer addressId;
    /**
     * 订单号
     */
    @TableField("order_number")
    private String orderNumber;
    /**
     * 车位id
     */
    private Integer bid;
    /**
     * 车位类型
     */
    @TableField("carport_type")
    private String carportType;
    /**
     * 车位楼层
     */
    @TableField("carport_floor")
    private String carportFloor;
    /**
     * 车位编号
     */
    @TableField("carport_no")
    private String carportNo;
    /**
     * 车位单价
     */
    @TableField("carport_unit_money")
    private String carportUnitMoney;
    /**
     * 购买数量
     */
    @TableField("buy_num")
    private Integer buyNum;
    /**
     * 商家留言
     */
    @TableField("leave_word")
    private String leaveWord;
    /**
     * 订单金额
     */
    @TableField("order_money")
    private Double orderMoney;
    /**
     * 实付金额
     */
    @TableField("really_money")
    private Double reallyMoney;
    /**
     * 支付方式
     */
    @TableField("pay_way")
    private Integer payWay;
    /**
     * 支付状态（1已支付2未支付）
     */
    @TableField("pay_status")
    private Integer payStatus;
    /**
     * 支付详情
     */
    @TableField("pay_details")
    private String payDetails;
    /**
     * 订单状态（0,未支付,1代发货，2已发货，3已收货,4交易关闭,5退款中）
     */
    @TableField("order_status")
    private Integer orderStatus;
    /**
     * 支付时间
     */
    @TableField("pay_time")
    private Date payTime;
    /**
     * 下单时间
     */
    @TableField("order_time")
    private Date orderTime;
    /**
     * 订单失效时间
     */
    @TableField("out_time")
    private Date outTime;
    /**
     * 配送方式（1上门自提2送货上门）
     */
    private Integer payment;
    /**
     * 产权人姓名
     */
    @TableField("property_name")
    private String propertyName;
    /**
     * 产权人身份证号
     */
    @TableField("property_number")
    private String propertyNumber;
    /**
     * 车牌归属地
     */
    @TableField("car_home")
    private String carHome;
    /**
     * 车牌
     */
    @TableField("car_level")
    private String carLevel;
    /**
     * 车牌号
     */
    @TableField("car_number")
    private String carNumber;
    /**
     * 商家删除订单(1删2未删)
     */
    @TableField("merchant_del")
    private Integer merchantDel;
    /**
     * 买家删除订单（1删2未删）
     */
    @TableField("buyer_del")
    private Integer buyerDel;
    /**
     * 是否评价(1是2否3默认评价,4已回复)
     */
    @TableField("is_appraise")
    private Integer isAppraise;
    /**
     * 取消原因
     */
    @TableField("cancel_cause")
    private String cancelCause;
    /**
     * 商家是否修改过订单，如果商家修改过订单在支付的时候不需要验证金额（1是2否）
     */
    private Integer type;
    @TableField("deliver_img")
    private String deliverImg;
    /**
     * 1商家已回复
     * 2商家未回复
     */
    private int isBackAppraise;

    private double unitMoney;

    public double getUnitMoney() {
        return unitMoney;
    }

    public void setUnitMoney(double unitMoney) {
        this.unitMoney = unitMoney;
    }

    public int getIsBackAppraise() {
        return isBackAppraise;
    }

    public void setIsBackAppraise(int isBackAppraise) {
        this.isBackAppraise = isBackAppraise;
    }

    public String getDeliverImg() {
        return deliverImg;
    }

    public void setDeliverImg(String deliverImg) {
        this.deliverImg = deliverImg;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getCarportType() {
        return carportType;
    }

    public void setCarportType(String carportType) {
        this.carportType = carportType;
    }

    public String getCarportFloor() {
        return carportFloor;
    }

    public void setCarportFloor(String carportFloor) {
        this.carportFloor = carportFloor;
    }

    public String getCarportNo() {
        return carportNo;
    }

    public void setCarportNo(String carportNo) {
        this.carportNo = carportNo;
    }

    public String getCarportUnitMoney() {
        return carportUnitMoney;
    }

    public void setCarportUnitMoney(String carportUnitMoney) {
        this.carportUnitMoney = carportUnitMoney;
    }

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    public String getLeaveWord() {
        return leaveWord;
    }

    public void setLeaveWord(String leaveWord) {
        this.leaveWord = leaveWord;
    }

    public Double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Double getReallyMoney() {
        return reallyMoney;
    }

    public void setReallyMoney(Double reallyMoney) {
        this.reallyMoney = reallyMoney;
    }

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public String getPayDetails() {
        return payDetails;
    }

    public void setPayDetails(String payDetails) {
        this.payDetails = payDetails;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyNumber() {
        return propertyNumber;
    }

    public void setPropertyNumber(String propertyNumber) {
        this.propertyNumber = propertyNumber;
    }

    public String getCarHome() {
        return carHome;
    }

    public void setCarHome(String carHome) {
        this.carHome = carHome;
    }

    public String getCarLevel() {
        return carLevel;
    }

    public void setCarLevel(String carLevel) {
        this.carLevel = carLevel;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Integer getMerchantDel() {
        return merchantDel;
    }

    public void setMerchantDel(Integer merchantDel) {
        this.merchantDel = merchantDel;
    }

    public Integer getBuyerDel() {
        return buyerDel;
    }

    public void setBuyerDel(Integer buyerDel) {
        this.buyerDel = buyerDel;
    }

    public Integer getIsAppraise() {
        return isAppraise;
    }

    public void setIsAppraise(Integer isAppraise) {
        this.isAppraise = isAppraise;
    }

    public String getCancelCause() {
        return cancelCause;
    }

    public void setCancelCause(String cancelCause) {
        this.cancelCause = cancelCause;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    protected Serializable pkVal() {
        return this.orderId;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", aid=" + aid +
                ", addressId=" + addressId +
                ", orderNumber=" + orderNumber +
                ", bid=" + bid +
                ", carportType=" + carportType +
                ", carportFloor=" + carportFloor +
                ", carportNo=" + carportNo +
                ", carportUnitMoney=" + carportUnitMoney +
                ", buyNum=" + buyNum +
                ", leaveWord=" + leaveWord +
                ", orderMoney=" + orderMoney +
                ", reallyMoney=" + reallyMoney +
                ", payWay=" + payWay +
                ", payStatus=" + payStatus +
                ", payDetails=" + payDetails +
                ", orderStatus=" + orderStatus +
                ", payTime=" + payTime +
                ", orderTime=" + orderTime +
                ", outTime=" + outTime +
                ", payment=" + payment +
                ", propertyName=" + propertyName +
                ", propertyNumber=" + propertyNumber +
                ", carHome=" + carHome +
                ", carLevel=" + carLevel +
                ", carNumber=" + carNumber +
                ", merchantDel=" + merchantDel +
                ", buyerDel=" + buyerDel +
                ", isAppraise=" + isAppraise +
                ", cancelCause=" + cancelCause +
                ", type=" + type +
                "}";
    }
}
