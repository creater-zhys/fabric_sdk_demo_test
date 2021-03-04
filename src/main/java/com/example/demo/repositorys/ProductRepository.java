package com.example.demo.repositorys;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findProductById(Long id);

    List<Product> findProductsByOwner(String name);

    @Transactional
    @Modifying
    @Query(value = "insert into product(id, manufacturer, owner, price)" +
            " values(null,:#{#product.manufacturer},:#{#product.owner},:#{#product.price})",
            nativeQuery = true)
    void insert(@Param("product") Product product);
}
