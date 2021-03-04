package com.example.demo.VO.request;

import com.example.demo.common.Verification;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class StoreInfoRequestVO extends Verification {
    private String name;

    private Long size;

    private String address;

    @Override
    public Boolean checkArguments() {
        return null;
    }
}
