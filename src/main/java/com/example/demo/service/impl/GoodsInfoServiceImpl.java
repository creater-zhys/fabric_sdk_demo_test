package com.example.demo.service.impl;

import com.example.demo.VO.response.ProductResponseVO;
import com.example.demo.model.Material;
import com.example.demo.model.Product;
import com.example.demo.repositorys.MaterialRepository;
import com.example.demo.repositorys.ProductRepository;
import com.example.demo.service.GoodsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.GeneratedValue;

@Service("GoodsInfoService")
public class GoodsInfoServiceImpl implements GoodsInfoService {
    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Material queryMaterialById(Long id) {
        return materialRepository.findMaterialById(id);
    }

    @Override
    public Product queryProductById(Long id) {
        return productRepository.findProductById(id);
    }
}
