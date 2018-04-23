package com.tuyue.mapper;

import com.tuyue.entity.TradingArea;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Yanghu123
 * @since 2018-03-07
 */
@Repository
public interface TradingAreaMapper extends BaseMapper<TradingArea> {
   public List<TradingArea> tradingList(TradingArea tradingArea);

   public TradingArea selectByName(String name);
}
