import java.util.HashMap;
import java.util.Map;

public class PaymentProviderFactory {
    private static final Map<String, PaymentProvider> providers = new HashMap<>();
    static {
        providers.put("CARD", new CardPaymentProvider());
        providers.put("UPI", new UpiPaymentProvider());
        providers.put("WALLET", new WalletPaymentProvider());
    }
    public static PaymentProvider getProvider(String name) {
        PaymentProvider provider = providers.get(name);
        if (provider == null) throw new RuntimeException("No provider");
        return provider;
    }
}