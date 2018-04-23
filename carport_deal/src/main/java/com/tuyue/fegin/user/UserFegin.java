package com.tuyue.fegin.user;

import com.tuyue.commonBean.User;
import com.tuyue.util.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    @RequestMapping(value = "user/selectById",method = RequestMethod.GET)
    public User selectById(@RequestParam("id") Integer id);
}
