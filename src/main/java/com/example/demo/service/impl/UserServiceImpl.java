package com.example.demo.service.impl;

import com.example.demo.common.Enum.UserTypeEnum;
import com.example.demo.common.response.ServerResponse;
import com.example.demo.model.User;
import com.example.demo.repositorys.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ServerResponse<User> login(String name, String password) {
        User user = userRepository.findUserByName(name);
        if (user == null) {
            return ServerResponse.createByErrorMessage("user not existed");
        }
        if (!user.getPassword().equals(password)) {
            return ServerResponse.createByErrorMessage("password wrong");
        }
        user.setPassword("");
        return ServerResponse.createBySuccess(user);
    }


    @Override
    public ServerResponse<String> logout(String name) {
        return null;
    }

    @Override
    public ServerResponse<String> register(String name, String telephone, String email, UserTypeEnum userTypeEnum, String password) {
        User user = userRepository.findUserByName(name);
        if (user != null) {
            return ServerResponse.createByErrorMessage("user existed");
        }
        user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setTelephone(telephone);
        user.setUserTypeEnum(userTypeEnum);
        user.setPassword(password);
        try {
            userRepository.insert(user);
        } catch (Exception e) {
            return ServerResponse.createByErrorMessage(e.getMessage());
        }
        user = userRepository.findUserByName(name);
        if (user != null)
            return ServerResponse.createBySuccessMessage("register success");
        return ServerResponse.createByErrorMessage("system error");
    }

    @Override
    public ServerResponse changePassword(String oldPassword, String nowPassword, User user) {
        User real = userRepository.findUserByName(user.getName());
        if (real == null)
            return ServerResponse.createByErrorMessage("user not existed");
        if (!real.getPassword().equals(oldPassword)) {
            return ServerResponse.createByErrorMessage("old password is wrong");
        }
        real.setPassword(nowPassword);
        if (userRepository.changePassword(user.getName(), nowPassword) > 0)
            return ServerResponse.createBySuccess("success");
        return ServerResponse.createByErrorMessage("change password failed");
    }
}
