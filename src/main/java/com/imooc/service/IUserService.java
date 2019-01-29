package com.imooc.service;

import com.imooc.entity.User;

public interface IUserService {
    User findUserByName(String userName);
}
