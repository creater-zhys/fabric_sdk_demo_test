package com.example.demo.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
public class Repository {
    private Integer repositoryId;

    private String name;

    private String address;

    private Integer userId;

    private List<Material> materials = new ArrayList<>();

    private List<Goods> goodsList = new ArrayList<>();

    public Repository(String name, String address, Integer userId) {
        this.name = name;
        this.address = address;
        this.userId = userId;
    }

    public void addMaterial(Material material) {
        materials.add(material);
    }

    public void addGoods(Goods goods) {
        goodsList.add(goods);
    }

    //TODO : 出库
}
