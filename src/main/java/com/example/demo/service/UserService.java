package com.example.demo.service;

import com.example.demo.common.response.ServerResponse;
import com.example.demo.pojo.User;

public interface UserService {
    ServerResponse<User> login(String userName, String password);

    ServerResponse<String> logout(String userName);

    ServerResponse<String> register(String name, String password);

    ServerResponse changePassword(String oldPassword, String nowPassword, User user);
}
