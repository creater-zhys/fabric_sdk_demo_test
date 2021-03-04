package com.example.demo.service;

import com.example.demo.common.Enum.UserTypeEnum;
import com.example.demo.common.response.ServerResponse;
import com.example.demo.model.User;

public interface UserService {

    // 登陆
    ServerResponse<User> login(String name, String password);

    // 登出
    ServerResponse<String> logout(String name);

    //注册
    ServerResponse<String> register(String name, String telephone, String email, UserTypeEnum userTypeEnum, String password);

    //修改密码
    ServerResponse changePassword(String oldPassword, String nowPassword, User user);
}
