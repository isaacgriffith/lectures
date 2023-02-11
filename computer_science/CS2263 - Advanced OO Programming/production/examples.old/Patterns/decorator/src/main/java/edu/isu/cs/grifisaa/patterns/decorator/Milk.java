package edu.isu.cs.grifisaa.patterns.decorator;

public class Milk extends BeverageDecorator {

    public Milk(Beverage bev) {
        super(bev, "And some milk.");
    }

    public double cost() {
        return beverage.cost() + .35;
    }
}
