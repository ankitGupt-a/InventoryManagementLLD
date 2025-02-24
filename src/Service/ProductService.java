package Service;

import Model.*;
import Repository.ProductRepository;

import java.util.Optional;


public class ProductService {

    public static final ProductService instance = new ProductService();
    private final ProductRepository productRepository;

    private ProductService() {
        this.productRepository = new ProductRepository();
    }

    public static ProductService getInstance() {
        return instance;
    }

    public Product addProduct(final String name, final Double price, final Integer units) {
        Product product = new Product(name, price, units);
        productRepository.saveProduct(product);
        return product;
    }

    public void updateProduct(final String name, final Double price, final Integer units) {
        Product product = productRepository.getProduct(name).orElse(null);

        if (product==null) {
            System.out.println("Please add product first");
            return;
        }

        if (price!=null) {
            product.setPrice(price);
        }

        if (units!=null) {
            product.setUnits(units);
        }
        productRepository.saveProduct(product);
        System.out.println("Successfully updated the product: " + name);
    }

    public void removeProduct(final Product product) {
        productRepository.removeProduct(product);
    }

    public int getProductStock(final String name) {
        Optional<Product> product = productRepository.getProduct(name);

        if (product.isEmpty()) {
            System.out.println("Product " + name + " is not in the store");
            return 0;
        }

        return product.get().getUnits();
    }

    public boolean checkStock(final String name, final int requiredUnit) {
        return productRepository.getProduct(name)
                .map(product -> product.getUnits()>=requiredUnit)
                .orElse(false);
    }

    public void getProductDetail(final String name) {

        Optional<Product> product = productRepository.getProduct(name);

        if (product.isEmpty()) {
            System.out.println("Product " + name + " is not in the store");
            return;
        }

        System.out.println(product);
    }
}
