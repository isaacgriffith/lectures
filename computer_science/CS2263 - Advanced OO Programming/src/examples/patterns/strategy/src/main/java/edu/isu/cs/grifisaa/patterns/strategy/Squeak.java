package edu.isu.cs.grifisaa.patterns.strategy;

public class Squeak implements QuackBehavior {
	public void quack() {
		System.out.println("Squeak");
	}
}
