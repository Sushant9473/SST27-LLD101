import com.example.orders.*;

public class TryIt {
    public static void main(String[] args) {
        OrderLine l1 = new OrderLine("A", 1, 200);
        OrderLine l2 = new OrderLine("B", 3, 100);
        Order o = new Order.Builder("o2", "a@b.com", l1)
            .addLine(l2)
            .discountPercent(10)
            .build();
        System.out.println("Total after discount: " + o.totalAfterDiscount());
        l1.setQuantity(999); // no effect on order, defensive copy
        System.out.println("After mutating l1, total: " + o.totalAfterDiscount());
        System.out.println("=> In the solution, totals remain stable due to defensive copies and immutability.");
    }
}
