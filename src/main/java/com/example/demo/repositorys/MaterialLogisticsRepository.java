package com.example.demo.repositorys;

import com.example.demo.model.MaterialLogistics;
import com.example.demo.model.upk.MaterialLogisticsUPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MaterialLogisticsRepository extends JpaRepository<MaterialLogistics, MaterialLogisticsUPK> {
    List<MaterialLogistics> findMaterialLogisticsByLogisticsId(Long logisticsId);

    @Transactional
    @Modifying
    @Query(value = "insert into material_logistics(logisticsId, materialId)" +
            " values(:#{#materialLogistics.logisticsId},:#{#materialLogistics.materialId})",
            nativeQuery = true)
    void insert(@Param("materialLogistics") MaterialLogistics materialLogistics);
}
