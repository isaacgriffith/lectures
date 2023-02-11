package edu.isu.cs2235l20;

public class PostOrderTraversal<E extends Comparable> extends DepthFirstTraversal<E> {
    @Override
    public void setVisitor(Visitor<E> v) {
        visitor = v;
    }

    public PostOrderTraversal(Visitor<E> cmd) {
        super(cmd);
    }

    @Override
    public void traverse(Node<E> node) {
        if (node.getLeft() != null)
            traverse(node);
        if (node.getRight() != null)
            traverse(node);
        visitor.visit(node);
    }
}
