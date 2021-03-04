package com.example.demo.model;

import com.example.demo.common.Enum.OrderTypeEnum;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "p_order")
public class Order {
    @Id
    private Long id;

    private String buyer;

    private String seller;

    private String destination;

    private Date date;

    private OrderTypeEnum orderTypeEnum;
}
