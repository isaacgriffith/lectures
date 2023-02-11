package edu.isu.cs.grifisaa.patterns.strategy;

public class FlyNoWay implements FlyBehavior {
	public void fly() {
		System.out.println("I can't fly");
	}
}
