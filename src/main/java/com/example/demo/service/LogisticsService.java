package com.example.demo.service;

import com.example.demo.model.Logistics;
import com.example.demo.model.Material;
import com.example.demo.model.Product;

import java.util.List;

public interface LogisticsService {

    // 新增物流
    Logistics createMaterialLogistics(Long logisticsId, List<Long> materialIds, String departure, String destination, Long orderId);

    Logistics createProductLogistics(Long logisticsId, List<Long> productIds, String departure, String destination, Long orderId);

    // 更新物流信息
    Logistics updateCurrentAddress(Long logisticsId, String currentAddress);

    // 根据订单查询物流
    List<Logistics> queryLogisticsIdByOrderId(Long orderId);


//    LogisticsVO queryLogisticById(Long logisticsId);
}
