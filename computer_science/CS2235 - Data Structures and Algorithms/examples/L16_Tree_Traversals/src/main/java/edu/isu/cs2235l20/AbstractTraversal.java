package edu.isu.cs2235l20;

public abstract class AbstractTraversal<E extends Comparable> implements TreeTraversal<E> {

    protected Visitor<E> visitor;

    public AbstractTraversal(Visitor<E> v) {
        visitor = v;
    }
}
