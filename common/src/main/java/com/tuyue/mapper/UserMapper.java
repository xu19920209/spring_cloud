package com.tuyue.mapper;

import com.tuyue.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

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
public interface UserMapper extends BaseMapper<User> {
    /**
     * @param phone
     * @return
     */
    public User selectByPhone(String phone);

    /**
     *
     * @param id
     * @return
     */
    public User selectById(int id);
}
