import java.text.DecimalFormat;

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
