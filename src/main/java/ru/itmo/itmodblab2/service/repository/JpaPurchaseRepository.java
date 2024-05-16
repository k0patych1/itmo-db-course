package ru.itmo.itmodblab2.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.itmodblab2.entity.Purchase;

public interface JpaPurchaseRepository extends JpaRepository<Purchase, Long> {

}
