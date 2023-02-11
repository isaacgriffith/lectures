package edu.isu.cs.cs2263.patterns.iterator;

public interface Queue {

    boolean add(Object value);
    Object remove();
    Iterator iterator();
}
