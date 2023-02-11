public class Milk extends BeverageDecorator {

  public Milk(Beverage bev) {
    super(bev);
  }

  public double cost() {
    return beverage.cost() + .35;
  }

  public String getDescription() {
    return beverage.getDescription() + "\n" + "And some milk.";
  }
}
