package com.tuyue.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.tuyue.webModel.carport.bean.ParamSearch;
import com.tuyue.entity.Carport;
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
public interface CarportMapper extends BaseMapper<Carport> {
    /**
     * 根据条件查询
     * @param page
     * @param paramSearch
     * @return
     */
    public List<Carport> selectCarport(Pagination page, ParamSearch paramSearch);

    public List<Carport> carportAllList(Pagination page);
}
