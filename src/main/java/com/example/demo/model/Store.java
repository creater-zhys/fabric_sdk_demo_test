package com.example.demo.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "store",uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
public class Store {
    @Id
    private Long id;

    private String name;

    private String address;

    private String owner;

    private Long size;
}
