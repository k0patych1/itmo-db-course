package ru.itmo.itmodblab2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.itmo.itmodblab2.entity.Supplier;
import ru.itmo.itmodblab2.service.loader.DataLoader;

import java.util.List;

@SpringBootApplication
public class ItmoDbLab2Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ItmoDbLab2Application.class, args);
        Data data = Data.Builder
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
