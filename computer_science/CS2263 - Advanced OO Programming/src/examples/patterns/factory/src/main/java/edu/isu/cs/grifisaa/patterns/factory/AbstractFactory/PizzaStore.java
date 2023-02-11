public abstract class PizzaStore {

  protected Pizza pizza;
  protected PizzaIngredientFactory ingredientFactory

  public PizzaStore(PizzaIngredientFactory ingredientFactory) {
    this.ingredientFactory = ingredientFactory;
  }

	protected abstract Pizza createPizza(String item);

	public Pizza orderPizza(String type) {
		Pizza pizza = createPizza(type);
		System.out.println("--- Making a " + pizza.getName() + " ---");
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}
