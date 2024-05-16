package ru.itmo.itmodblab2.service.generator;

import lombok.experimental.UtilityClass;
import net.datafaker.Faker;
import ru.itmo.itmodblab2.model.Measure;
import ru.itmo.itmodblab2.model.ProductType;

import java.util.Map;

@UtilityClass
public class PurchaseGenerator {
    private final Map<ProductType, Measure> measureGenerators = Map.ofEntries(
            Map.entry(ProductType.MEAT_AND_MEAT_PRODUCTS, Measure.KILOGRAMS),
            Map.entry(ProductType.FISH_AND_SEAFOOD, Measure.KILOGRAMS),
            Map.entry(ProductType.EGGS, Measure.PACKAGES),
            Map.entry(ProductType.MILK_AND_DAIRY_PRODUCTS, Measure.BOTTLES),
            Map.entry(ProductType.BREAD_AND_BAKERY_PRODUCTS, Measure.PIECES),
            Map.entry(ProductType.CEREALS_AND_PASTA, Measure.KILOGRAMS),
            Map.entry(ProductType.LEGUMES, Measure.KILOGRAMS),
            Map.entry(ProductType.VEGETABLES_FRUITS_AND_BERRIES, Measure.KILOGRAMS),
            Map.entry(ProductType.NUTS_AND_MUSHROOMS, Measure.KILOGRAMS),
            Map.entry(ProductType.CONFECTIONERY, Measure.PIECES),
            Map.entry(ProductType.FATS_AND_OILS, Measure.LITERS),
            Map.entry(ProductType.BEVERAGES, Measure.BOTTLES)
    );

    public Measure generateMeasure(ProductType productType) {
        return measureGenerators.get(productType);
    }
}
