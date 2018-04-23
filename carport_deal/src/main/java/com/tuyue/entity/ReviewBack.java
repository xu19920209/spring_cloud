package com.tuyue.entity;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
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
 * @since 2018-04-16
 */
@TableName("review_back")
public class ReviewBack extends Model<ReviewBack> {

    private static final long serialVersionUID = 1L;

    /**
     * Did
     */
    @TableId(value = "did", type = IdType.AUTO)
    private Integer did;
    /**
     * 用户ID（可为空）
     */
    private Integer aid;
    /**
     * 车位发布bid
     */
    private Integer bid;
    /**
     * 评论类型（1差2中3好）
     */
    @TableField("review_type")
    private Integer reviewType;
    /**
     * 真实度星级
     */
    @TableField("true_grade")
    private Integer trueGrade;
    /**
     * 服务满意度星级
     */
    @TableField("serve_grade")
    private Integer serveGrade;
    /**
     * 评论内容
     */
    @TableField("review_content")
    private String reviewContent;
    /**
     * 评论时间
     */
    @TableField("review_time")
    private Date reviewTime;
    /**
     * 是否认证
     */
    @TableField("is_approve")
    private Integer isApprove;
    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;
    /**
     * 头像
     */
    @TableField("user_img")
    private String userImg;
    /**
     * IP地址
     */
    private String ip;
    /**
     * 被评论的yonghu
     */
    @TableField("by_aid")
    private Integer byAid;
    /**
     * 1购买者评论2普通用户评论3商家回复评论
     */
    private Integer type;
    /**
     * 回复那条订单的评论
     */
    private Integer orderId;


    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
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

    public Integer getReviewType() {
        return reviewType;
    }

    public void setReviewType(Integer reviewType) {
        this.reviewType = reviewType;
    }

    public Integer getTrueGrade() {
        return trueGrade;
    }

    public void setTrueGrade(Integer trueGrade) {
        this.trueGrade = trueGrade;
    }

    public Integer getServeGrade() {
        return serveGrade;
    }

    public void setServeGrade(Integer serveGrade) {
        this.serveGrade = serveGrade;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public Date getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }

    public Integer getIsApprove() {
        return isApprove;
    }

    public void setIsApprove(Integer isApprove) {
        this.isApprove = isApprove;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getByAid() {
        return byAid;
    }

    public void setByAid(Integer byAid) {
        this.byAid = byAid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    protected Serializable pkVal() {
        return this.did;
    }

    @Override
    public String toString() {
        return "ReviewBack{" +
        "did=" + did +
        ", aid=" + aid +
        ", bid=" + bid +
        ", reviewType=" + reviewType +
        ", trueGrade=" + trueGrade +
        ", serveGrade=" + serveGrade +
        ", reviewContent=" + reviewContent +
        ", reviewTime=" + reviewTime +
        ", isApprove=" + isApprove +
        ", userName=" + userName +
        ", userImg=" + userImg +
        ", ip=" + ip +
        ", byAid=" + byAid +
        ", type=" + type +
        ", orderId=" + orderId +
        "}";
    }


}
