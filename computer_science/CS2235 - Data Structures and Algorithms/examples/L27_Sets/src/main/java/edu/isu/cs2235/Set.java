package edu.isu.cs2235l20;

public interface Set<E> extends Iterable {

    void add(E element);
    void remove(E element);
    boolean contains(E element);
    void addAll(Set<E> s);
    void retainAll(Set<E> s);
    void removeAll(Set<E> s);
}
