package com.tuyue.webModel.comment.bean;

import java.sql.Timestamp;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2017/11/6.
 */
public class DReviewBackBean {
    private int did;
    private Integer aid;
    private Integer bid;
    private Integer reviewType;
    private String trueGrade;
    private Integer serveGrade;
    private String reviewContent;
    private Timestamp reviewTime;
    private Integer isApprove;
    private String userName;
    private String userImg;
    private String ip;

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
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

    public String getTrueGrade() {
        return trueGrade;
    }

    public void setTrueGrade(String trueGrade) {
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

    public Timestamp getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Timestamp reviewTime) {
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
}
