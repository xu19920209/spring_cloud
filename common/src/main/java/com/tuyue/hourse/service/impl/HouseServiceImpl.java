package com.tuyue.hourse.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.tuyue.entity.ComHourses;
import com.tuyue.hourse.service.HouseService;
import com.tuyue.mapper.ComHoursesMapper;
import com.tuyue.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/3/8.
 */
@Service
@Transactional
public class HouseServiceImpl implements HouseService {
 @Autowired
 private ComHoursesMapper comHousesMapper;
    @Override
    public Result addHourse(ComHourses comHouses){
        Integer num = comHousesMapper.selectCount(new EntityWrapper<ComHourses>().eq("hourse_name", comHouses.getHourseName()));
        if(num>0){
            return Result.error(2,"该楼盘已被添加过了");
        }
        Integer insert = comHousesMapper.insert(comHouses);
        if(insert>0){
            //在改楼盘下添加停车场

            return Result.success(1,"SUCCESS");
        }else {
            return Result.error(2,"ERROR");
        }
    }

    @Override
    public Result selectHourse(ComHourses comHouses){
        List<ComHourses> list = comHousesMapper.comHourseList(comHouses);
        System.out.println(":::::"+list.size());
        return Result.success(1,"SUCCESS",list);
    }

    @Override
    public Result delHourse(int id){
        int i = comHousesMapper.delHourse(id);
        if(i>0){
            return  Result.success(1,"SUCCESS");
        }
        return Result.error(2,"ERROR");
    }

    @Override
    public Result upHourse(ComHourses comHouses){
        Integer i = comHousesMapper.updateById(comHouses);
        if(i>0){
            return  Result.success(1,"SUCCESS");
        }
        return Result.error(2,"ERROR");
    }
    @Override
    public Result selectById(Integer id){
        ComHourses comHourses = comHousesMapper.selectById(id);
        if(comHourses!=null){
            return Result.success(1,"SUCCESS",comHourses);
        }else{
            return Result.error(2,"ERROR");
        }
    }
}
