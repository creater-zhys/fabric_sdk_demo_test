package com.example.demo.VO;

import com.example.demo.common.Verification;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class UserVO extends Verification {
    private String name;

    private String password;

    @Override
    public Boolean checkArguments() {
        if (name == null || password == null) {
            return false;
        }
        return true;
    }
}
