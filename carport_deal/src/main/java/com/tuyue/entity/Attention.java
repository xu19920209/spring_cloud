package com.tuyue.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Yanghu123
 * @since 2018-03-09
 */
public class Attention extends Model<Attention> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键eid
     */
    @TableField("Attention_id")
    private Integer attentionId;
    /**
     * Bid
     */
    private Integer bid;
    /**
     * aid
     */
    private Integer aid;
    /**
     * 删除(1删2未删)
     */
    @TableField("is_del")
    private Integer isDel;


    public Integer getAttentionId() {
        return attentionId;
    }

    public void setAttentionId(Integer attentionId) {
        this.attentionId = attentionId;
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

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    @Override
    protected Serializable pkVal() {
        return this.attentionId;
    }

    @Override
    public String toString() {
        return "Attention{" +
        ", attentionId=" + attentionId +
        ", bid=" + bid +
        ", aid=" + aid +
        ", isDel=" + isDel +
        "}";
    }
}
