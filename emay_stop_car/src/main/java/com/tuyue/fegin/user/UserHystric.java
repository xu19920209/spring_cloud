package com.tuyue.fegin.user;


import com.tuyue.commonBean.User;
import com.tuyue.commonBean.UserAddress;
import com.tuyue.util.Result;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/3/7.
 */
@Component
public class UserHystric implements UserFegin {
    @Override
    public Result registe(User user){
        return  Result.error(2,"用户服务挂了");
    }

    @Override
    public Result selectById(Integer id) {
        return  Result.error(2,"用户服务挂了");
    }
    @Override
    public Result login(User user) {
        return  Result.error(2,"用户服务挂了");
    }

    @Override
    public Result upuser(User user) {
        return  Result.error(2,"用户服务挂了");
    }

    @Override
    public Result inUserAddress(UserAddress userAddress) {
        return  Result.error(2,"用户服务挂了");
    }

    @Override
    public Result upUserAddress(UserAddress userAddress) {
        return  Result.error(2,"用户服务挂了");
    }

    @Override
    public Result delUserAddress(int addressId) {
        return  Result.error(2,"用户服务挂了");
    }

    @Override
    public Result userAddressList(int aid) {
        return  Result.error(2,"用户服务挂了");
    }
  @Override
    public Result addressById(int addressId){
        return  Result.error(2,"用户服务挂了");
    }
}
