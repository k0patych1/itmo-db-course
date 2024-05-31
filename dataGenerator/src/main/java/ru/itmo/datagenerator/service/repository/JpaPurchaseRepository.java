package ru.itmo.datagenerator.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.datagenerator.entity.Purchase;

public interface JpaPurchaseRepository extends JpaRepository<Purchase, Long> {

}
