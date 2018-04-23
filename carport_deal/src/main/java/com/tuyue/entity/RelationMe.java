package com.tuyue.entity;

import java.io.Serializable;

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
 * @author Yanghu123
 * @since 2018-03-09
 */
@TableName("relation_me")
public class RelationMe extends Model<RelationMe> {

    private static final long serialVersionUID = 1L;

    /**
     * Fid
     */
    @TableId(value = "fid", type = IdType.AUTO)
    private Integer fid;
    /**
     * AID
     */
    private Integer aid;
    /**
     * Bid
     */
    private Integer bid;
    /**
     * 时间
     */
    @TableField("relation_time")
    private Date relationTime;
    /**
     * 是否删除
     */
    @TableField("is_del")
    private Integer isDel;


    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
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

    public Date getRelationTime() {
        return relationTime;
    }

    public void setRelationTime(Date relationTime) {
        this.relationTime = relationTime;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    @Override
    protected Serializable pkVal() {
        return this.fid;
    }

    @Override
    public String toString() {
        return "RelationMe{" +
        ", fid=" + fid +
        ", aid=" + aid +
        ", bid=" + bid +
        ", relationTime=" + relationTime +
        ", isDel=" + isDel +
        "}";
    }
}
