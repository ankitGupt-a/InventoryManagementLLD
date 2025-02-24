import Model.Product;
import Model.ProductUnit;
import Service.OrderService;
import Service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        ProductService productService = ProductService.getInstance();
        OrderService orderService = OrderService.getInstance();

        Product product1 = productService.addProduct("product1", 10.0, 3);
        Product product2 = productService.addProduct("product2", 20.0, 2);
        Product product3 = productService.addProduct("product3", 30.0, 1);
        Product product4 = productService.addProduct("product4", 40.0, 4);
        Product product5 = productService.addProduct("product5", 50.0, 5);

        List<ProductUnit> productUnitList = new ArrayList<>();

        productUnitList.add(new ProductUnit(product1, 1));
        productUnitList.add(new ProductUnit(product2, 1));
        productUnitList.add(new ProductUnit(product3, 1));
        productUnitList.add(new ProductUnit(product4, 1));
        productUnitList.add(new ProductUnit(product5, 6));

        orderService.createOrder(productUnitList);

        productService.getProductDetail(product1.getName());
        productService.getProductDetail(product2.getName());
        productService.getProductDetail(product3.getName());
        productService.getProductDetail(product4.getName());
        productService.getProductDetail(product5.getName());

    }
}