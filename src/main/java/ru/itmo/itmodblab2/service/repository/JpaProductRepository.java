package ru.itmo.itmodblab2.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.itmodblab2.entity.Product;

public interface JpaProductRepository extends JpaRepository<Product, Long> {
}
