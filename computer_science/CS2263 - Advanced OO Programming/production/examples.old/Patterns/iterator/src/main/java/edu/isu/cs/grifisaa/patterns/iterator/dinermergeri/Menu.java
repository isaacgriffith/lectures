package edu.isu.cs.grifisaa.patterns.iterator.dinermergeri;

import java.util.Iterator;

public interface Menu {
	public Iterator<MenuItem> createIterator();
}
