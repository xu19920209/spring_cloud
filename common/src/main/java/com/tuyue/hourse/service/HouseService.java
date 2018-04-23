package com.tuyue.hourse.service;

import com.tuyue.entity.ComHourses;
import com.tuyue.util.Result;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/3/8.
 */
public interface HouseService {

    public Result addHourse(ComHourses comHouses);

    public Result selectHourse(ComHourses comHouses);

    public Result delHourse(int id );

    public Result upHourse(ComHourses comHouses);

    public Result selectById(Integer id);
}
