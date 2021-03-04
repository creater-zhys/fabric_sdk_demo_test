package com.example.demo.VO.response;

import com.example.demo.model.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@ToString
@Getter
@Setter
public class ProductInventoryResponseVO {
    Long inventory;

    List<Long> productIds;
}
