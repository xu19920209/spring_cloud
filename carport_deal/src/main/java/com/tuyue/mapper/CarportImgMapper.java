package com.tuyue.mapper;

import com.tuyue.entity.CarportImg;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Yanghu123
 * @since 2018-03-09
 */
@Repository
public interface CarportImgMapper extends BaseMapper<CarportImg> {
    /**
     * 查询车位首页和福图
     * @param bid
     * @return
     */
     List<CarportImg> selectTypeByBid(Integer bid);
}
