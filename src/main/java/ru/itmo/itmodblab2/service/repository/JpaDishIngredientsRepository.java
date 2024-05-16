package ru.itmo.itmodblab2.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.itmodblab2.entity.DishIngredients;

public interface JpaDishIngredientsRepository extends JpaRepository<DishIngredients, Long> {
}
