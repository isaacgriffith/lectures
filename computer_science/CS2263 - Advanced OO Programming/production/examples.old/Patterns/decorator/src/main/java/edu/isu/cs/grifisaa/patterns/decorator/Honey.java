package edu.isu.cs.grifisaa.patterns.decorator;

public class Honey extends BeverageDecorator{

    public Honey(Beverage bev) {
        super(bev, "A little honey");
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.15;
    }
}
