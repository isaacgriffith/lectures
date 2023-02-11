package edu.isu.cs2235;

public interface Heap<E extends Comparable<E>> {

    E top();

    E removeTop();

    void insert(E item);

    int size();

    boolean isEmpty();

}
