package com.example.demo.model;

import com.example.demo.model.upk.MaterialOrderUPK;
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
@IdClass(MaterialOrderUPK.class)
public class MaterialOrder {
    @Id
    private Long orderId;

    @Id
    private Long materialId;
}
