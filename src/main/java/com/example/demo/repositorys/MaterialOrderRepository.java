package com.example.demo.repositorys;

import com.example.demo.model.MaterialOrder;
import com.example.demo.model.upk.MaterialOrderUPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MaterialOrderRepository extends JpaRepository<MaterialOrder, MaterialOrderUPK> {
    List<MaterialOrder> findMaterialOrdersByOrderId(Long orderId);

    @Transactional
    @Modifying
    @Query(value = "insert into material_order(orderId, materialId)" +
            " values(:#{#materialOrder.orderId},:#{#materialOrder.materialId})",
            nativeQuery = true)
    void insert(@Param("materialOrder") MaterialOrder materialOrder);
}
