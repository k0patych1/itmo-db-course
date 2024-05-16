package ru.itmo.itmodblab2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dish {
    @Id
    Long id;

    @Column
    private String name;

    @Column
    private BigDecimal cost;

    @Column
    private int weight;

    @Column
    private int calories;
}
