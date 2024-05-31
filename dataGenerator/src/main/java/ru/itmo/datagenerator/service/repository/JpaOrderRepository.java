package ru.itmo.datagenerator.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.datagenerator.entity.Order;

public interface JpaOrderRepository extends JpaRepository<Order, Long> {
}
