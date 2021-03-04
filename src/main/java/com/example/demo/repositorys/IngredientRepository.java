package com.example.demo.repositorys;

import com.example.demo.model.Ingredient;
import com.example.demo.model.upk.IngredientUPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, IngredientUPK> {
    List<Ingredient> findIngredientsByProductId(Long productId);

    @Transactional
    @Modifying
    @Query(value = "insert into ingredient(productId, materialId)" +
            " values(:#{#ingredient.productId},:#{#ingredient.materialId})",
            nativeQuery = true)
    void insert(@Param("ingredient") Ingredient ingredient);
}
