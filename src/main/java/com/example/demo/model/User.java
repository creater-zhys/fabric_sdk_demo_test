package com.example.demo.model;

import com.example.demo.common.Enum.UserTypeEnum;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    private String name;

    private String email;

    private String telephone;

    private UserTypeEnum userTypeEnum;

    private boolean isAdmin = false;

    private String password;
}
