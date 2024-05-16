package ru.itmo.itmodblab2.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.itmodblab2.entity.Booking;

public interface JpaBookingRepository extends JpaRepository<Booking, Long> {
}
