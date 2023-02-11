package edu.isu.cs2235l20;

public abstract class AbstractTree<E extends Comparable> implements Tree<E> {

    TreeTraversal<E> traverse;

    public boolean isInternal(Node<E> p) {
        return numChildren(p) > 0;
    }

    public boolean isExternal(Node<E> p) {
        return numChildren(p) == 0;
    }

    public boolean isRoot(Node<E> p) {
        return p == root();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int depth(Node<E> n) {
        if (isRoot(n))
            return 0;
        else
            return 1 + depth(parent(n));
    }

    public int height(Node<E> n) {
        int h = 0;
        for (Node<E> c : children(n)) {
            h = Math.max(h, 1 + height(c));
        }

        return h;
    }

    public void traverse(Visitor<E> v) {
        traverse.setVisitor(v);
        traverse.traverse(root());
    }

    public TreeTraversal<E> getTraverse() {
        return traverse;
    }

    public void setTraverse(TreeTraversal<E> traverse) {
        this.traverse = traverse;
    }
}
