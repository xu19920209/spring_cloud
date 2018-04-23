package com.tuyue.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.tuyue.entity.LeaveWord;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xukangkai123
 * @since 2018-03-21
 */
@Repository
public interface LeaveWordMapper extends BaseMapper<LeaveWord> {

    public List<LeaveWord> selectByBid(Pagination page, Integer bid);

    /**
     * 查询回复留言的
     * @return
     */
    public List<LeaveWord> selectByID(Integer id);

}
