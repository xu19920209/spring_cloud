package com.tuyue.user.controller;

import com.tuyue.entity.User;
import com.tuyue.entity.UserAddress;
import com.tuyue.user.service.UserService;
import com.tuyue.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 会员信息 前端控制器
 * </p>
 *
 * @author Yanghu123
 * @since 2018-03-06
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register")
    public Result register(@RequestBody User user) {
        if (user.getPhone() == null || user.getPassword() == null || user.getSource() == null) {
            return Result.error(2, "参数有误！");
        }
        int register = userService.register(user);
        if (register > 0) {
            return Result.success(1, "注册成功",user);
        } else if (register == 0) {
            return Result.error(2, "改账号已经存在");
        }
        return Result.error(2, "注册失败");
    }


    @RequestMapping(value = "/login")
    public Result login(@RequestBody User user) {
        User login = userService.login(user);
        if (login != null) {
            return Result.success(1, "登录成功", login);
        } else {
            return Result.success(2, "账号或者密码错误");
        }
    }

    @RequestMapping(value = "/upuser")
    public Result upuser(@RequestBody User user) {
        if(user==null){
            Result.error(2,"参数不能为空");
        }
       return userService.upuser(user);
    }

    @RequestMapping(value = "/selectById")
    public Result selectById(@RequestParam("id") Integer id) {
        User user = userService.selecById(id);
        if (user != null) {
            return Result.success(1, "success", user);
        } else {
            return Result.error(2, "查不到该用户");
        }
    }


    //*****************************用户地址模块********************************************************
    @RequestMapping(value = "/inUserAddress")
    public Result inUserAddress(@RequestBody UserAddress userAddress) {
        Integer integer = userService.inUserAddress(userAddress);
        if (integer > 0) {
            return Result.success(userAddress.getAddressId());
        } else {
            return Result.error();
        }
    }
    @RequestMapping(value = "/upUserAddress")
    public Result upUserAddress(@RequestBody UserAddress userAddress) {
        Integer integer = userService.upUserAddress(userAddress);
        if (integer > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }
    @RequestMapping(value = "/delUserAdddress")
    public Result delUserAdddress(int addressId) {
        Integer integer = userService.delUserAdddress(addressId);
        if (integer > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }
    @RequestMapping(value = "/userAddressList")
    public Result userAddressList(int aid){
        System.out.println("aid"+aid);
        List<UserAddress> userAddresses = userService.userAddressList(aid);
        return Result.success(userAddresses);
    }
    @RequestMapping("/addressById")
    public Result addressById(int addressId){
        System.out.println("1111111111111111111111111111111111111111111111111111");
        UserAddress userAddress = userService.addressById(addressId);
        System.out.println("查出来的值"+userAddress.toString());
        if(userAddress!=null){
            return Result.success(userAddress);
        }
        return Result.error();
    }
}

