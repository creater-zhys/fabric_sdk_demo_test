package com.example.demo.VO.response;

import com.example.demo.model.Store;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class StoresResponseVO {
    List<Store> storeList;
}
