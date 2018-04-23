package com.tuyue.entity;

import java.io.Serializable;

import java.sql.Blob;
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
 * @since 2018-03-21
 */
@TableName("leave_word")
public class LeaveWord extends Model<LeaveWord> {

    private static final long serialVersionUID = 1L;

    @TableField("word_id")
    private int wordId;
    private Integer aid;
    private String name;
    private String content;
    private String userHead;
    private Integer id;
    @TableField("parent_id")
    private Integer parentId;
    @TableField("user_type")
    private Integer userType;
    private Integer bid;
    @TableField("word_time")
    private String wordTime;
    private Integer type;
    private Integer proveType;

    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getWordTime() {
        return wordTime;
    }

    public void setWordTime(String wordTime) {
        this.wordTime = wordTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getProveType() {
        return proveType;
    }

    public void setProveType(Integer proveType) {
        this.proveType = proveType;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "LeaveWord{" +
        "wordId=" + wordId +
        ", aid=" + aid +
        ", name=" + name +
        ", content=" + content +
        ", userHead=" + userHead +
        ", id=" + id +
        ", parentId=" + parentId +
        ", userType=" + userType +
        ", bid=" + bid +
        ", wordTime=" + wordTime +
        ", type=" + type +
        ", proveType=" + proveType +
        "}";
    }
}
