package com.example.demo.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Setter
@Getter
public class Goods {
    private Integer goodsId;

    private Integer manufacturer;

    private List<Material> materials = new ArrayList<>();

    public Goods(Integer goodsId, Integer manufacturer, List<Material> materials) {
        this.goodsId = goodsId;
        this.manufacturer = manufacturer;
        this.materials = materials;
    }

}
