package edu.isu.cs.grifisaa.patterns.decorator;

public abstract class Beverage {

  private String description;

  public Beverage(String description) {
    this.description = description;
  }

  public abstract double cost();

  public String getDescription() {
    return this.description;
  }

  public void printBeverage() {
    System.out.println("Description: " + getDescription());
    System.out.printf("Cost: %.2f\n", cost());
    System.out.println();
  }
}
