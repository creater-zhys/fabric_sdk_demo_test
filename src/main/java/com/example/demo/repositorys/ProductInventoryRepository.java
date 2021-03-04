package com.example.demo.repositorys;

import com.example.demo.model.ProductInventory;
import com.example.demo.model.upk.ProductInventoryUPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProductInventoryRepository extends JpaRepository<ProductInventory, ProductInventoryUPK> {
    List<ProductInventory> findProductInventoriesByStoreId(Long storeId);

    Long findStoreIdByProductId(Long productId);

    List<Long> findProductIdByStoreId(Long storeId);

    void deleteByProductId(Long productId);

    @Transactional
    @Modifying
    @Query(value = "insert into product_inventory(storeId, productId)" +
            " values(:#{#productInventory.storeId},:#{#productInventory.productId})",
            nativeQuery = true)
    void insert(@Param("productInventory") ProductInventory productInventory);
}
