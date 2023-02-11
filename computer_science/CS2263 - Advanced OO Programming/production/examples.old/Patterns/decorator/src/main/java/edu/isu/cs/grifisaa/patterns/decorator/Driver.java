package edu.isu.cs.grifisaa.patterns.decorator;

public class Driver {

  public static void main(String args[]) {
    Beverage b = new HouseBlend();
    b.printBeverage();
    b = new Milk(b);
    b.printBeverage();
    b = new Milk(b);
    b.printBeverage();
    b = teaHoneyMilk();
    b.printBeverage();
    b = hotToddy();
    b.printBeverage();
    b = irishCoffee(b);
  }

  private static Beverage irishCoffee(Beverage b) {
    return new Whiskey(new HouseBlend());
  }



  public static Beverage teaHoneyMilk() {
    return new Milk(new Honey(new Tea()));
  }

  public static Beverage hotToddy() {
    return new CinnamonStick(new Lemon(new Whiskey(new Tea())));
  }
}
