package com.example.demo.model.upk;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MaterialInventoryUPK implements Serializable {

    private Long storeId;

    private Long materialId;
}
