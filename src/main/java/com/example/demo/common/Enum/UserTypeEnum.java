package com.example.demo.common.Enum;

import lombok.ToString;

@ToString
public enum UserTypeEnum {
    UNKNOWEN("UNKNOWEN", 0),

    SUPPLIER("SUPPLIER", 1),

    MANUFACTURER("MANUFACTURER", 2),

    DEALER("DEALER", 3);

    private String name;
    private Integer index;

    UserTypeEnum(String name, Integer index) {
        this.name = name;
        this.index = index;
    }

    public UserTypeEnum getUserTypeByName(String name) {
        for (UserTypeEnum type : UserTypeEnum.values()) {
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
