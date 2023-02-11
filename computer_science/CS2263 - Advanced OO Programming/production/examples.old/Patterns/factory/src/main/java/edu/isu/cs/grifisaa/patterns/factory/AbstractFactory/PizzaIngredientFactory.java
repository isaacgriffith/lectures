package edu.isu.cs.grifisaa.patterns.factory.AbstractFactory;

public interface PizzaIngredientFactory {
 
    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Veggies[] createVeggies();
    public Pepperoni createPepperoni();
    public Clams createClam();
 
}
