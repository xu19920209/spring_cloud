package com.tuyue.commonBean;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * com_houses楼盘表
 * </p>
 *
 * @author Yanghu123
 * @since 2018-03-07
 */
@TableName("com_hourses")
public class ComHourses extends Model<ComHourses> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "hourse_id", type = IdType.AUTO)
    private Integer hourseId;
    /**
     * 楼盘名称
     */
    @TableField("hourse_name")
    private String hourseName;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 区
     */
    private String region;
    /**
     * 详细地址
     */
    @TableField("houses_adress")
    private String housesAdress;
    /**
     * 精度
     */
    private Double lng;
    /**
     * 纬度
     */
    private Double lat;
    /**
     * 来源
     */
    private Integer sourse;
    /**
     * 创建时间
     */
    @TableField("creat_time")
    private Date creatTime;
    public Integer getHourseId() {
        return hourseId;
    }

    public void setHourseId(Integer hourseId) {
        this.hourseId = hourseId;
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

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Integer getSourse() {
        return sourse;
    }

    public void setSourse(Integer sourse) {
        this.sourse = sourse;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.hourseId;
    }

    @Override
    public String toString() {
        return "ComHouses{" +
        ", hourseId=" + hourseId +
        ", hourseName=" + hourseName +
        ", province=" + province +
        ", city=" + city +
        ", region=" + region +
        ", housesAdress=" + housesAdress +
        ", lng=" + lng +
        ", lat=" + lat +
        ", sourse=" + sourse +
        ", creatTime=" + creatTime +
        "}";
    }
}
