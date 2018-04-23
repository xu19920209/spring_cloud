package com.tuyue.commonBean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 用户地址表
 * </p>
 *
 * @author xukangkai123
 * @since 2018-04-19
 */
@TableName("user_address")
public class UserAddress extends Model<UserAddress> {

    private static final long serialVersionUID = 1L;

    /**
     * AID
     */
    private Integer aid;
    /**
     * 地址id
     */
    @TableId(value = "address_id", type = IdType.AUTO)
    private Integer addressId;
    /**
     * 收件人姓名
     */
    @TableField("recipients_name")
    private String recipientsName;
    /**
     * 手机号
     */
    @TableField("recipients_phone")
    private String recipientsPhone;
    /**
     * 地址
     */
    private String address;
    /**
     * 详细地址
     */
    @TableField("detail_address")
    private String detailAddress;
    /**
     * 是否为默认地址(0不是1是)
     */
    @TableField("is_default")
    private Integer isDefault;


    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
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
                "}";
    }

    public static void main(String[] args) {
        String string = JSON.toJSONString(new UserAddress(), SerializerFeature.WriteMapNullValue);
        System.out.println(string);
    }
}
