package edu.isu.cs2235l20;

public abstract class DepthFirstTraversal<E extends Comparable> extends AbstractTraversal<E> {

    public DepthFirstTraversal(Visitor<E> cmd) {
        super(cmd);
    }
}
