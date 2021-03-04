package com.example.demo.controller;

import com.example.demo.VO.response.MaterialInventoryResponseVO;
import com.example.demo.VO.response.MaterialResponseVO;
import com.example.demo.VO.response.ProductResponseVO;
import com.example.demo.aspect.RequireAuth;
import com.example.demo.common.Const;
import com.example.demo.common.response.ServerResponse;
import com.example.demo.model.Material;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repositorys.MaterialRepository;
import com.example.demo.repositorys.ProductRepository;
import com.example.demo.service.GoodsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/Goods/")
public class GoodsInfoController {
    private final GoodsInfoService goodsInfoService;

    public GoodsInfoController(GoodsInfoService goodsInfoService) {
        this.goodsInfoService = goodsInfoService;
    }

    @RequireAuth
    @RequestMapping(value = "material/", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<MaterialResponseVO> queryMaterialInfoById(@RequestParam("id") Long id, HttpSession session){
        User user = (User) session.getAttribute(Const.CUR_USER); // TODO：
        ServerResponse<MaterialResponseVO> response;
        try {
            Material material = goodsInfoService.queryMaterialById(id);
            if (!material.getOwner().equals(user.getName())) {
                response = ServerResponse.createByErrorMessage("material auth failed");
            }
            MaterialResponseVO materialResponseVO = new MaterialResponseVO();
            materialResponseVO.setMaterial(material);
            response = ServerResponse.createBySuccess(materialResponseVO);
        } catch (Exception e) {
            response = ServerResponse.createByErrorMessage(e.getMessage());
        }
        return response;
    }

    @RequireAuth
    @RequestMapping(value = "product/", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<ProductResponseVO> queryProductInfoById(@RequestParam("id") Long id, HttpSession session){
        User user = (User) session.getAttribute(Const.CUR_USER); // TODO：
        ServerResponse<ProductResponseVO> response;
        try {
            Product product = goodsInfoService.queryProductById(id);
            if (!product.getOwner().equals(user.getName())) {
                response = ServerResponse.createByErrorMessage("product auth failed");
            }
            ProductResponseVO productResponseVO = new ProductResponseVO();
            productResponseVO.setProduct(product);
            response = ServerResponse.createBySuccess(productResponseVO);
        } catch (Exception e) {
            response = ServerResponse.createByErrorMessage(e.getMessage());
        }
        return response;
    }
}
