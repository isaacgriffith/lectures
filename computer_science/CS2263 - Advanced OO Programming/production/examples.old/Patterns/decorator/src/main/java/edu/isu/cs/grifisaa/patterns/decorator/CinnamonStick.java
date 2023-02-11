package edu.isu.cs.grifisaa.patterns.decorator;

public class CinnamonStick extends BeverageDecorator {

    public CinnamonStick(Beverage bev) {
        super(bev, "Cinnamon for sweet");
    }

    @Override
    public double cost() {
        return beverage.cost() + .25;
    }
}
