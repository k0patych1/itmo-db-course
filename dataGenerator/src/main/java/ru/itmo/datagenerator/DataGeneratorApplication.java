package ru.itmo.datagenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import ru.itmo.datagenerator.config.ApplicationConfig;
import ru.itmo.datagenerator.service.loader.DataLoader;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfig.class)
public class DataGeneratorApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DataGeneratorApplication.class, args);

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
