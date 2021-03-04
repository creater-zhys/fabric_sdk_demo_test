package com.example.demo.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Logistics {
    @Id
    private Long id;

    private String departure;

    private String destination;

    private String currentAddress;

    private Long orderId;
}
