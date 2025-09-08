package beverages_decorator;

public class Client {

	public static void main(String[] args) {
		

		
		Beverage coffee = new Cappuccino();
        System.out.println("Coffee");
		System.out.println(coffee.cost());

		// Decorate with Milk
		Beverage milkCoffee = new MilkDecorator(coffee);
		System.out.println("Coffee with Milk");
		System.out.println(milkCoffee.cost());

		// Decorate with Sugar
		Beverage sugarMilkCoffee = new SugarDecorator(milkCoffee);
		System.out.println("Coffee with Milk and Sugar");
		System.out.println(sugarMilkCoffee.cost());

	}

}