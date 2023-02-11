package edu.isu.cs2235l20;

public interface TreeTraversal<E extends Comparable> {

    void traverse(Node<E> node);

    void setVisitor(Visitor<E> v);
}
