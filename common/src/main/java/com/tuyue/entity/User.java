package com.tuyue.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;

import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author Yanghu123
 * @since 2018-03-07
 */
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "aid", type = IdType.AUTO)
    private Integer aid;
    /**
     * 昵称(用户是昵称,企业是公司名称)
     */
    @TableField("user_name")
    private String userName;

    /**
     * 手机号
     */
    private String phone;
    /**
     * 密码
     */
    private String password;
    /**
     * 账户类型（1个人,2企业）
     */
    private Integer flag;
    /**
     * 头像
     */
    private String ioc;
    /**
     * 性别（0女1男2保密）
     */
    private String sex;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 区
     */
    private String region;
    /**
     * 生日
     */
    private String birthday;
    /**
     * 联系地址
     */
    private String address;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 联系电话
     */
    private String tel;
    /**
     * QQ
     */
    private String qq;
    /**
     * 真实姓名
     */
    @TableField("real_name")
    private String realName;
    /**
     * 证件类型(1默认身份证)
     */
    @TableField("papers_type")
    private Integer papersType;
    /**
     * 身份证号码
     */
    @TableField("identity_no")
    private String identityNo;
    /**
     * 是否实名认证（1是2否）
     */
    @TableField("is_approve")
    private Integer isApprove;
    /**
     * 企业类型
     */
    @TableField("company_type")
    private Integer companyType;
    /**
     * 公司规模
     */
    @TableField("company_scale")
    private String companyScale;
    /**
     * 创建时间
     */
    @TableField("creat_time")
    private Date creatTime;
    /**
     * 来源
     */
    private Integer source;
    /**
     * 是否删除(1是2否)
     */
    @TableField("is_del")
    private Integer isDel;
    @TableField("company_desc")
    private String companyDesc;

    private List<UserImg> userImgList;


    public String getCompanyDesc() {
        return companyDesc;
    }

    public void setCompanyDesc(String companyDesc) {
        this.companyDesc = companyDesc;
    }

    public List<UserImg> getUserImgList() {
        return userImgList;
    }

    public void setUserImgList(List<UserImg> userImgList) {
        this.userImgList = userImgList;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getIoc() {
        return ioc;
    }

    public void setIoc(String ioc) {
        this.ioc = ioc;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getPapersType() {
        return papersType;
    }

    public void setPapersType(Integer papersType) {
        this.papersType = papersType;
    }

    public String getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    public Integer getIsApprove() {
        return isApprove;
    }

    public void setIsApprove(Integer isApprove) {
        this.isApprove = isApprove;
    }

    public Integer getCompanyType() {
        return companyType;
    }

    public void setCompanyType(Integer companyType) {
        this.companyType = companyType;
    }

    public String getCompanyScale() {
        return companyScale;
    }

    public void setCompanyScale(String companyScale) {
        this.companyScale = companyScale;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    @Override
    protected Serializable pkVal() {
        return this.aid;
    }

    @Override
    public String toString() {
        return "User{" +
        "aid=" + aid +
        ", userName=" + userName +
        ", phone=" + phone +
        ", password=" + password +
        ", flag=" + flag +
        ", ioc=" + ioc +
        ", sex=" + sex +
        ", province=" + province +
        ", city=" + city +
        ", region=" + region +
        ", birthday=" + birthday +
        ", address=" + address +
        ", email=" + email +
        ", tel=" + tel +
        ", qq=" + qq +
        ", realName=" + realName +
        ", papersType=" + papersType +
        ", identityNo=" + identityNo +
        ", isApprove=" + isApprove +
        ", companyType=" + companyType +
        ", companyScale=" + companyScale +
        ", creatTime=" + creatTime +
        ", source=" + source +
        ", isDel=" + isDel +
        "}";
    }
}
