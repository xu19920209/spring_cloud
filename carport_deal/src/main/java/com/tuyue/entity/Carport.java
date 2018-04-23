package com.tuyue.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
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
 * @since 2018-03-13
 */
public class Carport extends Model<Carport> {

    private static final long serialVersionUID = 1L;

    /**
     * Bid
     */
    @TableId(value = "bid", type = IdType.AUTO)
    private Integer bid;
    /**
     * 发布人ID
     */
    private Integer aid;
    /**
     * 楼盘id
     */
    @TableField("hourse_id")
    private Integer hourseId;
    /**
     * 商圈id
     */
    @TableField("com_busines_id")
    private Integer comBusinesId;
    /**
     * 标题
     */
    private String title;
    /**
     * 车位类型（1露天2机械3地下）
     */
    @TableField("carport_type")
    private String carportType;
    /**
     * 限高
     */
    @TableField("max_size")
    private Float maxSize;
    /**
     * 车长
     */
    @TableField("car_size")
    private Float carSize;
    /**
     * 车宽
     */
    @TableField("car_wide")
    private Float carWide;
    /**
     * 车高
     */
    @TableField("car_high")
    private Float carHigh;
    /**
     * 车重
     */
    @TableField("car_weight")
    private Float carWeight;
    /**
     * 发布类型（1出租2转让3出售5求购6求租）
     */
    @TableField("rent_type")
    private Integer rentType;
    /**
     * 固定车位非固定车位
     */
    @TableField("fix_carport")
    private Integer fixCarport;
    /**
     * 车位价格 (低价)
     */
    @TableField("carport_money")
    private Double carportMoney;
    /**
     * 车位价格(高价）
     */
    @TableField("carport_price")
    private Double carportPrice;
    /**
     * 是否特价（1是2否）
     */
    @TableField("is_sale")
    private Integer isSale;
    /**
     * 特价价格
     */
    @TableField("sale_price")
    private Double salePrice;
    /**
     * 是否降价（1是2否）
     */
    @TableField("is_lower_money")
    private Integer isLowerMoney;
    /**
     * 降价后价格
     */
    @TableField("lower_money")
    private Double lowerMoney;
    /**
     * 降价后价格2
     */
    @TableField("lower_price")
    private Double lowerPrice;
    /**
     * 是否设为一口价（1是2否）
     */
    @TableField("is_oneMoney")
    private Integer isOnemoney;
    /**
     * 价格时长（几月）
     */
    @TableField("money_time")
    private Integer moneyTime;
    /**
     * 联系人
     */
    @TableField("link_ame")
    private String linkName;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 是否保密（1是2否）
     */
    @TableField("is_privary")
    private Integer isPrivary;
    /**
     * 是否上架（1是2否）
     */
    @TableField("is_putaway")
    private Integer isPutaway;
    /**
     * 车位个数
     */
    @TableField("carport_num")
    private Integer carportNum;
    /**
     * 发布类型（1单个2批量）
     */
    @TableField("release_type")
    private Integer releaseType;
    /**
     * 产权证
     */
    private String titledeed;
    /**
     * 产权证类别（1使用权2产权证）
     */
    @TableField("titledeed_type")
    private Integer titledeedType;
    /**
     * 使用期限
     */
    @TableField("titledeed_time")
    private String titledeedTime;
    /**
     * 详情描述
     */
    private String details;
    /**
     * 产权证原名
     */
    @TableField("titledeed_name")
    private String titledeedName;
    /**
     * 车位图原名
     */
    @TableField("project_img_name")
    private String projectImgName;
    /**
     * 账户类型（1个人 2企业）
     */
    private Integer flag;
    /**
     * 操作时间
     */
    @TableField("up_time")
    private Date upTime;
    /**
     * 楼层
     */
    private String floors;
    /**
     * 楼层type(1是自定义2自定义范围)
     */
    @TableField("floors_type")
    private Integer floorsType;
    /**
     * 区号
     */
    @TableField("area_code")
    private String areaCode;
    /**
     * 电话
     */
    @TableField("tele_phone")
    private String telePhone;
    /**
     * 用户输入的楼层范围（批量发布才会有，存起来是为了后续操作方便）
     */
    @TableField("floors_num_original")
    private String floorsNumOriginal;
    /**
     * 用户勾选的楼层（（批量发布才会有，存起来是为了后续操作方便））
     */
    @TableField("floors_original")
    private String floorsOriginal;
    /**
     * 发布时间
     */
    @TableField("issue_time")
    private Date issueTime;

    public Integer getComBusinesId() {
        return comBusinesId;
    }

