package edu.isu.cs.grifisaa.patterns.state.gumballstate;

public interface State {

	void insertQuarter();
	void ejectQuarter();
	void turnCrank();
	void dispense();
}
