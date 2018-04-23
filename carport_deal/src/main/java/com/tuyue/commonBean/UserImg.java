package com.tuyue.commonBean;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 用户图片表
 * </p>
 *
 * @author Yanghu123
 * @since 2018-03-07
 */
@TableName("user_img")
public class UserImg extends Model<UserImg> {

    private static final long serialVersionUID = 1L;

    /**
     * 图片id
     */
    @TableId(value = "img_id", type = IdType.AUTO)
    private Integer imgId;
    /**
     * 主键
     */
    private Integer aid;
    /**
     * 图片地址
     */
    @TableField("img_url")
    private String imgUrl;
    /**
     * 图片类型
     */
    @TableField("img_type")
    private Integer imgType;


    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
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
    protected Serializable pkVal() {
        return this.imgId;
    }

    @Override
    public String toString() {
        return "UserImg{" +
        ", imgId=" + imgId +
        ", aid=" + aid +
        ", imgUrl=" + imgUrl +
        ", imgType=" + imgType +
        "}";
    }
}
