package com.example.demo.service.impl;

import com.example.demo.model.Product;
import com.example.demo.service.IngredientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProduceService")
public class IngredientServiceImpl implements IngredientService {

    @Override
    public Product addIngredient(List<Long> materialIdList, Long productId) {
        return null;
    }
}
