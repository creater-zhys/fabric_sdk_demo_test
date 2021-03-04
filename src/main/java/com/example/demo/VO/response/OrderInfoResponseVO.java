package com.example.demo.VO.response;

import com.example.demo.model.Order;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class OrderInfoResponseVO {
    private Order order;
}
