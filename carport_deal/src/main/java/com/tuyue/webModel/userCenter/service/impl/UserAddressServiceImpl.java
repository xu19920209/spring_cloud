package com.tuyue.webModel.userCenter.service.impl;

import com.tuyue.entity.UserAddress;
import com.tuyue.mapper.UserAddressMapper;
import com.tuyue.webModel.userCenter.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/4/9.
 */
@Service
public class UserAddressServiceImpl implements UserAddressService {
    @Autowired
    private UserAddressMapper userAddressMapper;
    @Override
    public int inAddress(UserAddress userAddress) {
        /**
         * 当新添加的地址是默认地址时，将之前为默认地址改为非默认
         */
        if(userAddress.getIsDefault()==1){
            int i = userAddressMapper.upAddressDefaultAll(userAddress.getAid());
            if(i<=0){
                return -1;
            }
        }
        Integer insert = userAddressMapper.insert(userAddress);
        return insert;
    }

    @Override
    public int upAddress(UserAddress userAddress) {
        if(userAddress.getIsDefault()==1){
            int i = userAddressMapper.upAddressDefaultAll(userAddress.getAid());
            if(i<=0){
                return -1;
            }
        }
        Integer updateById = userAddressMapper.updateById(userAddress);
        return updateById;
    }

    @Override
    public int delAddress(int addressId) {
        UserAddress userAddress =new UserAddress();
        userAddress.setAddressId(addressId);
        userAddress.setIsDelete(1);
        Integer updateById = userAddressMapper.updateById(userAddress);
        return updateById;
    }

    @Override
    public List<UserAddress> addressList(int aid) {
        return userAddressMapper.userAdderssList(aid);
    }
}
