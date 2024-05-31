package ru.itmo.datagenerator.service.loader;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itmo.datagenerator.Data;
import ru.itmo.datagenerator.service.repository.*;

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
        supplierRepository.saveAllAndFlush(data.getSupplierList());
        typeListOfSupplierRepository.saveAllAndFlush(data.getTypeListOfSuppliers());
        productRepository.saveAllAndFlush(data.getProductList());
        purchaseDetailRepository.saveAllAndFlush(data.getPurchaseDetails());
        purchaseRepository.saveAllAndFlush(data.getPurchaseList());
        dishRepository.saveAllAndFlush(data.getDishes());
        dishIngredientsRepository.saveAllAndFlush(data.getDishIngredients());
        clientRepository.saveAllAndFlush(data.getClients());
        orderRepository.saveAllAndFlush(data.getOrders());
        orderDishesRepository.saveAllAndFlush(data.getOrderDishes());
        tableRepository.saveAllAndFlush(data.getTables());
        bookingRepository.saveAllAndFlush(data.getBookings());
    }
}
