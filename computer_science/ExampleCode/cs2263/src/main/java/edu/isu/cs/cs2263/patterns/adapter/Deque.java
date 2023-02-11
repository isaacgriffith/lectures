package edu.isu.cs.cs2263.patterns.adapter;

import java.util.Iterator;

public interface Deque<E> {

    boolean addAtTail(E value);
    E removeAtTail();
    E getTail();
    boolean addAtHead(E value);
    E removeAtHead();
    E getHead();
    int size();
    void clear();
    Iterator<E> iterator();
}
