package com.hotelms.dao;

import com.hotelms.bean.UserBean;

public interface UserMapper {
    UserBean findUserByUserNameAndPassword(UserBean user);
}
