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
 * @author xukangkai123
 * @since 2018-04-09
 */
@TableName("user_address")
public class UserAddress extends Model<UserAddress> {

    private static final long serialVersionUID = 1L;
    private int aid;
    @TableField("address_id")
    private int addressId;
    @TableField("recipients_name")
    private String recipientsName;
    @TableField("recipients_phone")
    private String recipientsPhone;
    private String address;
    @TableField("detail_address")
    private String detailAddress;
    @TableField("is_default")
    private Integer isDefault;
    @TableField("is_delete")
    private Integer isDelete;


    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getRecipientsName() {
        return recipientsName;
    }

    public void setRecipientsName(String recipientsName) {
        this.recipientsName = recipientsName;
    }

    public String getRecipientsPhone() {
        return recipientsPhone;
    }

    public void setRecipientsPhone(String recipientsPhone) {
        this.recipientsPhone = recipientsPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    protected Serializable pkVal() {
        return this.addressId;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
        "aid=" + aid +
        ", addressId=" + addressId +
        ", recipientsName=" + recipientsName +
        ", recipientsPhone=" + recipientsPhone +
        ", address=" + address +
        ", detailAddress=" + detailAddress +
        ", isDefault=" + isDefault +
        ", isDelete=" + isDelete +
        "}";
    }
}
