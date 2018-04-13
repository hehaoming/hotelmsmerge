package com.hotelms.service.Impl;

import com.hotelms.bean.UserBean;
import com.hotelms.dao.UserMapper;
import com.hotelms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;
    @Override
    public boolean isValidUser(UserBean user) {

        return userMapper.findUserByUserNameAndPassword(user) != null;
    }
}
