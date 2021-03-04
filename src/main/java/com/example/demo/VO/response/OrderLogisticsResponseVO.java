package com.example.demo.VO.response;

import com.example.demo.model.Logistics;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class OrderLogisticsResponseVO {
    List<Logistics> logisticsList;
}
