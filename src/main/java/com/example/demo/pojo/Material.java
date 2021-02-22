package com.example.demo.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Material {
    private Integer materialId;

    private Integer price;

    public Material(Integer materialId, Integer price) {
        this.materialId = materialId;
        this.price = price;
    }
}
