public abstract class BeverageDecorator extends Beverage {

  protected Beverage beverage;

  public BeverageDecorator(Beverage bev) {
    this.beverage = bev;
  }
}
