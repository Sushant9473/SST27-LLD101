import java.util.HashMap;
import java.util.Map;

public class ShippingCostStrategyFactory {
    private static final Map<String, ShippingCostStrategy> strategies = new HashMap<>();
    static {
        strategies.put("STANDARD", new StandardShippingCost());
        strategies.put("EXPRESS", new ExpressShippingCost());
        strategies.put("OVERNIGHT", new OvernightShippingCost());
    }
    public static ShippingCostStrategy getStrategy(String type) {
        ShippingCostStrategy strategy = strategies.get(type);
        if (strategy == null) throw new IllegalArgumentException("Unknown type: " + type);
        return strategy;
    }
}