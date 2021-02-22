package com.example.demo.pojo;

import com.example.demo.common.Enum.LogisticsStateEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@ToString
@Setter
@Getter
public class Logistics {
    private Integer logisticsId;

    private String departure;

    private String destination;

    private String currentAddress;

    private List<Material> materials = new ArrayList<>();

    private List<Goods> goodsList = new ArrayList<>();

    private LogisticsStateEnum logisticsStateEnum;

    public Logistics(Integer logisticsId, String departure, String destination, List<Material> materials, List<Goods> goodsList) {
        this.logisticsId = logisticsId;
        this.departure = departure;
        this.destination = destination;
        this.materials = materials;
        this.goodsList = goodsList;
        this.logisticsStateEnum = LogisticsStateEnum.UNKNOWEN;
    }
}
