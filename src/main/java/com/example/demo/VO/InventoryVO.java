package com.example.demo.VO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class InventoryVO {

    private Map<Long, List<Long>> inventoryMap;
}
