package ru.itmo.datagenerator.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.datagenerator.entity.Product;

public interface JpaProductRepository extends JpaRepository<Product, Long> {
}
