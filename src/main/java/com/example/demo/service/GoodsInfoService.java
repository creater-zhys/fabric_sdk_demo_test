package com.example.demo.service;

import com.example.demo.model.Material;
import com.example.demo.model.Product;

public interface GoodsInfoService {

    Material queryMaterialById(Long id);

    Product queryProductById(Long id);
}
