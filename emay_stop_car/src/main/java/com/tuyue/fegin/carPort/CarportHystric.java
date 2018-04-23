package com.tuyue.fegin.carPort;

import com.tuyue.fegin.bean.ParamSearch;
import com.tuyue.util.Result;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/4/18.
 */
@Component
public class CarportHystric implements CarportFegin {
    @Override
    public Result selectCarport(@RequestBody ParamSearch paramSearch) {
        return Result.error(2,"车位服务挂了");
    }

    @Override
    public Result carPortDetils(Integer bid, Integer aid, String IP) {
        return Result.error(2,"车位服务挂了");
    }
}
