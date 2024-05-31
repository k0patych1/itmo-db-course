package ru.itmo.datagenerator.service.builder;

import ru.itmo.datagenerator.Data;

public interface BookingBuilder {
    BookingBuilder generateFakeBookings();

    Data build();
}
