public class PizzaTestDrive {

	public static void main(String[] args) {
		PizzaStore store = new NYPizzaStore();

		Pizza pizza = store.orderPizza("cheese");
		System.out.println("Ethan ordered a " + pizza.getName() + "\n");

		pizza = store.orderPizza("cheese");
		System.out.println("Joel ordered a " + pizza.getName() + "\n");

		pizza = store.orderPizza("clam");
		System.out.println("Ethan ordered a " + pizza.getName() + "\n");

    store = new ChicagoPizzaStore();
		pizza = store.orderPizza("clam");
		System.out.println("Joel ordered a " + pizza.getName() + "\n");

		pizza = store.orderPizza("pepperoni");
		System.out.println("Ethan ordered a " + pizza.getName() + "\n");

		pizza = store.orderPizza("pepperoni");
		System.out.println("Joel ordered a " + pizza.getName() + "\n");

		pizza = store.orderPizza("veggie");
		System.out.println("Ethan ordered a " + pizza.getName() + "\n");

		pizza = store.orderPizza("veggie");
		System.out.println("Joel ordered a " + pizza.getName() + "\n");
	}
}
