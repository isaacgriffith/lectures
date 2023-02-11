package edu.isu.cs.grifisaa.patterns.iterator.dinermergercafe;

import java.util.Iterator;

public interface Menu {
	public Iterator<MenuItem> createIterator();
}
