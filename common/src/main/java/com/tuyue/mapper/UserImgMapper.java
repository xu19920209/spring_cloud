package com.tuyue.mapper;

import com.tuyue.entity.UserImg;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 用户图片表 Mapper 接口
 * </p>
 *
 * @author Yanghu123
 * @since 2018-03-07
 */
public interface UserImgMapper extends BaseMapper<UserImg> {

       public List<UserImg> selectByAid(Integer aid);
}
