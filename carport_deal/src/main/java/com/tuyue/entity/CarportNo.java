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
@TableName("carport_no")
public class CarportNo  {

    /**
     * Bid
     */
    private Integer bid;
    /**
     * carport_no
     */
    @TableField("carport_no")
    private String carportNo;


    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getCarportNo() {
        return carportNo;
    }

    public void setCarportNo(String carportNo) {
        this.carportNo = carportNo;
    }


    @Override
    public String toString() {
        return "CarportNo{" +
        ", bid=" + bid +
        ", carportNo=" + carportNo +
        "}";
    }
}
