import java.util.*;
import java.text.DecimalFormat;

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

interface PaymentMethod {
    void pay(String customerName, double amount);
}

class CashPayment implements PaymentMethod {
    @Override
    public void pay(String customerName, double amount) {
        DecimalFormat df = new DecimalFormat("#,###");
        System.out.printf("Khách hàng: %s. Tổng tiền: %s. Thanh toán tiền mặt thành công.\n", customerName, df.format(amount));
    }
}

class CreditCardPayment implements PaymentMethod {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(String customerName, double amount) {
        DecimalFormat df = new DecimalFormat("#,###");
        System.out.printf("Khách hàng: %s. Tổng tiền: %s. Thanh toán bằng thẻ tín dụng thành công.\n", customerName, df.format(amount));
    }
}

class MomoPayment implements PaymentMethod {
    private String momoId;

    public MomoPayment(String momoId) {
        this.momoId = momoId;
    }

    @Override
    public void pay(String customerName, double amount) {
        DecimalFormat df = new DecimalFormat("#,###");
        System.out.printf("Khách hàng: %s. Tổng tiền: %s. Thanh toán qua ví Momo thành công.\n", customerName, df.format(amount));
    }
}

// PHƯƠNG THỨC THANH TOÁN MỚI: Chuyển khoản ngân hàng
class BankTransferPayment implements PaymentMethod {
    private String bankAccount;
    public BankTransferPayment(String bankAccount) {
        this.bankAccount = bankAccount;
    }
    @Override
    public void pay(String customerName, double amount) {
        DecimalFormat df = new DecimalFormat("#,###");
        System.out.printf(
                "Khách hàng: %s. Tổng tiền: %s. Thanh toán chuyển khoản ngân hàng thành công tới tài khoản %s.\n",
                customerName, df.format(amount), bankAccount
        );
    }
}

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

public class OnlineStore {
    public static void main(String[] args) {
        // Tạo danh sách sản phẩm
        List<Product> productList = new ArrayList<>();

        productList.add(new ElectronicProduct("E01", "iPhone 14", 20000000, "IMEI123456789", 24));
        productList.add(new FoodProduct("F01", "Bánh quy", 30000, "2025-12-31"));
        productList.add(new FoodProduct("F02", "Sữa tươi", 15000, "2025-10-31"));
        productList.add(new ElectronicProduct("E02", "Samsung TV", 12000000, "IMEI987654321", 12));
        productList.add(new FoodProduct("F03", "Trà xanh", 25000, "2026-01-01"));

        // Đơn hàng tiền mặt
        Order order1 = new Order("Nguyễn Văn A", new CashPayment());
        order1.addProduct(productList.get(0)); // iPhone
        order1.addProduct(productList.get(1)); // Bánh quy
        order1.printOrderDetails();
        order1.checkout();

        // Đơn hàng thẻ tín dụng
        Order order2 = new Order("Nguyễn Văn B", new CreditCardPayment("1234-5678-9012-3456"));
        order2.addProduct(productList.get(2)); // Sữa tươi
        order2.addProduct(productList.get(3)); // Samsung TV
        order2.printOrderDetails();
        order2.checkout();

        // Đơn hàng ví Momo
        Order order3 = new Order("Nguyễn Văn C", new MomoPayment("momo1234"));
        order3.addProduct(productList.get(1)); // Bánh quy
        order3.addProduct(productList.get(2)); // Sữa tươi
        order3.printOrderDetails();
        order3.checkout();

        // Đơn hàng chuyển khoản ngân hàng (PHƯƠNG THỨC MỚI)
        Order order4 = new Order("Nguyễn Văn D", new BankTransferPayment("123456789-Vietcombank"));
        order4.addProduct(productList.get(4)); // Trà xanh
        order4.addProduct(productList.get(1)); // Bánh quy
        order4.printOrderDetails();
        order4.checkout();
    }
}