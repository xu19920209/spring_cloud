package com.tuyue.appModel.userCenter;

import com.alibaba.fastjson.JSON;
import com.tuyue.commonBean.User;
import com.tuyue.commonBean.UserAddress;
import com.tuyue.fegin.user.UserFegin;
import com.tuyue.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.security.validator.Validator;

import javax.xml.transform.Source;
import java.util.List;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/4/11.
 */
@RestController
@RequestMapping("user")
public class Usercontroller {
    @Autowired
    private UserFegin userFegin;

    @RequestMapping(value = "register", produces = {"application/json; charset=UTF-8"})
    public Result register(User user) {
          if(user.getPhone()==null){
              return Result.error(2,"参数不能为空");
          }
        if(user.getFlag()==null){
            user.setFlag(1);
        }
        if(null==user.getUserName()){
            user.setUserName(user.getPhone().substring(0,4)+"****"+user.getPhone().substring(user.getPhone().length()-3,user.getPhone().length()));
        }
        user.setSource(2);
        Result registe = userFegin.registe(user);
        return registe;
    }


    @RequestMapping(value = "login",produces = {"application/json; charset=utf-8"})
    public Result login(User user){
        return userFegin.login(user);
    }

    @RequestMapping(value = "/upUser",produces = {"application/json; charset=utf-8"})
    public Result upuser(User user){
        return userFegin.upuser(user);
    }


    @RequestMapping(value = "/selectById",produces = {"application/json; charset=utf-8"})
    public Result selectById( Integer aid){
        return userFegin.selectById(aid);
    }
    //*****************************用户地址模块********************************************************
    @RequestMapping(value = "/inUserAddress",produces = {"application/json; charset=utf-8"})
    public Result inUserAddress(@RequestBody UserAddress userAddress) {
        return  userFegin.inUserAddress(userAddress);

    }
    @RequestMapping(value = "/upUserAddress",produces = {"application/json; charset=utf-8"})
    public Result upUserAddress(@RequestBody UserAddress userAddress) {
        return userFegin.upUserAddress(userAddress);

    }
    @RequestMapping(value = "/delUserAddress",produces = {"application/json; charset=utf-8"})
    public Result delUserAddress(int addressId) {
        return userFegin.delUserAddress(addressId);

    }
    @RequestMapping(value = "/userAddressList",produces = {"application/json; charset=utf-8"})
    public Result userAddressList(int aid){
        System.out.println(aid);
        return  userFegin.userAddressList(aid);
    }
    @RequestMapping(value = "addressById",produces ={"application/json; charset=utf-8"} )
    public Result selectById(int addressId){
        return userFegin.addressById(addressId);
    }
}
