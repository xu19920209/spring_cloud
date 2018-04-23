package com.tuyue.fegin.hourse;

import com.tuyue.commonBean.ComHourses;
import com.tuyue.fegin.user.UserHystric;
import com.tuyue.util.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/3/14.
 */
@Component
@FeignClient(value = "common",fallback =HourHystric.class)
public interface HourseFegin {

    @RequestMapping(value = "hourse/selectHourse")
    public Result selectHourse(ComHourses comHouses);


    @RequestMapping(value ="hourse/selectById")
    public Result selectById( Integer id);
}
