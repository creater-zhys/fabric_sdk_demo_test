package com.example.demo.VO.request;

import com.example.demo.common.Verification;
import com.example.demo.model.Material;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Setter
@Getter
public class AddMaterialRequestVO extends Verification {
    private Long storeId;

    private List<Material> materialList;

    @Override
    public Boolean checkArguments() {
        return null;
    }
}
