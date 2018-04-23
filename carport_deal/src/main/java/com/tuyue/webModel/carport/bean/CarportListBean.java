package com.tuyue.webModel.carport.bean;


import java.util.Date;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/3/19.
 */
public class CarportListBean {
    private Integer rentType;//车位类型
    private Integer aid;
    private Integer bid;
    private String title;
    private String hourseName;
    private String province;
    private String city;
    private String region;
    private String housesAdress;
    private String money;
    private String mainImg;
    private String carportType;//露天机械地下
    private Integer imgNum;//图片个数
    private Integer browseNum;//浏览次数
    private Integer attentionNum;//关注次数
    private Integer fakeNum;//被标记为虚假信息
    private String issueTime;//发布时间
    private String companyType;// 个人 或者企业
    private Float maxSize;//限高
    private int isSale;//是否特价 1是2不是
    private Double salePrice;//特价价格

    public int getIsSale() {
        return isSale;
    }

    public void setIsSale(int isSale) {
        this.isSale = isSale;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public int getRentType() {
        return rentType;
    }

    public void setRentType(int rentType) {
        this.rentType = rentType;
    }

    public Float getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Float maxSize) {
        this.maxSize = maxSize;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHourseName() {
        return hourseName;
    }

    public void setHourseName(String hourseName) {
        this.hourseName = hourseName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getHousesAdress() {
        return housesAdress;
    }

    public void setHousesAdress(String housesAdress) {
        this.housesAdress = housesAdress;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getMainImg() {
        return mainImg;
    }

    public void setMainImg(String mainImg) {
        this.mainImg = mainImg;
    }

    public String getCarportType() {
        return carportType;
    }

    public void setCarportType(String carportType) {
        this.carportType = carportType;
    }

    public Integer getImgNum() {
        return imgNum;
    }

    public void setImgNum(Integer imgNum) {
        this.imgNum = imgNum;
    }

    public Integer getBrowseNum() {
        return browseNum;
    }

    public void setBrowseNum(Integer browseNum) {
        this.browseNum = browseNum;
    }

    public Integer getAttentionNum() {
        return attentionNum;
    }

    public void setAttentionNum(Integer attentionNum) {
        this.attentionNum = attentionNum;
    }

    public Integer getFakeNum() {
        return fakeNum;
    }

    public void setFakeNum(Integer fakeNum) {
        this.fakeNum = fakeNum;
    }

    public String getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(String issueTime) {
        this.issueTime = issueTime;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    @Override
    public String toString() {
        return "CarportListBean{" +
                "aid=" + aid +
                ", bid=" + bid +
                ", title='" + title + '\'' +
                ", hourseName='" + hourseName + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", housesAdress='" + housesAdress + '\'' +
                ", money='" + money + '\'' +
                ", mainImg='" + mainImg + '\'' +
                ", carportType='" + carportType + '\'' +
                ", imgNum=" + imgNum +
                ", browseNum=" + browseNum +
                ", attentionNum=" + attentionNum +
                ", fakeNum=" + fakeNum +
                ", issueTime='" + issueTime + '\'' +
                '}';
    }
}
