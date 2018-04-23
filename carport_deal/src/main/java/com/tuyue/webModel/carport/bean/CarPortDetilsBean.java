package com.tuyue.webModel.carport.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import com.tuyue.entity.Carport;
import com.tuyue.entity.CarportImg;
import com.tuyue.entity.CarportNo;

import java.util.List;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/3/20.
 */
public class CarPortDetilsBean {
    private String linkman;//联系人
    private String pjone;//手机号
    private String areaCode;//区号
    private String telePhone;//电话
    private Float maxSize;//限高
    private Double carSize;//车长
    private Double carWide;//车宽
    private Double carHigh;//车高
    private Double carWeight;//车重
    private Integer carportNum;//车位数量
    private String title;//标题
    private String floors;//车位楼层
    private String companyName;//个人或者企业名称
    private String carportType;//车位类型
    private String details;//详情描述
    private Integer isAttention;//是否关注过1关注过2未关注过
    private List<CarportImg> imglist;//图片列表
    private List<CarportNo>carportNoList;//车位编号
    private Integer proveType;//是否认证1是2否
    private Integer titledeedType;//产权证类别（1使用权2产权证）
    private String titledeedTime;// 使用期限
    private Integer aid;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getPjone() {
        return pjone;
    }

    public void setPjone(String pjone) {
        this.pjone = pjone;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getTelePhone() {
        return telePhone;
    }

    public void setTelePhone(String telePhone) {
        this.telePhone = telePhone;
    }

    public Float getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Float maxSize) {
        this.maxSize = maxSize;
    }

    public Double getCarSize() {
        return carSize;
    }

    public void setCarSize(Double carSize) {
        this.carSize = carSize;
    }

    public Double getCarWide() {
        return carWide;
    }

    public void setCarWide(Double carWide) {
        this.carWide = carWide;
    }

    public Double getCarHigh() {
        return carHigh;
    }

    public void setCarHigh(Double carHigh) {
        this.carHigh = carHigh;
    }

    public Double getCarWeight() {
        return carWeight;
    }

    public void setCarWeight(Double carWeight) {
        this.carWeight = carWeight;
    }

    public Integer getCarportNum() {
        return carportNum;
    }

    public void setCarportNum(Integer carportNum) {
        this.carportNum = carportNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFloors() {
        return floors;
    }

    public void setFloors(String floors) {
        this.floors = floors;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCarportType() {
        return carportType;
    }

    public void setCarportType(String carportType) {
        this.carportType = carportType;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getIsAttention() {
        return isAttention;
    }

    public void setIsAttention(Integer isAttention) {
        this.isAttention = isAttention;
    }

    public List<CarportImg> getImglist() {
        return imglist;
    }

    public void setImglist(List<CarportImg> imglist) {
        this.imglist = imglist;
    }

    public List<CarportNo> getCarportNoList() {
        return carportNoList;
    }

    public void setCarportNoList(List<CarportNo> carportNoList) {
        this.carportNoList = carportNoList;
    }

    public Integer getProveType() {
        return proveType;
    }

    public void setProveType(Integer proveType) {
        this.proveType = proveType;
    }

    public Integer getTitledeedType() {
        return titledeedType;
    }

    public void setTitledeedType(Integer titledeedType) {
        this.titledeedType = titledeedType;
    }

    public String getTitledeedTime() {
        return titledeedTime;
    }

    public void setTitledeedTime(String titledeedTime) {
        this.titledeedTime = titledeedTime;
    }
}