    public void setComBusinesId(Integer comBusinesId) {
        this.comBusinesId = comBusinesId;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getHourseId() {
        return hourseId;
    }

    public void setHourseId(Integer hourseId) {
        this.hourseId = hourseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCarportType() {
        return carportType;
    }

    public void setCarportType(String carportType) {
        this.carportType = carportType;
    }

    public Float getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Float maxSize) {
        this.maxSize = maxSize;
    }

    public Float getCarSize() {
        return carSize;
    }

    public void setCarSize(Float carSize) {
        this.carSize = carSize;
    }

    public Float getCarWide() {
        return carWide;
    }

    public void setCarWide(Float carWide) {
        this.carWide = carWide;
    }

    public Float getCarHigh() {
        return carHigh;
    }

    public void setCarHigh(Float carHigh) {
        this.carHigh = carHigh;
    }

    public Float getCarWeight() {
        return carWeight;
    }

    public void setCarWeight(Float carWeight) {
        this.carWeight = carWeight;
    }

    public Integer getRentType() {
        return rentType;
    }

    public void setRentType(Integer rentType) {
        this.rentType = rentType;
    }

    public Integer getFixCarport() {
        return fixCarport;
    }

    public void setFixCarport(Integer fixCarPort) {
        this.fixCarport = fixCarport;
    }


    public Integer getIsSale() {
        return isSale;
    }

    public void setIsSale(Integer isSale) {
        this.isSale = isSale;
    }

    public Integer getIsLowerMoney() {
        return isLowerMoney;
    }

    public void setIsLowerMoney(Integer isLowerMoney) {
        this.isLowerMoney = isLowerMoney;
    }

    public Integer getIsOnemoney() {
        return isOnemoney;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Double getCarportMoney() {
        return carportMoney;
    }

    public void setCarportMoney(Double carportMoney) {
        this.carportMoney = carportMoney;
    }

    public Double getCarportPrice() {
        return carportPrice;
    }

    public void setCarportPrice(Double carportPrice) {
        this.carportPrice = carportPrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Double getLowerMoney() {
        return lowerMoney;
    }

    public void setLowerMoney(Double lowerMoney) {
        this.lowerMoney = lowerMoney;
    }

    public Double getLowerPrice() {
        return lowerPrice;
    }

    public void setLowerPrice(Double lowerPrice) {
        this.lowerPrice = lowerPrice;
    }

    public void setIsOnemoney(Integer isOnemoney) {
        this.isOnemoney = isOnemoney;
    }

    public Integer getMoneyTime() {
        return moneyTime;
    }

    public void setMoneyTime(Integer moneyTime) {
        this.moneyTime = moneyTime;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getIsPrivary() {
        return isPrivary;
    }

    public void setIsPrivary(Integer isPrivary) {
        this.isPrivary = isPrivary;
    }

    public Integer getIsPutaway() {
        return isPutaway;
    }

    public void setIsPutaway(Integer isPutaway) {
        this.isPutaway = isPutaway;
    }

    public Integer getCarportNum() {
        return carportNum;
    }

    public void setCarportNum(Integer carportNum) {
        this.carportNum = carportNum;
    }

    public Integer getReleaseType() {
        return releaseType;
    }

    public void setReleaseType(Integer releaseType) {
        this.releaseType = releaseType;
    }

    public String getTitledeed() {
        return titledeed;
    }

    public void setTitledeed(String titledeed) {
        this.titledeed = titledeed;
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getTitledeedName() {
        return titledeedName;
    }

    public void setTitledeedName(String titledeedName) {
        this.titledeedName = titledeedName;
    }

    public String getProjectImgName() {
        return projectImgName;
    }

    public void setProjectImgName(String projectImgName) {
        this.projectImgName = projectImgName;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    public String getFloors() {
        return floors;
    }

    public void setFloors(String floors) {
        this.floors = floors;
    }

    public Integer getFloorsType() {
        return floorsType;
    }

    public void setFloorsType(Integer floorsType) {
        this.floorsType = floorsType;
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

    public String getFloorsNumOriginal() {
        return floorsNumOriginal;
    }

    public void setFloorsNumOriginal(String floorsNumOriginal) {
        this.floorsNumOriginal = floorsNumOriginal;
    }

    public String getFloorsOriginal() {
        return floorsOriginal;
    }

    public void setFloorsOriginal(String floorsOriginal) {
        this.floorsOriginal = floorsOriginal;
    }

    public Date getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(Date issueTime) {
        this.issueTime = issueTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.bid;
    }

    @Override
    public String toString() {
        return "Carport{" +
        ", bid=" + bid +
        ", aid=" + aid +
        ", hourseId=" + hourseId +
        ", title=" + title +
        ", carportType=" + carportType +
        ", maxSize=" + maxSize +
        ", carSize=" + carSize +
        ", carWide=" + carWide +
        ", carHigh=" + carHigh +
        ", carWeight=" + carWeight +
        ", rentType=" + rentType +
        ", fixCarport=" + fixCarport +
        ", carportMoney=" + carportMoney +
        ", carportPrice=" + carportPrice +
        ", isSale=" + isSale +
        ", salePrice=" + salePrice +
        ", isLowerMoney=" + isLowerMoney +
        ", lowerMoney=" + lowerMoney +
        ", lowerPrice=" + lowerPrice +
        ", isOnemoney=" + isOnemoney +
        ", moneyTime=" + moneyTime +
        ", linkName=" + linkName +
        ", phone=" + phone +
        ", isPrivary=" + isPrivary +
        ", isPutaway=" + isPutaway +
        ", carportNum=" + carportNum +
        ", releaseType=" + releaseType +
        ", titledeed=" + titledeed +
        ", titledeedType=" + titledeedType +
        ", titledeedTime=" + titledeedTime +
        ", details=" + details +
        ", titledeedName=" + titledeedName +
        ", projectImgName=" + projectImgName +
        ", flag=" + flag +
        ", upTime=" + upTime +
        ", floors=" + floors +
        ", floorsType=" + floorsType +
        ", areaCode=" + areaCode +
        ", telePhone=" + telePhone +
        ", floorsNumOriginal=" + floorsNumOriginal +
        ", floorsOriginal=" + floorsOriginal +
        ", issueTime=" + issueTime +
        "}";
    }
}
