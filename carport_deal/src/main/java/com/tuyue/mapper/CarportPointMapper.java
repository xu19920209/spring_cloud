package com.tuyue.mapper;

import com.tuyue.entity.CarportPoint;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 车位点击次数 Mapper 接口
 * </p>
 *
 * @author xukangkai123
 * @since 2018-03-19
 */
@Repository
public interface CarportPointMapper extends BaseMapper<CarportPoint> {

    public Integer selectPointNumSumByBid(int bid);

    public CarportPoint selectByAidAndIp(Integer aid,String ip);
}
