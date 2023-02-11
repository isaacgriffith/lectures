package edu.isu.cs.grifisaa.patterns.decorator;

public class HouseBlend extends Beverage {

  public HouseBlend() {
    super("Coffee produced from scrapings of higher quality coffee grounds mixed with floor contents");
  }

  public double cost() {
    return 3.50;
  }
}
