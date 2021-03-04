package com.example.demo.VO;

import com.example.demo.common.Verification;
import com.example.demo.model.Material;
import com.example.demo.model.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class LogisticsVO extends Verification {
    private Long logisticsId;

    private List<Long> materialIdList;

    private List<Long> productIdList;

    private String departure;

    private String destination;

    private Long orderId;

    @Override
    public Boolean checkArguments() {
        return null;
    }
}
