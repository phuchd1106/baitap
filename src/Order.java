import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

class Order {
    private String customerName;
    private List<Product> products;
    private PaymentMethod paymentMethod;

    public Order(String customerName, PaymentMethod paymentMethod) {
        this.customerName = customerName;
        this.paymentMethod = paymentMethod;
        products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public double getTotalAmount() {
        double total = 0;
        for (Product p : products) total += p.getPrice();
        return total;
    }

    public void checkout() {
        double total = getTotalAmount();
        paymentMethod.pay(customerName, total);
    }

    public void printOrderDetails() {
        DecimalFormat df = new DecimalFormat("#,###");
        System.out.println("Đơn hàng của khách hàng: " + customerName);
        for (Product p : products) {
            System.out.println(" - " + p.getInfo() + ", Giá: " + df.format(p.getPrice()));
        }
        System.out.println("Tổng tiền: " + df.format(getTotalAmount()));
    }
}
