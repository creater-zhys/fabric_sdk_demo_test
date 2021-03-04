package com.example.demo.repositorys;

import com.example.demo.model.MaterialInventory;
import com.example.demo.model.upk.MaterialInventoryUPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MaterialInventoryRepository extends JpaRepository<MaterialInventory, MaterialInventoryUPK> {
    List<MaterialInventory> findMaterialInventoriesByStoreId(Long storeId);

    Long findStoreIdByMaterialId(Long materialId);

    List<Long> findMaterialIdByStoreId(Long storeId);

    void deleteByMaterialId(Long materialId);

    @Transactional
    @Modifying
    @Query(value = "insert into material_inventory(storeId, materialId)" +
            " values(:#{#materialInventory.storeId},:#{#materialInventory.materialId})",
            nativeQuery = true)
    void insert(@Param("materialInventory") MaterialInventory materialInventory);
}
