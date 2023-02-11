package edu.isu.cs2235l20;

public interface Visitor<E extends Comparable> {

    void visit(Node<E> node);
}
