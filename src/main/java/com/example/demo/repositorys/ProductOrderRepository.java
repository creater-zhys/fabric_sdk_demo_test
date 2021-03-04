package com.example.demo.repositorys;

import com.example.demo.model.ProductOrder;
import com.example.demo.model.upk.ProductOrderUPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, ProductOrderUPK> {
    List<ProductOrder> findProductOrdersByOrderId(Long orderId);

    @Transactional
    @Modifying
    @Query(value = "insert into product_order(orderId, productId)" +
            " values(:#{#productOrder.orderId},:#{#productOrder.productId})",
            nativeQuery = true)
    void insert(@Param("productOrder") ProductOrder productOrder);
}
