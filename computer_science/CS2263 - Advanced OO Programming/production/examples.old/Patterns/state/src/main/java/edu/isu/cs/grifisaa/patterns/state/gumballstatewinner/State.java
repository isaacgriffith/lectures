package edu.isu.cs.grifisaa.patterns.state.gumballstatewinner;

public interface State {
 
	void insertQuarter();
	void ejectQuarter();
	void turnCrank();
	void dispense();
}
