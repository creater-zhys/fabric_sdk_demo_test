package com.example.demo.VO.response;

import com.example.demo.VO.LogisticsVO;
import com.example.demo.common.Verification;
import com.example.demo.model.Order;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class OrderResponseVO {
    private Order order;

}
