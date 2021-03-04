package com.example.demo.model;

import com.example.demo.model.upk.ProductLogisticsUPK;
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
public class ProductLogistics {
    private Long logisticsId;

    @Id
    private Long productId;
}
