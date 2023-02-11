public class ClamPizza extends Pizza {
  @Inject
	PizzaIngredientFactory ingredientFactory;

	public ClamPizza() {

	}

	void prepare() {
		System.out.println("Preparing " + name);
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
		clam = ingredientFactory.createClam();
	}
}
