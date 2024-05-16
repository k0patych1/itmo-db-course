package ru.itmo.itmodblab2.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.itmodblab2.entity.PurchaseDetail;

public interface JpaPurchaseDetailRepository extends JpaRepository<PurchaseDetail, Long> {
}
