package com.example.demo.service.impl;

import com.example.demo.model.Ingredient;
import com.example.demo.model.Product;
import com.example.demo.repositorys.IngredientRepository;
import com.example.demo.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProduceService")
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public void addIngredient(List<Long> materialIdList, Long productId) {
        for (Long materialId : materialIdList) {
            ingredientRepository.insert(new Ingredient(productId, materialId));
        }
    }
}
