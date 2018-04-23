package com.tuyue.fegin.hourse;


import com.tuyue.commonBean.ComHourses;
import com.tuyue.util.Result;
import org.springframework.stereotype.Component;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/3/14.
 */
@Component
public class HourHystric implements HourseFegin {
    @Override
    public Result selectHourse(ComHourses comHouses){
        return  Result.error(2,"楼盘查询失败");
    }

    @Override
    public Result selectById(Integer id) {
        return  Result.error(2,"根据id查询楼盘失败");
    }
}
