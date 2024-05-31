package ru.itmo.datagenerator.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.datagenerator.entity.DishIngredients;

public interface JpaDishIngredientsRepository extends JpaRepository<DishIngredients, Long> {
}
