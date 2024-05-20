package ru.itmo.itmodblab2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import ru.itmo.itmodblab2.config.ApplicationConfig;
import ru.itmo.itmodblab2.service.loader.DataLoader;

@EnableConfigurationProperties(ApplicationConfig.class)
@SpringBootApplication
public class ItmoDbLab2Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ItmoDbLab2Application.class, args);

        ApplicationConfig applicationConfig = context.getBean(ApplicationConfig.class);

        Data data = Data.Builder
                .setGenerationSize(applicationConfig.generationDataSize())
                .generateFakeSuppliers()
                .generateFakeTypes()
                .generateFakeProducts()
                .generateFakePurchaseDetails()
                .generateFakePurchases()
                .generateFakeDishes()
                .generateFakeDishIngredients()
                .generateFakeClients()
                .generateFakeOrders()
                .generateFakeOrderDishes()
                .generateFakeTables()
                .generateFakeBookings()
                .build();

        context.getBean(DataLoader.class).loadData(data);
    }
}
