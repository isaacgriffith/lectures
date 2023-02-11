package edu.isu.cs.grifisaa.patterns.decorator;

public class Lemon extends BeverageDecorator {

    public Lemon(Beverage bev) {
        super(bev, "A little lemon");
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.15;
    }
}
