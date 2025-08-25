public class ShippingCostCalculator {
    public double cost(Shipment s) {
        ShippingCostStrategy strategy = ShippingCostStrategyFactory.getStrategy(s.type);
        return strategy.cost(s);
    }
}
