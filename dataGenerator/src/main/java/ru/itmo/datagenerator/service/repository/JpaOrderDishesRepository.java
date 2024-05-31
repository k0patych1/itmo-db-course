package ru.itmo.datagenerator.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.datagenerator.entity.OrderDishes;

public interface JpaOrderDishesRepository extends JpaRepository<OrderDishes, Long> {
}
