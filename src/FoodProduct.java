class FoodProduct extends Product {
    private String expirationDate;

    public FoodProduct(String id, String name, double price, String expirationDate) {
        super(id, name, price, "Food");
        this.expirationDate = expirationDate;
    }

    @Override
    public String getInfo() {
        return String.format("Food: %s, Expiration Date: %s", name, expirationDate);
    }
}
