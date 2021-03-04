package com.example.demo.VO.response;

import com.example.demo.model.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

@ToString
@Getter
@Setter
public class ProductResponseVO {
    private Product product;
}
