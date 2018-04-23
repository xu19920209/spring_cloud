package com.tuyue.user.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.tuyue.entity.User;
import com.tuyue.entity.UserAddress;
import com.tuyue.mapper.UserAddressMapper;
import com.tuyue.mapper.UserMapper;
import com.tuyue.user.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tuyue.util.JedisUtil;
import com.tuyue.util.MD5Util;
import com.tuyue.util.ProtoStuffSerializerUtil;
import com.tuyue.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * <p>
 * 会员信息 服务实现类
 * </p>
 *
 * @author Yanghu123
 * @since 2018-03-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserAddressMapper userAddressMapper;

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @Override
    public int register(User user) {
        User user1 = userMapper.selectByPhone(user.getPhone());
        if (user1 != null) {
            return 0;
        } else {
            Integer insert = userMapper.insert(user);
            return insert;
        }

    }

    @Override
    public User login(User user) {
        User user1 = null;
        user1 = userMapper.selectByPhone(user.getPhone());
        if (user1 != null) {
            if (user.getPassword().equals(user1.getPassword())) {
                return user1;
            }
            return null;
        }
        return null;
    }

    @Override
    public Result upuser(User user) {
        User user1 = userMapper.selectById(user.getAid());
        if (user1 == null) {
            return Result.error(2,"查不到该用户");
        }
        Integer integer = userMapper.updateById(user);
        if(integer>0){
            return Result.success("修改成功！");
        }
        return Result.error(2,"修改失败！");
    }

    @Override
    public User selecById(int id) {
        User user = userMapper.selectById(id);
        return user;
    }

    //********************用户地址模块************************************************
    @Override
    @Transactional
    public Integer inUserAddress(UserAddress userAddress) {
        if(userAddress.getIsDefault()==null){
            userAddress.setIsDefault(2);
        }
        if(userAddress.getIsDefault()==1){
            UserAddress userAddress1=new UserAddress();
            userAddress1.setAid(userAddress.getAid());
            userAddress1.setIsDefault(1);
            UserAddress userAddress2 = userAddressMapper.selectOne(userAddress1);
            if(userAddress2!=null){
                userAddress2.setIsDefault(2);
                userAddressMapper.updateById(userAddress2);
            }
        }
        Integer insert = userAddressMapper.insert(userAddress);
        return insert;
    }

    @Override
    public Integer upUserAddress(UserAddress userAddress) {
        if(userAddress.getIsDefault()==null){
            userAddress.setIsDefault(2);
        }
        if(userAddress.getIsDefault()==1){
            UserAddress userAddress1=new UserAddress();
            userAddress1.setAid(userAddress.getAid());
            userAddress1.setIsDefault(1);
            UserAddress userAddress2 = userAddressMapper.selectOne(userAddress1);
            if(userAddress2!=null){
                userAddress2.setIsDefault(2);
                userAddressMapper.updateById(userAddress2);
            }
        }
        Integer updateById = userAddressMapper.updateById(userAddress);
        return updateById;
    }

    @Override
    public Integer delUserAdddress(int addressId) {
        Integer integer = userAddressMapper.deleteById(addressId);
        return integer;
    }

    @Override
    public List<UserAddress> userAddressList(int aid) {

        List<UserAddress> userAddresses = userAddressMapper.selectList(new EntityWrapper<UserAddress>().eq("aid", aid).orderBy("is_default"));

        return userAddresses;
    }
    @Override
    public UserAddress addressById(int addressId){
        UserAddress userAddress = userAddressMapper.selectById(addressId);
        return userAddress;
    }

}
