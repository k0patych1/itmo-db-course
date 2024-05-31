package ru.itmo.datagenerator.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.datagenerator.entity.Dish;

public interface JpaDishRepository extends JpaRepository<Dish, Long> {
}
