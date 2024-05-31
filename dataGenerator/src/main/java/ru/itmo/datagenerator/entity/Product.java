package ru.itmo.datagenerator.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itmo.datagenerator.model.Measure;
import ru.itmo.datagenerator.model.ProductType;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private Long id;

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    private ProductType type;

    @Column
    private int minStock;

    @Column
    private int currentStock;

    @Enumerated(EnumType.STRING)
    private Measure measure;
}