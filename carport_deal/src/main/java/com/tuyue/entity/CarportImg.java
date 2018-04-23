package com.tuyue.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Yanghu123
 * @since 2018-03-09
 */
@TableName("carport_img")
public class CarportImg  {

    /**
     * Bid
     */
    private Integer bid;
    /**
     * img_url
     */
    @TableField("img_url")
    private String imgUrl;
    /**
     * img_type(1是首页图2是车位详情图3证件4车位图)
     */
    @TableField("img_type")
    private Integer imgType;


    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getImgType() {
        return imgType;
    }

    public void setImgType(Integer imgType) {
        this.imgType = imgType;
    }



    @Override
    public String toString() {
        return "CarportImg{" +
        ", bid=" + bid +
        ", imgUrl=" + imgUrl +
        ", imgType=" + imgType +
        "}";
    }
}
