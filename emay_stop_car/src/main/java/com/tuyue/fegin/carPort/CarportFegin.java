package com.tuyue.fegin.carPort;
import com.tuyue.fegin.bean.ParamSearch;
import com.tuyue.util.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/4/18.
 */
@FeignClient(value = "CARPORT-DEAL",fallback = CarportHystric.class)
public interface CarportFegin {
    @RequestMapping(value = "carport/BCarportOut/selectCarport")
    public Result selectCarport(ParamSearch paramSearch);

    @RequestMapping(value = "carport/BCarportOut/carPortDetils")
    public Result carPortDetils(@RequestParam("bid") Integer bid, @RequestParam("aid")Integer aid, @RequestParam("IP")String IP);
}
