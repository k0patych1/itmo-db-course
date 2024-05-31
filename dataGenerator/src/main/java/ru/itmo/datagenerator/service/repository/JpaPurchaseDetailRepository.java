package ru.itmo.datagenerator.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.datagenerator.entity.PurchaseDetail;

public interface JpaPurchaseDetailRepository extends JpaRepository<PurchaseDetail, Long> {
}
