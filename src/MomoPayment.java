import java.text.DecimalFormat;

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
