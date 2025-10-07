import java.text.DecimalFormat;

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
