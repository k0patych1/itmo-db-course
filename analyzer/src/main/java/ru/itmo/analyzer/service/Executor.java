package ru.itmo.analyzer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;
import ru.itmo.analyzer.config.ApplicationConfig;

@Component
@RequiredArgsConstructor
public class Executor {
    private final ApplicationConfig applicationConfig;

    private final JdbcTemplate jdbcTemplate;

    @EventListener(ApplicationReadyEvent.class)
    public void runQueries() {
        String[] queriesArray = applicationConfig.queries().split(";");
        for (String query : queriesArray) {
            jdbcTemplate.execute(query);
        }
    }
}
