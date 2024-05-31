package ru.itmo.datagenerator.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.datagenerator.entity.Table;

public interface JpaTableRepository extends JpaRepository<Table, Long> {
}
