public class WalletPaymentProvider implements PaymentProvider {
    @Override
    public String pay(Payment payment) {
        return "Wallet debit: " + payment.amount;
    }
}