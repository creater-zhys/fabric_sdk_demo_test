package com.example.demo.VO.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class ProduceProductsRequestVO {

    private Long price;

    private List<List<Long>> materialIdsList; //原材料表；

    private Long storeId;
}
