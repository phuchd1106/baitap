class ElectronicProduct extends Product {
    private String imei;
    private int warrantyMonths;

    public ElectronicProduct(String id, String name, double price, String imei, int warrantyMonths) {
        super(id, name, price, "Electronic");
        this.imei = imei;
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public String getInfo() {
        return String.format("Electronic: %s, IMEI: %s, Warranty: %d months", name, imei, warrantyMonths);
    }
}
