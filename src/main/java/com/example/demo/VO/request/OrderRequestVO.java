package com.example.demo.VO.request;

import com.example.demo.VO.LogisticsVO;
import com.example.demo.common.Enum.OrderTypeEnum;
import com.example.demo.common.Verification;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.validation.Validator;
import java.util.List;

@ToString
@Setter
@Getter
public class OrderRequestVO extends Verification {
    private Long id;

    private String buyer;

    private String seller;

    private String destination;

    private List<Long> goodsList;

    private OrderTypeEnum orderTypeEnum ;

    @Override
    public Boolean checkArguments() {
        return true;
    }
}
