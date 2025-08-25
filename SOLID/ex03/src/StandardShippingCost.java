public class StandardShippingCost implements ShippingCostStrategy {
    @Override
    public double cost(Shipment shipment) {
        return 50 + 5 * shipment.weightKg;
    }
}