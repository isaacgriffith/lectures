package edu.isu.cs2235l20;

import java.util.Iterator;

public interface SortedSet<E extends Comparable> extends Set<E> {

    E first();
    E last();
    E ceiling(E element);
    E floor(E element);
    E lower(E element);
    E higher(E element);
    Iterator<E> subset(E lower, E upper);
    E pollFirst();
    E pollLast();
}
