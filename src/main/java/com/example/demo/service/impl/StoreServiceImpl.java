package com.example.demo.service.impl;

import com.example.demo.VO.response.MaterialInventoryResponseVO;
import com.example.demo.VO.response.ProductInventoryResponseVO;
import com.example.demo.model.*;
import com.example.demo.repositorys.*;
import com.example.demo.service.StoreService;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("StoreService")
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    private final MaterialRepository materialRepository;

    private final ProductRepository productRepository;

    private final ProductInventoryRepository productInventoryRepository;

    private final MaterialInventoryRepository materialInventoryRepository;

    public StoreServiceImpl(StoreRepository storeRepository, MaterialRepository materialRepository, ProductRepository productRepository, ProductInventoryRepository productInventoryRepository, MaterialInventoryRepository materialInventoryRepository) {
        this.storeRepository = storeRepository;
        this.materialRepository = materialRepository;
        this.productRepository = productRepository;
        this.productInventoryRepository = productInventoryRepository;
        this.materialInventoryRepository = materialInventoryRepository;
    }

    @Override
    public void addMaterials(List<Material> materials, Long storeId) {
        for (Material material : materials) {
            materialRepository.insert(material);
            materialInventoryRepository.insert(new MaterialInventory(storeId, material.getId()));
        }
    }

    @Override
    public void addProducts(List<Product> products, Long storeId) {
        for (Product product : products) {
            productRepository.insert(product);
            productInventoryRepository.insert(new ProductInventory(storeId, product.getId()));
        }

    }

    @Override
    public void addProductIds(List<Long> productIds, Long storeId) {
        for (Long productId : productIds) {
            productInventoryRepository.insert(new ProductInventory(storeId, productId));
        }
    }

    @Override
    public void addMaterialIds(List<Long> materialIds, Long storeId) {
        for (Long materialId : materialIds) {
            materialInventoryRepository.insert(new MaterialInventory(storeId, materialId));
        }
    }

    @Override
    public void updateMaterials(List<Long> materialIds, Long storeId) {
        deleteMaterials(materialIds);
        addMaterialIds(materialIds,storeId);
    }

    @Override
    public void updateProducts(List<Long> productIds, Long storeId) {
        deleteProducts(productIds);
        addProductIds(productIds, storeId);
    }

    @Override
    public void deleteMaterials(List<Long> materialIds) {
        for (Long materialId : materialIds) {
            deleteMaterial(materialId);
        }
    }

    @Override
    public void deleteProducts(List<Long> productIds) {
        for (Long productId : productIds) {
            deleteProduct(productId);
        }
    }

    @Override
    public void deleteMaterial(Long materialId) {
        materialRepository.deleteByMaterialId(materialId);
        materialInventoryRepository.deleteByMaterialId(materialId);
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
        productInventoryRepository.deleteByProductId(productId);
    }

    @Override
    public List<Long> queryMaterialsIdByStoreId(Long storeId) {
        return materialInventoryRepository.findMaterialIdByStoreId(storeId);
    }

    @Override
    public List<Long> queryProductsIdByStoreId(Long storeId) {
        return productInventoryRepository.findProductIdByStoreId(storeId);
    }

//    @Override
//    public Map<Long, List<Material>> queryMaterialInventoryByOwner(String owner) {
//        return null;
//    }
//
//    @Override
//    public Map<Long, List<Product>> queryProductInventoryByOwner(String owner) {
//        List<Store> storeList =  queryStoresByOwner(owner);
//        Map<Long, List<Product>> productListMap = new HashMap<>();
//        for (Store store : storeList) {
//            List<Product> products = new ArrayList<>();
//            queryProductsIdByStoreId(store.getId());
//        }
//        return null;
//    }

    @Override
    public String queryOwnerOfStore(Long storeId) {
        return storeRepository.findNameById(storeId);
    }

    @Override
    public List<Store> queryStoresByOwner(String owner) {
        return storeRepository.findAllByOwner(owner);
    }

    @Override
    public Store addNewStore(String name, String address, String ownerId) {
        Store store = new Store();
        store.setName(name);
        store.setAddress(address);
        store.setOwner(ownerId);
        storeRepository.insert(store);

        return storeRepository.findByName(name);
    }

    @Override
    public Long queryStoreIdByProductId(Long productId) {
        return productInventoryRepository.findStoreIdByProductId(productId);
    }

    @Override
    public Long queryStoreIdByMaterialId(Long materialId) {
        return materialInventoryRepository.findStoreIdByMaterialId(materialId);
    }

}
