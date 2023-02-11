package edu.isu.cs.grifisaa.patterns.singleton;

public class Demo {

    public static void main(String args[]) {
        ChocolateBoiler boiler = ChocolateBoilerLazyInit.getInstance();

        boiler.fill();
        boiler.boil();
        boiler.drain();

        ChocolateBoiler boiler2 = ChocolateBoilerLazyInit.getInstance();

        boiler2.fill();
        System.out.println("Is boiler empty? " + boiler.isEmpty());
    }
}
