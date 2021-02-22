package com.example.demo.common.Enum;

public enum LogisticsStateEnum {

    UNKNOWEN("UNKNOWEN", 0),

    TRANSPORT("TRANSPORT", 1),

    FINISHED("FINISHED", 2);

    private String name;

    private Integer index;

    LogisticsStateEnum(String name, Integer index) {
        this.name = name;
        this.index = index;
    }
}
