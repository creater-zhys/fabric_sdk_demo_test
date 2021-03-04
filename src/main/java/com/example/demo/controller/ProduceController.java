package com.example.demo.controller;

import com.example.demo.VO.request.ProduceProductRequestVO;
import com.example.demo.VO.request.ProduceProductsRequestVO;
import com.example.demo.aspect.RequireAuth;
import com.example.demo.common.Const;
import com.example.demo.common.response.ServerResponse;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.service.StoreService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class ProduceController {

    private final StoreService storeService;

    public ProduceController(StoreService storeService) {
        this.storeService = storeService;
    }

    @RequireAuth
    @RequestMapping(value = "product",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> produceProduct(@RequestBody ProduceProductRequestVO produceProductRequestVO,
                                          HttpSession session) {
        ServerResponse<String> response;
        User user = (User) session.getAttribute(Const.CUR_USER);
        try {
            produce(produceProductRequestVO.getMaterialIdList(), produceProductRequestVO.getStoreId(),
                    user.getName(), produceProductRequestVO.getPrice());
            response = ServerResponse.createBySuccess("produce product success");
        } catch (Exception e) {
            response = ServerResponse.createByErrorMessage(e.getMessage());
        }
        return response;
    }

    @RequireAuth
    @RequestMapping(value = "products", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> produceProducts(@RequestBody ProduceProductsRequestVO produceRequestVO,
                                                  HttpSession session) {
        ServerResponse<String> response;
        User user = (User) session.getAttribute(Const.CUR_USER);
        try {
            produceBatch(produceRequestVO.getMaterialIdsList(), produceRequestVO.getStoreId(),
                    user.getName(), produceRequestVO.getPrice());
            response = ServerResponse.createBySuccess("produce products success");
        } catch (Exception e) {
            response = ServerResponse.createByErrorMessage(e.getMessage());
        }
        return response;
    }

    private void produce(List<Long> materials, Long storeId, String manufacturer, Long price){
        List<Product> products = new ArrayList<>();
        Product product = new Product();
        product.setManufacturer(manufacturer);
        product.setOwner(manufacturer);
        product.setPrice(price);
        products.add(product);
        storeService.deleteMaterials(materials);
        storeService.addProducts(products, storeId);
    }

    private void produceBatch(List<List<Long>> materialsList, Long storeId, String manufacturer, Long price) {
        for (List<Long> materials : materialsList) {
            produce(materials, storeId, manufacturer, price);
        }
    }

}
