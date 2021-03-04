package com.example.demo.service.impl;

import com.example.demo.common.Enum.OrderTypeEnum;
import com.example.demo.model.Material;
import com.example.demo.model.MaterialOrder;
import com.example.demo.model.Order;
import com.example.demo.model.ProductOrder;
import com.example.demo.repositorys.MaterialOrderRepository;
import com.example.demo.repositorys.OrderRepository;
import com.example.demo.repositorys.ProductOrderRepository;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final ProductOrderRepository productOrderRepository;

    private final MaterialOrderRepository materialOrderRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ProductOrderRepository productOrderRepository, MaterialOrderRepository materialOrderRepository) {
        this.orderRepository = orderRepository;
        this.productOrderRepository = productOrderRepository;
        this.materialOrderRepository = materialOrderRepository;
    }

    @Override
    public Order createMaterialOrder(String seller, String buyer, List<Long> materialIds, String destination) {
        Order orderReturn = insertOrder(seller, buyer, destination);
        for (Long materialId : materialIds) {
            materialOrderRepository.insert(new MaterialOrder(orderReturn.getId(), materialId));
        }
        return orderReturn;
    }

    @Override
    public Order createProductOrder(String seller, String buyer, List<Long> productIds, String destination) {
        Order orderReturn = insertOrder(seller, buyer, destination);
        for (Long productId : productIds) {
            productOrderRepository.insert(new ProductOrder(orderReturn.getId(), productId));
        }
        return null;
    }

    @Override
    public List<Long> queryProductsIdByOrderId(Long orderId) {
        return null;
    }

    @Override
    public List<Long> queryMaterialsIdByOrderId(Long orderId) {
        return null;
    }

    @Override
    public Order queryOrderInfoByOrderId(Long orderId) {
        return null;
    }

    @Override
    public List<Order> queryOrderByBuyer(String buyer) {
        return null;
    }

    @Override
    public List<Order> queryOrderBySeller(String seller) {
        return null;
    }

    private Order insertOrder(String seller, String buyer, String destination) {
        Order order = new Order();
        order.setBuyer(buyer);
        order.setDate(new Date());
        order.setDestination(destination);
        order.setSeller(seller);
        order.setOrderTypeEnum(OrderTypeEnum.MATERIAL);
        return orderRepository.insert(order);
    }
}
