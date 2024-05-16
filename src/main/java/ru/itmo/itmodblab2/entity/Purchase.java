package ru.itmo.itmodblab2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {
    @Id
    private Long id;

    @Column
    private LocalDateTime time;

    @Column
    private Long supplierId;

    @Column
    private Long purchaseDetailId;
}