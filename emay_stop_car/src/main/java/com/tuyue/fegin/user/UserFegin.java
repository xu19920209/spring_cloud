package com.tuyue.fegin.user;

import com.tuyue.commonBean.User;
import com.tuyue.commonBean.UserAddress;
import com.tuyue.util.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/3/7.
 */
@Component
@FeignClient(value = "common",fallback =UserHystric.class)
public interface UserFegin {
    @RequestMapping(value = "user/register")
    public Result registe(User user);

    @RequestMapping(value = "user/selectById")
    public Result selectById(@RequestParam("id") Integer id);

    @RequestMapping(value = "user/login")
    public Result login( User user);

    @RequestMapping(value = "user/upuser")
    public Result upuser(@RequestBody User user);

    //*****************************用户地址模块****************************************

    @RequestMapping(value = "user/inUserAddress")
    public Result inUserAddress(@RequestBody UserAddress userAddress);

    @RequestMapping(value = "user/upUserAddress")
    public Result upUserAddress(@RequestBody UserAddress userAddress);

    @RequestMapping(value = "user/delUserAdddress")
    public Result delUserAddress(@RequestParam("addressId")int addressId);

    @RequestMapping(value = "user/userAddressList")
    public Result userAddressList(@RequestParam("aid") int aid);

    @RequestMapping("user/addressById")
    public Result addressById(@RequestParam("addressId")int addressId);
}