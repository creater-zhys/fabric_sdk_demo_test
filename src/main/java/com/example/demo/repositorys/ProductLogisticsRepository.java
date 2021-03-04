package com.example.demo.repositorys;

import com.example.demo.model.ProductLogistics;
import com.example.demo.model.upk.ProductLogisticsUPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProductLogisticsRepository extends JpaRepository<ProductLogistics, ProductLogisticsUPK> {
    List<ProductLogistics> findProductLogisticsByLogisticsId(Long logisticsId);

    @Transactional
    @Modifying
    @Query(value = "insert into product_logistics(logisticsId, productId)" +
            " values(:#{#productLogistics.logisticsId},:#{#productLogistics.productId})",
            nativeQuery = true)
    void insert(@Param("productLogistics") ProductLogistics productLogistics);
}
