package com.example.demo.repositorys;

import com.example.demo.model.Logistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface LogisticsRepository extends JpaRepository<Logistics, Long> {
    Logistics findLogisticsById(Long logisticsId);

    List<Logistics> findLogisticsByOrderId(Long orderId);

    @Transactional
    @Modifying
    @Query(value = "insert into logistics(id, departure, destination, currentAddress)" +
            " values(null,:#{#logistics.departure},:#{#logistics.destination}, null)",
            nativeQuery = true)
    void insert(@Param("logistics") Logistics logistics);
}
