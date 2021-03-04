package com.example.demo.repositorys;

import com.example.demo.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {
    List<Material> findMaterialsByOwner(String owner);

    Material findMaterialById(Long id);

    @Query("delete from Material m where m.id = :id")
    void deleteByMaterialId(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "insert into material(id, price, owner)" +
            " values(:#{#material.id},:#{#material.price},:#{#material.owner})",
            nativeQuery = true)
    void insert(@Param("material") Material material);
}
