package edu.isu.cs.grifisaa.patterns.template.simplebarista;

public class Barista {
 
	public static void main(String[] args) {
		Tea tea = new Tea();
		Coffee coffee = new Coffee();
		System.out.println("Making tea...");
		tea.prepareRecipe();
		System.out.println("Making coffee...");
		coffee.prepareRecipe();
	}
}
