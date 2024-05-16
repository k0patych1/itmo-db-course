package ru.itmo.itmodblab2.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.itmodblab2.entity.Dish;

public interface JpaDishRepository extends JpaRepository<Dish, Long> {
}
