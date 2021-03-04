package com.example.demo.service;

import com.example.demo.model.Order;

import java.util.List;

public interface OrderService {

    // 创建订单
    Order createMaterialOrder(String seller, String buyer, List<Long> materialIds, String destination);

    Order createProductOrder(String seller, String buyer, List<Long> productIds, String destination);

    // 根据订单查询成品id
    List<Long> queryProductsIdByOrderId(Long orderId);

    // 根据订单查询原材料id
    List<Long> queryMaterialsIdByOrderId(Long orderId);

    // 根据订单id查询订单信息
    Order queryOrderInfoByOrderId(Long orderId);

    // 根据用户查询订单信息
    List<Order> queryOrderByBuyer(String buyer);

    List<Order> queryOrderBySeller(String seller);
}
