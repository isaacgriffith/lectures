package edu.isu.cs2235l20;

import java.util.Iterator;

public interface Tree<E extends Comparable> extends Iterable<E> {

    Node<E> root();
    Node<E> parent(Node<E> p);
    Iterable<Node<E>> children(Node<E> p);
    int numChildren(Node<E> p);
    boolean isInternal(Node<E> p);
    boolean isExternal(Node<E> p);
    boolean isRoot(Node<E> p);
    int size();
    boolean isEmpty();
    Iterator<E> iterator();
    Iterable<Node<E>> positions();
}
