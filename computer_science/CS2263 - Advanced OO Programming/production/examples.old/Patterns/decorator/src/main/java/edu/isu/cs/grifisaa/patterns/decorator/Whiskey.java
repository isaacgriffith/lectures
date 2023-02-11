package edu.isu.cs.grifisaa.patterns.decorator;

public class Whiskey extends BeverageDecorator {

    public Whiskey(Beverage bev) {
        super(bev, "Booze!!!!");
    }

    @Override
    public double cost() {
        return 3.00;
    }
}
