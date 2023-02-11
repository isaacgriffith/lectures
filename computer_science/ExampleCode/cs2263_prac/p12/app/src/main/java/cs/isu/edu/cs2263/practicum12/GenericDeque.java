package cs.isu.edu.cs2263.practicum12;

import java.util.Iterator;

public interface GenericDeque<T> {
    boolean addAtTail(T value);

    T removeElementAtTail();

    T getElementAtTail();

    boolean addAtHead(T value);

    T removeElementAtHead();

    T getElementAtHead();

    int size();

    void clear();

    Iterator iterator();
}
