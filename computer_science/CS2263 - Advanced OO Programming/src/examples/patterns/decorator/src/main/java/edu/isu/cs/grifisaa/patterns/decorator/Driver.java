public class Driver {

  public static void main(String args[]) {
    Beverage b = new HouseBlend();
    System.out.println("Description: " + b.getDescription());
    System.out.println("Cost: " + b.cost());
    System.out.println();
    b = new Milk(b);
    System.out.println("Description: " + b.getDescription());
    System.out.println("Cost: " + b.cost());
    System.out.println();
    b = new Milk(b);
    System.out.println("Description: " + b.getDescription());
    System.out.println("Cost: " + b.cost());
  }
}
