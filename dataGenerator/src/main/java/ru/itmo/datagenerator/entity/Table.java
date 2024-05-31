package ru.itmo.datagenerator.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@jakarta.persistence.Table(name = "table_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Table {
    @Id
    private Long id;

    @Column
    private boolean isVeranda;

    @Column
    private boolean isAroundWindow;

    @Column
    private int seats;
}