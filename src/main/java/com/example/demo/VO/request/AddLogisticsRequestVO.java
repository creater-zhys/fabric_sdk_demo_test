package com.example.demo.VO.request;

import com.example.demo.VO.LogisticsVO;
import com.example.demo.common.Verification;
import com.example.demo.model.Logistics;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Setter
@Getter
public class AddLogisticsRequestVO extends Verification {
    private Long orderId;

    private List<LogisticsVO> logisticsList;

    @Override
    public Boolean checkArguments() {
        return null;
    }
}
