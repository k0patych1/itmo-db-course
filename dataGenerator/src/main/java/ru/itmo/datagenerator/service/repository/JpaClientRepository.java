package ru.itmo.datagenerator.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.datagenerator.entity.Client;

public interface JpaClientRepository extends JpaRepository<Client, Long> {
}
