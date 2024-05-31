package ru.itmo.datagenerator.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.datagenerator.entity.Supplier;

public interface JpaSupplierRepository extends JpaRepository<Supplier, Long> {
}
