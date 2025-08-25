public class OvernightShippingCost implements ShippingCostStrategy {
    @Override
    public double cost(Shipment shipment) {
        return 120 + 10 * shipment.weightKg;
    }
}