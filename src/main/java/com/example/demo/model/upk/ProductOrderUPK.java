package com.example.demo.model.upk;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProductOrderUPK implements Serializable {
    private Long orderId;

    private Long productId;
}
