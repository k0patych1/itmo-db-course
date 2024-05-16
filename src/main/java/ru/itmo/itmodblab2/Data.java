package ru.itmo.itmodblab2;

import net.datafaker.Faker;
import ru.itmo.itmodblab2.entity.*;
import ru.itmo.itmodblab2.model.Measure;
import ru.itmo.itmodblab2.model.ProductType;
import ru.itmo.itmodblab2.service.builder.*;
import ru.itmo.itmodblab2.service.generator.ProductGenerator;
import ru.itmo.itmodblab2.service.generator.PurchaseGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public record Data(
        List<Supplier> supplierList,
        List<TypeListOfSupplier> typeListOfSuppliers,
        List<Product> productList,
        List<PurchaseDetail> purchaseDetails,
        List<Purchase> purchaseList,
        List<Dish> dishes,
        List<DishIngredients> dishIngredients,
        List<Client> clients,
        List<Order> orders,
        List<OrderDishes> orderDishes,
        List<Table> tables,
        List<Booking> bookings
) {
    private static final int GENERATION_DATA_SIZE = 10;

    public static SupplierBuilder Builder = new DataBuilder();

    private static class DataBuilder implements SupplierBuilder, TypeListOfSupplierBuilder,
            ProductBuilder, PurchaseDetailBuilder, PurchaseBuilder,
            DishBuilder, DishIngredientsBuilder, ClientBuilder,
            OrderBuilder, OrderDishesBuilder, TableBuilder, BookingBuilder {
        private final List<Supplier> supplierList;

        private final List<TypeListOfSupplier> typeListOfSuppliers;

        private final List<Product> productList;

        private final List<PurchaseDetail> purchaseDetails;

        private final List<Purchase> purchaseList;

        private final List<Dish> dishes;

        private final List<DishIngredients> dishIngredients;

        private final List<Client> clients;

        private final List<Order> orders;

        private final List<OrderDishes> orderDishes;

        private final List<Table> tables;

        private final List<Booking> bookings;

        private final Faker faker;

        private DataBuilder() {
            supplierList = new ArrayList<>();
            typeListOfSuppliers = new ArrayList<>();
            productList = new ArrayList<>();
            purchaseDetails = new ArrayList<>();
            purchaseList = new ArrayList<>();
            dishes = new ArrayList<>();
            dishIngredients = new ArrayList<>();
            clients = new ArrayList<>();
            orders = new ArrayList<>();
            orderDishes = new ArrayList<>();
            tables = new ArrayList<>();
            bookings = new ArrayList<>();

            faker = new Faker();
        }

        @Override
        public TypeListOfSupplierBuilder generateFakeSuppliers() {
            for (long i = 0; i < GENERATION_DATA_SIZE; ++i) {
                String supplierName = faker.company().name();
                supplierList.add(new Supplier(i, supplierName));
            }

            return this;
        }

        @Override
        public ProductBuilder generateFakeTypes() {
            for (long i = 0; i < GENERATION_DATA_SIZE; ++i) {
                var types = ProductType.values();
                ProductType productType = types[faker.number().numberBetween(0, types.length)];
                typeListOfSuppliers.add(new TypeListOfSupplier(i, i, productType));
            }

            for (long i = 0; i < GENERATION_DATA_SIZE; ++i) {
                Long supplierId = faker.number().numberBetween(0L, GENERATION_DATA_SIZE);
                var types = ProductType.values();
                ProductType productType = types[faker.number().numberBetween(0, types.length)];
                typeListOfSuppliers.add(new TypeListOfSupplier(i + GENERATION_DATA_SIZE, supplierId, productType));
            }

            return this;
        }

        @Override
        public PurchaseDetailBuilder generateFakeProducts() {
            for (long i = 0; i < GENERATION_DATA_SIZE; ++i) {
                ProductType productType = typeListOfSuppliers.get(
                        faker.number().numberBetween(0, typeListOfSuppliers.size())).
                        getProductType();
                String productName = ProductGenerator.generateProductName(productType);
                int minStock = faker.number().numberBetween(0, 100);
                int currentStock = faker.number().numberBetween(minStock, 100);
                var types = Measure.values();
                Measure measure = types[faker.number().numberBetween(0, types.length)];
                productList.add(new Product(i, productName, productType, minStock, currentStock, measure));
            }

            return this;
        }

        @Override
        public PurchaseBuilder generateFakePurchaseDetails() {
            for (long i = 0; i < GENERATION_DATA_SIZE; ++i) {
                long productId = faker.number().numberBetween(0, GENERATION_DATA_SIZE);
                int volume = faker.number().numberBetween(1, 100);
                BigDecimal price = BigDecimal.valueOf(faker.number().randomDouble(2, 100, 100000));
                Measure measure = PurchaseGenerator.generateMeasure(productList.get((int) productId).getType());
                purchaseDetails.add(new PurchaseDetail(i, productId, volume, price, measure));
            }

            return this;
        }

        @Override
        public DishBuilder generateFakePurchases() {
            for (long i = 0; i < GENERATION_DATA_SIZE; ++i) {
                long supplierId = faker.number().numberBetween(0, GENERATION_DATA_SIZE);
                long purchaseDetailId = faker.number().numberBetween(0, GENERATION_DATA_SIZE);
                LocalDateTime time = LocalDateTime.now()
                        .minusDays(faker.number().numberBetween(0, 365))
                        .minusHours(faker.number().numberBetween(0, 24))
                        .minusMinutes(faker.number().numberBetween(0, 60))
                        .minusSeconds(faker.number().numberBetween(0, 60));
                purchaseList.add(new Purchase(i, time, supplierId, purchaseDetailId));
            }

            return this;
        }

        @Override
        public DishIngredientsBuilder generateFakeDishes() {
            for (long i = 0; i < GENERATION_DATA_SIZE; ++i) {
                String name = faker.food().dish();
                BigDecimal price = BigDecimal.valueOf(faker.number().randomDouble(2, 100, 10000));
                int weight = faker.number().numberBetween(40, 500);
                int calories = faker.number().numberBetween(100, 1000);
                dishes.add(new Dish(i, name, price, weight, calories));
            }

            return this;
        }

        @Override
        public BookingBuilder generateFakeBookings() {
            for (long i = 0; i < GENERATION_DATA_SIZE; ++i) {
                long tableId = faker.number().numberBetween(0, GENERATION_DATA_SIZE);
                LocalDateTime startTime = LocalDateTime.now()
                        .plusDays(faker.number().numberBetween(0, 7))
                        .plusHours(faker.number().numberBetween(0, 24))
                        .plusMinutes(faker.number().numberBetween(0, 60))
                        .plusSeconds(faker.number().numberBetween(0, 60));
                LocalDateTime endTime = startTime
                        .plusHours(faker.number().numberBetween(1, 4))
                        .plusMinutes(faker.number().numberBetween(0, 60))
                        .plusSeconds(faker.number().numberBetween(0, 60));
                bookings.add(new Booking(i, startTime, endTime, i, tableId));
            }

            return this;
        }

        @Override
        public OrderBuilder generateFakeClients() {
            for (long i = 0; i < GENERATION_DATA_SIZE; ++i) {
                String name = faker.name().firstName();
                String surname = faker.name().lastName();
                String phone = faker.phoneNumber().cellPhone();
                String email = faker.internet().emailAddress();
                Date birthday = faker.date().birthday();
                clients.add(new Client(i, name, surname, phone, email, birthday));
            }

            return this;
        }

        @Override
        public ClientBuilder generateFakeDishIngredients() {
            for (long i = 0; i < GENERATION_DATA_SIZE; ++i) {
                long productId = faker.number().numberBetween(0, GENERATION_DATA_SIZE);
                dishIngredients.add(new DishIngredients(i, productId, i));
            }

            for (long i = 0; i < GENERATION_DATA_SIZE; ++i) {
                long dishId = faker.number().numberBetween(0, GENERATION_DATA_SIZE);
                long productId = faker.number().numberBetween(0, GENERATION_DATA_SIZE);
                dishIngredients.add(new DishIngredients(i + GENERATION_DATA_SIZE, productId, dishId));
            }

            return this;
        }

        @Override
        public TableBuilder generateFakeOrderDishes() {
            for (long i = 0; i < GENERATION_DATA_SIZE; ++i) {
                long dishId = faker.number().numberBetween(0, GENERATION_DATA_SIZE);
                orderDishes.add(new OrderDishes(i, i, dishId));
            }

            for (long i = 0; i < GENERATION_DATA_SIZE; ++i) {
                long clientId = faker.number().numberBetween(0, GENERATION_DATA_SIZE);
                long dishId = faker.number().numberBetween(0, GENERATION_DATA_SIZE);
                orderDishes.add(new OrderDishes(i, clientId, dishId));
            }

            return this;
        }

        @Override
        public BookingBuilder generateFakeTables() {
            for (long i = 0; i < GENERATION_DATA_SIZE; ++i) {
                tables.add(new Table(i, faker.bool().bool(), faker.bool().bool(), faker.number().numberBetween(1, 10)));
            }

            return this;
        }

        @Override
        public OrderDishesBuilder generateFakeOrders() {
            for (long i = 0; i < GENERATION_DATA_SIZE; ++i) {
                long clientId = faker.number().numberBetween(0, GENERATION_DATA_SIZE);
                LocalDateTime time = LocalDateTime.now()
                        .minusDays(faker.number().numberBetween(0, 365))
                        .minusHours(faker.number().numberBetween(0, 24))
                        .minusMinutes(faker.number().numberBetween(0, 60))
                        .minusSeconds(faker.number().numberBetween(0, 60));
                int count = faker.number().numberBetween(1, 3);
                orders.add(new Order(i, time, clientId, count));
            }

            return this;
        }

        @Override
        public Data build() {
            return new Data(supplierList, typeListOfSuppliers, productList, purchaseDetails, purchaseList,
                    dishes, dishIngredients, clients, orders, orderDishes, tables, bookings);
        }
    }
}
