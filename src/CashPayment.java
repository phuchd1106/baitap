import java.text.DecimalFormat;

class CashPayment implements PaymentMethod {
    @Override
    public void pay(String customerName, double amount) {
        DecimalFormat df = new DecimalFormat("#,###");
        System.out.printf("Khách hàng: %s. Tổng tiền: %s. Thanh toán tiền mặt thành công.\n", customerName, df.format(amount));
    }
}
