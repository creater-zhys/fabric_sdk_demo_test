package com.example.demo.controller;

import com.example.demo.VO.request.AddMaterialRequestVO;
import com.example.demo.VO.request.AddProductRequestVO;
import com.example.demo.VO.request.StoreInfoRequestVO;
import com.example.demo.VO.response.MaterialInventoryResponseVO;
import com.example.demo.VO.response.ProductInventoryResponseVO;
import com.example.demo.VO.response.StoreInfoResponseVO;
import com.example.demo.VO.response.StoresResponseVO;
import com.example.demo.aspect.RequireAuth;
import com.example.demo.common.Const;
import com.example.demo.common.response.ServerResponse;
import com.example.demo.model.Store;
import com.example.demo.model.User;
import com.example.demo.service.StoreService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/store/")
public class StoreController {
    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @RequireAuth
    @RequestMapping(value = "Inventory/material", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<MaterialInventoryResponseVO> queryMaterialInventoryByStoreId(@RequestParam("storeId") Long storeId, HttpSession session) {
        User user = (User) session.getAttribute(Const.CUR_USER); // TODO：
        ServerResponse<MaterialInventoryResponseVO> response;
        try {
            MaterialInventoryResponseVO materialInventoryResponseVO = new MaterialInventoryResponseVO();
            List<Long> materials =  storeService.queryMaterialsIdByStoreId(storeId);
            materialInventoryResponseVO.setMaterialIds(materials);
            response = ServerResponse.createBySuccess(materialInventoryResponseVO);
        } catch (Exception e) {
            response = ServerResponse.createByErrorMessage(e.getMessage());
        }
        return response;
    }

    @RequireAuth
    @RequestMapping(value = "Inventory/product", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<ProductInventoryResponseVO> queryProductInventoryByStoreId(@RequestParam("storeId") Long storeId, HttpSession session) {
        User user = (User) session.getAttribute(Const.CUR_USER); // TODO：
        ServerResponse<ProductInventoryResponseVO> response;
        try {
            ProductInventoryResponseVO productInventoryResponseVO = new ProductInventoryResponseVO();
            List<Long> products =  storeService.queryProductsIdByStoreId(storeId);
            productInventoryResponseVO.setProductIds(products);
            response = ServerResponse.createBySuccess(productInventoryResponseVO);
        } catch (Exception e) {
            response = ServerResponse.createByErrorMessage(e.getMessage());
        }
        return response;
    }

    @RequireAuth
    @RequestMapping(value = "store", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<StoreInfoResponseVO> addNewStore(@RequestBody StoreInfoRequestVO storeVO, HttpSession session) {
        User user = (User) session.getAttribute(Const.CUR_USER); // TODO：
        ServerResponse<StoreInfoResponseVO> response;
        try {
            Store store =  storeService.addNewStore(storeVO.getId(), storeVO.getName(),
                    storeVO.getAddress(), user.getName(),storeVO.getSize());
            StoreInfoResponseVO storeInfoResponseVO = new StoreInfoResponseVO();
            storeInfoResponseVO.setStore(store);
            response = ServerResponse.createBySuccess(storeInfoResponseVO);
        } catch (Exception e) {
            response = ServerResponse.createByErrorMessage(e.getMessage());
        }
        return response;
    }

    @RequireAuth
    @RequestMapping(value = "stores", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<StoresResponseVO> queryStoresByOwner(HttpSession session) {
        User user = (User) session.getAttribute(Const.CUR_USER); // TODO：
        ServerResponse<StoresResponseVO> response;
        try {
            List<Store> storeList = storeService.queryStoresByOwner(user.getName());
            StoresResponseVO storesResponseVO = new StoresResponseVO();
            storesResponseVO.setStoreList(storeList);
            response = ServerResponse.createBySuccess(storesResponseVO);
        } catch (Exception e) {
            response = ServerResponse.createByErrorMessage(e.getMessage());
        }
        return response;
    }

    @RequireAuth
    @RequestMapping(value = "material", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> addMaterialToStore(@RequestBody AddMaterialRequestVO addMaterialRequestVO, HttpSession session) {
        User user = (User) session.getAttribute(Const.CUR_USER); // TODO：
        ServerResponse<String> response;
        try {
            storeService.addMaterials(addMaterialRequestVO.getMaterialList(), addMaterialRequestVO.getStoreId());
            response = ServerResponse.createBySuccess("add material success");
        } catch (Exception e) {
            response = ServerResponse.createByErrorMessage(e.getMessage());
        }
        return response;
    }

    @RequireAuth
    @RequestMapping(value = "product", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> addProductToStore(@RequestBody AddProductRequestVO addProductRequestVO, HttpSession session) {
        User user = (User) session.getAttribute(Const.CUR_USER); // TODO：
        ServerResponse<String> response;
        try {
            storeService.addProducts(addProductRequestVO.getProductList(), addProductRequestVO.getStoreId());
            response = ServerResponse.createBySuccess("add product success");
        } catch (Exception e) {
            response = ServerResponse.createByErrorMessage(e.getMessage());
        }
        return response;
    }
}
