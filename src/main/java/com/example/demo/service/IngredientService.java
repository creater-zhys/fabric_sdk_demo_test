package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface IngredientService {

    // 生产成品
    Product addIngredient(List<Long> materialIdList, Long productId);
}
