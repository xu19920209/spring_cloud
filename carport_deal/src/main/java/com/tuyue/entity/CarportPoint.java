package com.tuyue.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 车位点击次数
 * </p>
 *
 * @author xukangkai123
 * @since 2018-03-19
 */
@TableName("carport_point")
public class CarportPoint extends Model<CarportPoint> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("point_id")
    private Integer pointId;
    /**
     * 车位id
     */
    private Integer bid;
    /**
     * ip地址
     */
    private String ip;
    /**
     * 用户id
     */
    private Integer aid;
    /**
     * 点击次数
     */
    @TableField("point_num")
    private Integer pointNum;
    /**
     * 点击时间
     */
    @TableField("point_time")
    private Date pointTime;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getPointId() {
        return pointId;
    }

    public void setPointId(Integer pointId) {
        this.pointId = pointId;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPointNum() {
        return pointNum;
    }

    public void setPointNum(Integer pointNum) {
        this.pointNum = pointNum;
    }

    public Date getPointTime() {
        return pointTime;
    }

    public void setPointTime(Date pointTime) {
        this.pointTime = pointTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.pointId;
    }

    @Override
    public String toString() {
        return "CarportPoint{" +
        ", pointId=" + pointId +
        ", bid=" + bid +
        ", ip=" + ip +
        ", pointNum=" + pointNum +
        ", pointTime=" + pointTime +
        "}";
    }
}
