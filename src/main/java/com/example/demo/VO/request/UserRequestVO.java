package com.example.demo.VO.request;

import com.example.demo.common.Enum.UserTypeEnum;
import com.example.demo.common.Verification;
import com.example.demo.model.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class UserRequestVO extends Verification {

    private  String name;

    private  String telephone;

    private String email;

    private String password;

    private UserTypeEnum userTypeEnum;

    private boolean isAdmin = false;

    @Override
    public Boolean checkArguments() {
        if (name == null || email == null || password == null) {
            return false;
        } else if (userTypeEnum == UserTypeEnum.ADMIN || userTypeEnum == UserTypeEnum.DEALER ||
                userTypeEnum == UserTypeEnum.MANUFACTURER || userTypeEnum == UserTypeEnum.SUPPLIER) {
            return true;
        }
        else {
            return false;
        }
    }
}
