package com.example.demo.model;

import com.example.demo.model.upk.MaterialInventoryUPK;
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
public class MaterialInventory {
    private Long storeId;

    @Id
    private Long materialId;
}
