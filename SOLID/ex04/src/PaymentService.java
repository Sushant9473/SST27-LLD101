
public class PaymentService {
    public String pay(Payment p) {
        PaymentProvider provider = PaymentProviderFactory.getProvider(p.provider);
        return provider.pay(p);
    }
}