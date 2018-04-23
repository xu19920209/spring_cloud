package com.tuyue.appModel.carport.controller;

import com.tuyue.fegin.bean.ParamSearch;
import com.tuyue.fegin.carPort.CarportFegin;
import com.tuyue.util.BeanMap;
import com.tuyue.util.GetIp;
import com.tuyue.util.Result;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/4/18.
 */
@RestController
@RequestMapping("carport")
public class CarportController {
    @Autowired
    private CarportFegin carportFegin;
    /**
     * 车位列表
     * @param paramSearch
     * @return
     */
    @RequestMapping(value = "carportList",produces = {"application/json; charset=UTF-8"})
    public Result selectCarport( ParamSearch paramSearch){
        System.out.println("????"+paramSearch.getPageSize());
        Result result = carportFegin.selectCarport(paramSearch);
        return result;
    }

    /**
     * 车位详情
     * @return
     */
    @RequestMapping(value = "carportDetails",produces = {"application/json; charset=UTF-8"})
    public Result carportDetails(Integer bid, Integer aid, HttpServletRequest request) throws Exception {
        String ipAddr = GetIp.getIpAddr(request);
        Result result = carportFegin.carPortDetils(bid, aid, ipAddr);
        return result;
    }
}
