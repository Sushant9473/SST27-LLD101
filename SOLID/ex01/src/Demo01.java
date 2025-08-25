

public class Demo01 {
    public static void main(String[] args) {
        OrderService orderService = new OrderService(new EmailClient());
        orderService.checkout("a@shop.com", 100.0);
    }
}
