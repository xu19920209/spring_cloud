package com.tuyue.webModel.order.bean;

import com.tuyue.entity.CarportNo;

import java.sql.Timestamp;
import java.util.List;

public class OrderBean {
    private int orderId;
    private Integer aid;
    private Integer addressId;
    private String orderNumber;
    private Integer bid;
    private String carportType;
    private String carportFloor;
    private String carportNo;
    private String carportUnitMoney;
    private Integer buyNum;
    private String leaveWord;
    private Double orderMoney;
    private Double reallyMoney;
    private Integer payWay;
    private Integer payStatus;
    private String payDetails;
    private Integer orderStatus;
    private Timestamp payTime;
    private Timestamp orderTime;
    private Timestamp outTime;
    private Integer payment;
    private String propertyName;
    private String propertyNumber;
    private String carHome;
    private String carLevel;
    private String carNumber;
    private Integer merchantDel;
    private Integer buyerDel;
    private Integer isAppraise;
    private Integer titledeed_type;
    private String titledeed_time;
    private String phone;
    private String tel;
    private String floos;
    private List<CarportNo> carportNoList;
    private Integer upType=2;//是否修改 1修改2未修改
    private Timestamp upTime;//修改时间
    private String recipientsName; //收货人姓名
    private String recipientsPhone;//收货人电话
    private String address;//收货人地址
    private String detailAddress;//收货人详细地址
    private String title;//车位标题
    private String fixCarPort;//固定非固定车位
    private Integer rentType;//1出租2转让3出售5求租6求购
    private String name;//商家或者买家名字

    private String flooss;//车位里面的楼层
    private String carportTypes;//车位里面的类型

    public String getFlooss() {
        return flooss;
    }

    public void setFlooss(String flooss) {
        this.flooss = flooss;
    }

    public String getCarportTypes() {
        return carportTypes;
    }

    public void setCarportTypes(String carportTypes) {
        this.carportTypes = carportTypes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRentType() {
        return rentType;
    }

    public void setRentType(Integer rentType) {
        this.rentType = rentType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFixCarPort() {
        return fixCarPort;
    }

    public void setFixCarPort(String fixCarPort) {
        this.fixCarPort = fixCarPort;
    }

    public String getRecipientsName() {
        return recipientsName;
    }

    public void setRecipientsName(String recipientsName) {
        this.recipientsName = recipientsName;
    }

    public String getRecipientsPhone() {
        return recipientsPhone;
    }

    public void setRecipientsPhone(String recipientsPhone) {
        this.recipientsPhone = recipientsPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getFloos() {
        return floos;
    }

    public void setFloos(String floos) {
        this.floos = floos;
    }

    public List<CarportNo> getCarportNoList() {
        return carportNoList;
    }

    public void setCarportNoList(List<CarportNo> carportNoList) {
        this.carportNoList = carportNoList;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
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

    public Timestamp getPayTime() {
        return payTime;
    }

    public void setPayTime(Timestamp payTime) {
        this.payTime = payTime;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public Timestamp getOutTime() {
        return outTime;
    }

    public void setOutTime(Timestamp outTime) {
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

    public Timestamp getUpTime() {
        return upTime;
    }

    public void setUpTime(Timestamp upTime) {
        this.upTime = upTime;
    }

    public Integer getUpType() {
        return upType;
    }

    public void setUpType(Integer upType) {
        this.upType = upType;
    }

    public Integer getTitledeed_type() {
        return titledeed_type;
    }

    public void setTitledeed_type(Integer titledeed_type) {
        this.titledeed_type = titledeed_type;
    }

    public String getTitledeed_time() {
        return titledeed_time;
    }

    public void setTitledeed_time(String titledeed_time) {
        this.titledeed_time = titledeed_time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}