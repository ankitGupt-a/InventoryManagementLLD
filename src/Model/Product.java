package Model;

public class Product {
    private final String name;
    private double price;
    private int units;

    public Product(final String name, final double price, final int units) {
        this.name = name;
        this.price = price;
        this.units = units;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getUnits() {
        return units;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public void setUnits(final int units) {
        this.units = units;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", units=" + units +
                '}';
    }
}
