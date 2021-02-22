package com.example.demo.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
public class Order {
    private Integer orderId;

    private Integer buyerId;

    private Integer sellerId;

    private List<Material> materialList = new ArrayList<>();

    private List<Goods> goodsList = new ArrayList<>();

    private List<Logistics> logisticsList = new ArrayList<>();

    public Order(Integer orderId, Integer buyerId, Integer sellerId, List<Material> materialList, List<Goods> goodsList) {
        this.orderId = orderId;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.materialList = materialList;
        this.goodsList = goodsList;
    }

    public void addLogistics(List<Logistics> logisticsList) {
        this.logisticsList = logisticsList;
    }
}
