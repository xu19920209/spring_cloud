package com.tuyue.webModel.carport.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.tuyue.webModel.carport.bean.CarportBean;
import com.tuyue.webModel.carport.bean.ParamSearch;
import com.tuyue.entity.Carport;
import com.tuyue.util.Result;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/3/9.
 */
public interface CarportService {
    /**
     * 添加车位
     * @param carport
     * @return
     */
    public Result addCarport(CarportBean carport);

    /**
     * 修改车位
     * @param carport
     * @return
     */
    public Result upCarport(CarportBean carport);
    /**
     * 查询车位
     */
    public Result selectCarport(Page<Carport> page,ParamSearch paramSearch) throws IllegalAccessException, InstantiationException;
    /**
     * 车位详情
     */
    public Result carPortDetils(Integer bid,Integer aid,String IP) throws IllegalAccessException, InstantiationException;

    /*
    * @Author: 徐慷慨
    * @Description:车位详情中查询企业信息
    * @Date: 11:58 2018/1/9
    */
    public Result companyDetails(Integer aid) throws Exception;
}
