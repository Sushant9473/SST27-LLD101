public class CardPaymentProvider implements PaymentProvider {
    @Override
    public String pay(Payment payment) {
        return "Charged card: " + payment.amount;
    }
}