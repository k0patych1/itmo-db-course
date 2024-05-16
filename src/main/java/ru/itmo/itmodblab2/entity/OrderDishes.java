package ru.itmo.itmodblab2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDishes {
    @Id
    private Long id;

    @Column
    private Long orderId;

    @Column
    private Long dishId;
}
