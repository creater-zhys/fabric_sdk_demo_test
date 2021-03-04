package com.example.demo.model;

import com.example.demo.model.upk.IngredientUPK;
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
@IdClass(IngredientUPK.class)
public class Ingredient {
    @Id
    private Long productId;

    @Id
    private Long materialId;
}
