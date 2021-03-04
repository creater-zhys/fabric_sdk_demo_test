package com.example.demo.VO;

import com.example.demo.model.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class IngredientVO {
    private Product product;

    private List<Long> materialIds;
}
