package com.example.demo.VO.request;

import com.example.demo.model.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class ProduceProductRequestVO {

    private Long price;

    private List<Long> materialIdList; //原材料表；

    private Long storeId;
}
