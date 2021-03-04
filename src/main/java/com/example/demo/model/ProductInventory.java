package com.example.demo.model;

import com.example.demo.model.upk.ProductInventoryUPK;
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
public class ProductInventory {
    private Long storeId;

    @Id
    private Long productId;
}
