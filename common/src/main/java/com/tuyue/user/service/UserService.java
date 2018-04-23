package com.tuyue.user.service;

import com.tuyue.entity.User;
import com.baomidou.mybatisplus.service.IService;
import com.tuyue.entity.UserAddress;
import com.tuyue.util.Result;

import java.util.List;

/**
 * <p>
 * 会员信息 服务类
 * </p>
 *
 * @author Yanghu123
 * @since 2018-03-06
 */
public interface UserService extends IService<User> {

   public int register(User user);
   public User login(User user);
   public Result upuser(User user);
   public User selecById(int id);

   public Integer inUserAddress(UserAddress userAddress);
   public Integer upUserAddress(UserAddress userAddress);
   public Integer delUserAdddress(int addressId);
   public List<UserAddress> userAddressList(int aid);
   public UserAddress addressById(int addressId);

}
