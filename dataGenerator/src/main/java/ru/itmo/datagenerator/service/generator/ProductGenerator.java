package ru.itmo.datagenerator.service.generator;

import lombok.experimental.UtilityClass;
import net.datafaker.Faker;
import ru.itmo.datagenerator.model.ProductType;

import java.util.Map;

@UtilityClass
public class ProductGenerator {
    private final Faker faker = new Faker();
    private final Map<ProductType, String> nameGenerators = Map.ofEntries(
            Map.entry(ProductType.MEAT_AND_MEAT_PRODUCTS, "Chicken"),
            Map.entry(ProductType.FISH_AND_SEAFOOD, "Crab"),
            Map.entry(ProductType.EGGS, "Eggs"),
            Map.entry(ProductType.MILK_AND_DAIRY_PRODUCTS, "Cheese"),
            Map.entry(ProductType.BREAD_AND_BAKERY_PRODUCTS, "Bread"),
            Map.entry(ProductType.CEREALS_AND_PASTA, "Pasta"),
            Map.entry(ProductType.LEGUMES, "Peas"),
            Map.entry(ProductType.VEGETABLES_FRUITS_AND_BERRIES, faker.food().fruit()),
            Map.entry(ProductType.NUTS_AND_MUSHROOMS, faker.food().vegetable()),
            Map.entry(ProductType.CONFECTIONERY, "Cake"),
            Map.entry(ProductType.FATS_AND_OILS, "Olive Oil"),
            Map.entry(ProductType.BEVERAGES, faker.beer().name())
    );

    public String generateProductName(ProductType productType) {
        return nameGenerators.get(productType);
    }
}
