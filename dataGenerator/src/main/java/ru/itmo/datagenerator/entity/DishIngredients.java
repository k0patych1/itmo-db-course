package ru.itmo.datagenerator.entity;

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
public class DishIngredients {
    @Id
    Long id;

    @Column
    Long productId;

    @Column
    Long dishId;
}
