package edu.isu.cs.grifisaa.patterns.singleton;

public interface ChocolateBoiler {

    void fill();

    void drain();

    void boil();

    boolean isEmpty();

    boolean isBoiled();
}
