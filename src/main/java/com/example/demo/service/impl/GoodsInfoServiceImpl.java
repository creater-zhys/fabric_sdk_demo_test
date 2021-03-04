package com.example.demo.service.impl;

import com.example.demo.model.Material;
import com.example.demo.model.Product;
import com.example.demo.service.GoodsInfoService;
import org.springframework.stereotype.Service;

import javax.persistence.GeneratedValue;

@Service("GoodsInfoService")
public class GoodsInfoServiceImpl implements GoodsInfoService {
    @Override
    public Material queryMaterialById(Long id) {
        return null;
    }

    @Override
    public Product queryProductById(Long id) {
        return null;
    }
}
