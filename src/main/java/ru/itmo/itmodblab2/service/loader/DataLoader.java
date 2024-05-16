package ru.itmo.itmodblab2.service.loader;

import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itmo.itmodblab2.Data;
import ru.itmo.itmodblab2.service.repository.*;

@RequiredArgsConstructor
@Service
public class DataLoader {
    private final JpaBookingRepository bookingRepository;

    private final JpaClientRepository clientRepository;

    private final JpaDishRepository dishRepository;

    private final JpaDishIngredientsRepository dishIngredientsRepository;

    private final JpaOrderDishesRepository orderDishesRepository;

    private final JpaOrderRepository orderRepository;

    private final JpaProductRepository productRepository;

    private final JpaPurchaseDetailRepository purchaseDetailRepository;

    private final JpaPurchaseRepository purchaseRepository;

    private final JpaSupplierRepository supplierRepository;

    private final JpaTableRepository tableRepository;

    private final JpaTypeListOfSupplierRepository typeListOfSupplierRepository;

    @Transactional
    public void loadData(Data data) {
        supplierRepository.saveAllAndFlush(data.supplierList());
        typeListOfSupplierRepository.saveAllAndFlush(data.typeListOfSuppliers());
        productRepository.saveAllAndFlush(data.productList());
        purchaseDetailRepository.saveAllAndFlush(data.purchaseDetails());
        purchaseRepository.saveAllAndFlush(data.purchaseList());
        dishRepository.saveAllAndFlush(data.dishes());
        dishIngredientsRepository.saveAllAndFlush(data.dishIngredients());
        clientRepository.saveAllAndFlush(data.clients());
        orderRepository.saveAllAndFlush(data.orders());
        orderDishesRepository.saveAllAndFlush(data.orderDishes());
        tableRepository.saveAllAndFlush(data.tables());
        bookingRepository.saveAllAndFlush(data.bookings());
    }
}
