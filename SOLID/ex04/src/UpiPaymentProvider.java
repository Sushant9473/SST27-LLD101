public class UpiPaymentProvider implements PaymentProvider {
    @Override
    public String pay(Payment payment) {
        return "Paid via UPI: " + payment.amount;
    }
}