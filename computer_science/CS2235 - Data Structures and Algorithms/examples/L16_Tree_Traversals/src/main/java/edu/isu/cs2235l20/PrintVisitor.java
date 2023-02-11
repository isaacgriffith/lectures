package edu.isu.cs2235l20;

public class PrintVisitor<E extends Comparable> implements Visitor<E> {

    @Override
    public void visit(Node<E> node) {
        System.out.println(node.getElement());
    }
}
