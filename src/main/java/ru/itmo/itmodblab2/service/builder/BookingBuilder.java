package ru.itmo.itmodblab2.service.builder;

import ru.itmo.itmodblab2.Data;

public interface BookingBuilder {
    BookingBuilder generateFakeBookings();

    Data build();
}
