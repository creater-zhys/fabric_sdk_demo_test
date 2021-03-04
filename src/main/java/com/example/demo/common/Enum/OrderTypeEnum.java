package com.example.demo.common.Enum;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public enum OrderTypeEnum {
    UNKNOWN("UNKNOWN", 0),

    PRODUCT("PRODUCT", 1),

    MATERIAL("MATERIAL", 2);

    private String name;

    private Integer index;

    OrderTypeEnum(String name, Integer index) {
        this.name = name;
        this.index = index;
    }

    public OrderTypeEnum getOrderTypeByName(String name) {
        for (OrderTypeEnum type : OrderTypeEnum.values()) {
            if (type.getTypeName() == name) {
                return type;
            }
        }
        return null;
    }

    public String getTypeName() {
        return this.name;
    }

}
