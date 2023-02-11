package edu.isu.cs2235l20;

import java.util.Iterator;

public interface MultiSet<E extends Comparable> {

    void add(E element);
    boolean contains(E element);
    int count(E element);
    void remove(E element);
    void remove(E element, int n);
    int size();
    Iterator<E> iterator();
}
