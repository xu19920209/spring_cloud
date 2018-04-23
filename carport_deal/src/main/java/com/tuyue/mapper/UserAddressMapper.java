package com.tuyue.mapper;

import com.tuyue.entity.UserAddress;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author xukangkai123
 * @since 2018-04-09
 */
@Repository
public interface UserAddressMapper extends BaseMapper<UserAddress> {
    /**
     * 根据aid 将用户的地址全部改为非默认地址
     * @param aid
     * @return
     */
    public int upAddressDefaultAll(@Param("aid") int aid);

    public List<UserAddress> userAdderssList(@Param("aid") int aid);
}
