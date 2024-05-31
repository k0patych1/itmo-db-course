package ru.itmo.datagenerator.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.datagenerator.entity.Booking;

public interface JpaBookingRepository extends JpaRepository<Booking, Long> {
}
