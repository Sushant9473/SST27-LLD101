public class ExpressShippingCost implements ShippingCostStrategy {
    @Override
    public double cost(Shipment shipment) {
        return 80 + 8 * shipment.weightKg;
    }
}