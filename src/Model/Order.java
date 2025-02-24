package Model;

import Util.GenerateId;

import java.util.List;

public class Order {
    private final String id;
    private final List<ProductUnit> productUnitList;

    public Order(final List<ProductUnit> productUnitList) {
        this.id = GenerateId.generateId();
        this.productUnitList = productUnitList;
    }

    public String getId() {
        return id;
    }

    public List<ProductUnit> getProductUnitList() {
        return productUnitList;
    }
}
