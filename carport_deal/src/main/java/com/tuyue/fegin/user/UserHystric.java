package com.tuyue.fegin.user;


import com.tuyue.commonBean.User;
import com.tuyue.fegin.user.UserFegin;
import com.tuyue.util.Result;
import org.springframework.stereotype.Component;


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
    public User selectById(Integer id) {
        return null;
    }
}
