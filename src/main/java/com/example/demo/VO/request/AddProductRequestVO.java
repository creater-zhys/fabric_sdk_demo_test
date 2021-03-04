package com.example.demo.VO.request;

import com.example.demo.common.Verification;
import com.example.demo.model.Material;
import com.example.demo.model.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Setter
@Getter
public class AddProductRequestVO extends Verification {
    private Long storeId;

    private List<Product> productList;

    @Override
    public Boolean checkArguments() {
        return null;
    }
}
