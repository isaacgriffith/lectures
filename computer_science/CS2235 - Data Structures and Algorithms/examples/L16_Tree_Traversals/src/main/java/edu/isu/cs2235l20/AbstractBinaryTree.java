package edu.isu.cs2235l20;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinaryTree<E extends Comparable> extends AbstractTree<E> implements BinaryTree<E> {

    public Node<E> sibling(Node<E> p) {
        Node<E> parent = parent(p);
        if (parent == null)
            return null;
        if (p == left(parent))
            return right(parent);
        else
            return left(parent);
    }

    public int numChildren(Node<E> p) {
        int count = 0;
        if (left(p) != null)
            count++;
        if (right(p) != null)
            count++;
        return count;
    }

    public Iterable<Node<E>> children(Node<E> p) {
        List<Node<E>> snapshot = new ArrayList<>(2);
        if (left(p) != null)
            snapshot.add(left(p));
        if (right(p) != null)
            snapshot.add(right(p));
        return snapshot;
    }
}
