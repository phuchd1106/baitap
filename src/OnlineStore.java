import java.util.*;

public class OnlineStore {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();

        productList.add(new ElectronicProduct("E01", "iPhone 14", 20000000, "IMEI123456789", 24));
        productList.add(new FoodProduct("F01", "Bánh quy", 30000, "2025-12-31"));
        productList.add(new FoodProduct("F02", "Sữa tươi", 15000, "2025-10-31"));
        productList.add(new ElectronicProduct("E02", "Samsung TV", 12000000, "IMEI987654321", 12));
        productList.add(new FoodProduct("F03", "Trà xanh", 25000, "2026-01-01"));

        Order order1 = new Order("Nguyễn Văn A", new CashPayment());
        order1.addProduct(productList.get(0)); // iPhone
        order1.addProduct(productList.get(1)); // Bánh quy
        order1.printOrderDetails();
        order1.checkout();

        Order order2 = new Order("Nguyễn Văn B", new CreditCardPayment("1234-5678-9012-3456"));
        order2.addProduct(productList.get(2)); // Sữa tươi
        order2.addProduct(productList.get(3)); // Samsung TV
        order2.printOrderDetails();
        order2.checkout();

        Order order3 = new Order("Nguyễn Văn C", new MomoPayment("momo1234"));
        order3.addProduct(productList.get(1)); // Bánh quy
        order3.addProduct(productList.get(2)); // Sữa tươi
        order3.printOrderDetails();
        order3.checkout();

        Order order4 = new Order("Nguyễn Văn D", new BankTransferPayment("123456789-Vietcombank"));
        order4.addProduct(productList.get(4)); // Trà xanh
        order4.addProduct(productList.get(1)); // Bánh quy
        order4.printOrderDetails();
        order4.checkout();
    }
}