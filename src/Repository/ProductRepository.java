package Repository;

import Model.Product;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ProductRepository {
    private final Map<String, Product> productMap = new ConcurrentHashMap<>();

    public Optional<Product> getProduct(String name) {
        return Optional.ofNullable(productMap.get(name));
    }

    public void saveProduct(final Product product) {
        productMap.put(product.getName(), product);
    }

    public void removeProduct(final Product product) {
        productMap.remove(product.getName());
    }
}
