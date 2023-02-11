package edu.isu.cs.grifisaa.patterns.decorator;

public abstract class BeverageDecorator extends Beverage {

  protected Beverage beverage;

  public BeverageDecorator(Beverage bev, String description) {
    super(description);
    this.beverage = bev;
  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + "\n" + super.getDescription();
  }
}
