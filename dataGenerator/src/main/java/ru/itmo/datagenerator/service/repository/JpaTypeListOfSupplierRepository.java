package ru.itmo.datagenerator.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.datagenerator.entity.TypeListOfSupplier;

public interface JpaTypeListOfSupplierRepository extends JpaRepository<TypeListOfSupplier, Long> {
}
