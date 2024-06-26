package ru.itmo.datagenerator.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itmo.datagenerator.model.Measure;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDetail {
    @Id
    private Long id;

    @Column
    private Long productId;

    @Column
    private int volume;

    @Column
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private Measure measure;
}