package Service;

import Model.Order;
import Model.Product;
import Model.ProductUnit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class OrderService {

    private static final OrderService instance = new OrderService();
    private final Map<String, Order> orderMap;
    private final ProductService productService;
    private OrderService() {
        this.orderMap = new ConcurrentHashMap<>();
        this.productService = ProductService.getInstance();
    }

    public static OrderService getInstance() {
        return instance;
    }

    public String createOrder(final List<ProductUnit> productUnitList) {
        ArrayList<ProductUnit> processedUnit = new ArrayList<>();

        for (ProductUnit productUnit: productUnitList) {
            if (!productService.checkStock(productUnit.getProduct().getName(), productUnit.getUnit())) {
                System.out.println("Insufficient stock for " + productUnit.getProduct().getName());
                rollbackStock(processedUnit);
                return null;
            }

            productService.updateProduct(productUnit.getProduct().getName(), null,
                productUnit.getProduct().getUnits()-productUnit.getUnit());
            processedUnit.add(productUnit);
        }

        Order order = new Order(productUnitList);
        orderMap.put(order.getId(), order);
        System.out.println("Order is successfully placed");
        return order.getId();
    }

    private void rollbackStock(final ArrayList<ProductUnit> processedUnit) {
        for (ProductUnit productUnit: processedUnit) {
            productService.updateProduct(productUnit.getProduct().getName(), null,
                    productUnit.getProduct().getUnits()+productUnit.getUnit());
        }
    }

    public Optional<Order> getOrder(String orderId) {
        return Optional.ofNullable(orderMap.get(orderId));
    }
}
