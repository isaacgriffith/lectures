package edu.isu.cs.grifisaa.patterns.observer;

public interface Subject {
	void registerObserver(Observer o);
	void removeObserver(Observer o);
	void notifyObservers();
}
