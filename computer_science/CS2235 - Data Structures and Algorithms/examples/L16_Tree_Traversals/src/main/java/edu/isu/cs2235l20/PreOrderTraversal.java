package edu.isu.cs2235l20;

public class PreOrderTraversal<E extends Comparable> extends DepthFirstTraversal<E> {

    public PreOrderTraversal(Visitor<E> cmd) {
        super(cmd);
    }

    @Override
    public void traverse(Node<E> node) {
        visitor.visit(node);
        if (node.getLeft() != null)
            traverse(node);
        if (node.getRight() != null)
            traverse(node);
    }

    @Override
    public void setVisitor(Visitor<E> v) {
        visitor = v;
    }
}
