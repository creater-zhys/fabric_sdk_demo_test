package com.example.demo.service;

import com.example.demo.VO.response.MaterialInventoryResponseVO;
import com.example.demo.VO.response.ProductInventoryResponseVO;
import com.example.demo.model.Material;
import com.example.demo.model.Product;
import com.example.demo.model.Store;

import java.util.List;
import java.util.Map;

public interface StoreService {

    //---------------* 库存相关 *----------//

    // 新增库存
    void addMaterials(List<Material> materials, Long storeId);

    void addProducts(List<Product> products, Long storeId);

    void addProductIds(List<Long> productIds, Long storeId);

    void addMaterialIds(List<Long> materialIds, Long storeId);

    // 更新库存
    // add Materials and store
    void updateMaterials(List<Long> materialIds, Long storeId);

    // add products and store
    void updateProducts(List<Long> productIds, Long storeId);

    // 出库
    void deleteMaterials(List<Long> materialIds);

    void deleteProducts(List<Long> productIds);


    // 出库
    void deleteMaterial(Long materialId);

    void deleteProduct(Long productId);

    // 根据仓库id查询仓库库存
    List<Long> queryMaterialsIdByStoreId(Long storeId);

    List<Long> queryProductsIdByStoreId(Long storeId);

//    // 根据用户查询库存查询
//    Map<Long, List<Material>> queryMaterialInventoryByOwner(String owner);
//
//    Map<Long, List<Product>> queryProductInventoryByOwner(String owner);

    // 根据产品信息查询仓库id
    Long queryStoreIdByProductId(Long productId);

    Long queryStoreIdByMaterialId(Long materialId);

    //---------------* 仓库相关 *----------//

    // 查询仓库所有者
    String queryOwnerOfStore(Long storeId);

    // 根据仓库所有者查询仓库Id列表
    List<Store> queryStoresByOwner(String owner);

    // 新建仓库
    Store addNewStore(String name, String address, String ownerId);
}
