package com.example.demo.repositorys;

import com.example.demo.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    List<Store> findAllByOwner(String owner);

    Store findByName(String name);

    String findNameById(Long storeId);

    @Transactional
    @Modifying
    @Query(value = "insert into store(id, address, owner, name, size)" +
            " values(:#{#store.id},:#{#store.address},:#{#store.owner},:#{#store.name},:#{#store.size})",
            nativeQuery = true)
    void insert(@Param("store") Store store);
}
