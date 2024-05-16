package ru.itmo.itmodblab2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itmo.itmodblab2.model.Measure;

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