package edu.isu.cs.grifisaa.patterns.decorator;

public class Tea extends Beverage {

    public Tea() {
        super("Earl Grey, Picard's Favorite!");
    }

    @Override
    public double cost() {
        return 7.50;
    }
}
