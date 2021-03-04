package com.example.demo.repositorys;

import com.example.demo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findOrderById(Long id);

    List<Order> findOrdersByBuyer(String buyer);

    List<Order> findOrdersBySeller(String seller);

    @Transactional
    @Modifying
    @Query(value = "insert into order(id, buyer, seller)" +
            " values(null,:#{#order.buyer},:#{#order.seller})",
            nativeQuery = true)
    Order insert(@Param("order") Order order);

}
