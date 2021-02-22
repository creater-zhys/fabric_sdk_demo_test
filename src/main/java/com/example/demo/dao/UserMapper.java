package com.example.demo.dao;

import com.example.demo.pojo.User;

public interface UserMapper {
    User selectById(Integer id);

    User selectByName(String name);

    int insert(User user);

    int insertSelective(User user);

    int updateByPrimaryKeySelective(User user);

    int updateByPrimaryKey(User user);
}
