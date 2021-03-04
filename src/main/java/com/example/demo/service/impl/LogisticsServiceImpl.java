package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repositorys.LogisticsRepository;
import com.example.demo.repositorys.MaterialLogisticsRepository;
import com.example.demo.repositorys.ProductLogisticsRepository;
import com.example.demo.service.LogisticsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("LogisticsService")
public class LogisticsServiceImpl implements LogisticsService {

    private final LogisticsRepository logisticsRepository;

    private final MaterialLogisticsRepository materialLogisticsRepository;

    private final ProductLogisticsRepository productLogisticsRepository;

    public LogisticsServiceImpl(LogisticsRepository logisticsRepository, MaterialLogisticsRepository materialLogisticsRepository, ProductLogisticsRepository productLogisticsRepository) {
        this.logisticsRepository = logisticsRepository;
        this.materialLogisticsRepository = materialLogisticsRepository;
        this.productLogisticsRepository = productLogisticsRepository;
    }


    // 新增物流信息表，新增物流原材料表，，
    @Override
    public Logistics createMaterialLogistics(Long logisticsId, List<Long> materialIds, String departure, String destination, Long orderId) {
        Logistics logistics = insertLogistics(logisticsId, departure,destination,orderId);

        for (Long materialId : materialIds) {
            MaterialLogistics materialLogistics = new MaterialLogistics(logisticsId, materialId);
            materialLogisticsRepository.insert(materialLogistics);
        }

        return logistics;
    }

    // 新增物流信息表， 新增成品物流表
    @Override
    public Logistics createProductLogistics(Long logisticsId, List<Long> productIds, String departure, String destination, Long orderId) {
        Logistics logistics = insertLogistics(logisticsId, departure,destination,orderId);

        for (Long productId : productIds) {
            ProductLogistics productLogistics = new ProductLogistics(logisticsId, productId);
            productLogisticsRepository.insert(productLogistics);
        }

        return logistics;
    }

    // 修改物流信息表
    @Override
    public Logistics updateCurrentAddress(Long logisticsId, String currentAddress) {
        return null;
    }

    @Override
    public List<Logistics> queryLogisticsIdByOrderId(Long orderId) {
        return null;
    }

//    @Override
//    public LogisticsVO queryLogisticById(Long logisticsId) {
//        return null;
//    }

    private Logistics insertLogistics(Long logisticsId, String departure, String destination, Long orderId){
        Logistics logistics = new Logistics();
        logistics.setId(logisticsId);
        logistics.setDeparture(departure);
        logistics.setDestination(destination);
        logistics.setCurrentAddress(departure);
        logistics.setOrderId(orderId);
        logisticsRepository.insert(logistics);
        return logistics;
    }
}
