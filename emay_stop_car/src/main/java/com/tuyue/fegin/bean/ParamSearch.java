package com.tuyue.fegin.bean;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2017/10/31.
 */
public class ParamSearch {
    private Integer currentPage;
    private Integer pageSize;
    private String province; //省
    private String city;//市
    private String region;//区
    private Integer rentType;//车位类型（1出租2转让3出售4特价5全部）
    private Integer carportType;//1露天2机械3地下
    private String rentalscope;//sql语句
    private Integer flag;//1个人2企业
    private String str;//输入框输入的内容
    private String hourseId;//楼盘id的集合
    private Integer sort;//2按价格排序，默认是发布时间
    private Integer comBusinesId;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getHourseId() {
        return hourseId;
    }

    public void setHourseId(String hourseId) {
        this.hourseId = hourseId;
    }

    public Integer getComBusinesId() {
        return comBusinesId;
    }

    public void setComBusinesId(Integer comBusinesId) {
        this.comBusinesId = comBusinesId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
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
    public Integer getCarportType() {
        return carportType;
    }

    public void setCarportType(Integer carportType) {
        this.carportType = carportType;
    }

    public String getRentalscope() {
        return rentalscope;
    }

    public void setRentalscope(String rentalscope) {
        this.rentalscope = rentalscope;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getRentType() {
        return rentType;
    }

    public void setRentType(Integer rentType) {
        this.rentType = rentType;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "ParamSearch{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", rentType=" + rentType +
                ", carportType=" + carportType +
                ", rentalscope='" + rentalscope + '\'' +
                ", flag=" + flag +
                ", str='" + str + '\'' +
                ", hourseId='" + hourseId + '\'' +
                ", sort=" + sort +
                ", comBusinesId=" + comBusinesId +
                '}';
    }
}
