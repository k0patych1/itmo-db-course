package ru.itmo.datagenerator.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itmo.datagenerator.model.ProductType;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeListOfSupplier {
    @Id
    private Long id;

    @Column
    private Long supplierId;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ProductType productType;
}
