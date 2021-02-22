package com.example.demo.pojo;

import com.example.demo.common.Enum.UserTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
public class User {
    private Integer userId;

    private String name;

    private String email;

    private String telephone;

    private List<Repository> repositories = new ArrayList<>();

    private UserTypeEnum userTypeEnum;

    private boolean isAdmin = false;

    private String password;

    public User(Integer userId, String name, String email, String telephone, UserTypeEnum userTypeEnum, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.userTypeEnum = userTypeEnum;
        this.password = password;
    }

    public void addRepository(List<Repository> repositories) {
        this.repositories = repositories;
    }
}
