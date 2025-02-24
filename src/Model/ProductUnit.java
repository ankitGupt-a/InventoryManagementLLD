package Model;

public class ProductUnit {
    private final Product product;
    private final int unit;

    public ProductUnit(final Product product, final int unit) {
        this.product = product;
        this.unit = unit;
    }

    public Product getProduct() {
        return product;
    }

    public int getUnit() {
        return unit;
    }
}
