package com.tuyue.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.tuyue.entity.ReviewBack;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tuyue.webModel.carport.bean.ReviewBacCountkBean;
import javafx.scene.control.Pagination;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Yanghu123
 * @since 2018-03-09
 */
@Repository
public interface ReviewBackMapper extends BaseMapper<ReviewBack> {
    /**
     * 查询该用户今天是否评论过了
     * @param bid
     * @param ip
     * @return
     */
    public ReviewBack selectByBidAndIp(Integer bid,String ip);

    List<ReviewBack> selectListbyBid(Page page, @Param("bid") Integer bid, @Param("reviewType") Integer reviewType);

    /**
     * 根据bid查询用户对该车位发布的所有车位的评论数量
     * @param bid
     * @return
     */
    public List<ReviewBacCountkBean> selectByBidGroupType(Integer bid);

    /**
     * 根据bid查询用户对该车位发布的所有车位的评论数量
     * @param bid
     * @return
     */
    public List<ReviewBack> selectByBidGroupTypelist(Integer bid);

}
