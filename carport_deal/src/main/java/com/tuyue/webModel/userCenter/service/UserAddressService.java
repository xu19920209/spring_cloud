package com.tuyue.webModel.userCenter.service;

import com.tuyue.entity.UserAddress;

import java.util.List;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/4/9.
 */
public interface UserAddressService {
    /**
     * 添加
     *
     * @return
     */
    public int inAddress(UserAddress userAddress);

    /**
     * 修改
     *
     * @param userAddress
     * @return
     */
    public int upAddress(UserAddress userAddress);

    /**
     * 删除地址
     *
     * @param addressId
     * @return
     */
    public int delAddress(int addressId);
    /**
     *  地址列表
     */
    public List<UserAddress> addressList(int aid);

}
