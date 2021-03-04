package com.example.demo.model;

import com.example.demo.model.upk.ProductOrderUPK;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(ProductOrderUPK.class)
public class ProductOrder {
    @Id
    private Long orderId;

    @Id
    private Long productId;
}
