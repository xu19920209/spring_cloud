package com.tuyue.mapper;

import com.tuyue.entity.ComHourses;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * com_houses楼盘表 Mapper 接口
 * </p>
 *
 * @author Yanghu123
 * @since 2018-03-07
 */
@Repository
public interface ComHoursesMapper extends BaseMapper<ComHourses> {
    public List<ComHourses> comHourseList(ComHourses comHouses);

    public int delHourse(int id);

}
