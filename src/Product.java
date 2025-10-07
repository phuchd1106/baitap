abstract class Product {
    protected String id;
    protected String name;
    protected double price;
    protected String type;

    public Product(String id, String name, double price, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public abstract String getInfo();
}
