package com.example.demo.VO.response;

import com.example.demo.model.Material;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@ToString
@Getter
@Setter
public class MaterialInventoryResponseVO {
    Long inventory;

    List<Long> materialIds;
}
