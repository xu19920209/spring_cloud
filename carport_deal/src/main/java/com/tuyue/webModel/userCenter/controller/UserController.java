package com.tuyue.webModel.userCenter.controller;

import com.tuyue.commonBean.User;
import com.tuyue.entity.UserAddress;
import com.tuyue.fegin.user.UserFegin;
import com.tuyue.util.Result;
import com.tuyue.webModel.userCenter.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/4/9.
 */
@RestController
@RequestMapping("userAddress")
public class UserController {
    @Autowired
    private UserAddressService userAddressService;
    /**
     * 添加
     * @return
     */
    @RequestMapping("inAddress")
    public Result inAddress(UserAddress userAddress) {
        int i = userAddressService.inAddress(userAddress);
        if (i > 0) {
            return Result.success(1, "SUCCESS");
        }
        return Result.error(2, "error");
    }

    /**
     * 修改
     * @param userAddress
     * @return
     */
    @RequestMapping("upAddress")
    public Result upAddress(UserAddress userAddress) {
        int i = userAddressService.upAddress(userAddress);
        if (i > 0) {
            return Result.success(1, "SUCCESS");
        }
        return Result.error(2, "error");
    }

    /**
     * 删除地址
     *
     * @param addressId
     * @return
     */
    @RequestMapping("delAddress")
    public Result delAddress(int addressId){
        int i = userAddressService.delAddress(addressId);
        if (i > 0) {
            return Result.success(1, "SUCCESS");
        }
        return Result.error(2, "error");
    }

    /**
     * 地址列表
     */

    @RequestMapping(value = "/addressList",produces={"application/json; charset=UTF-8"})
    public Result addressList(int aid){
        List<UserAddress> userAddresses = userAddressService.addressList(aid);
        return Result.success(1,"SUCCESS",userAddresses);
    }

    @Autowired
    private UserFegin userFegin;
    @RequestMapping("register")
    public Result register(User user){
        System.out.println(user.getUserName());
        Result registe = userFegin.registe(user);
        return registe;
    }
}
