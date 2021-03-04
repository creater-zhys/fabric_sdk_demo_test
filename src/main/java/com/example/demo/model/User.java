package com.example.demo.model;

import com.example.demo.common.Enum.UserTypeEnum;
import lombok.*;

import javax.persistence.*;

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

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "text")
    private UserTypeEnum userTypeEnum;

    private boolean isAdmin = false;

    private String password;
}
