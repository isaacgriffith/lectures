package edu.isu.cs2235l20;

public class BalanceableBinaryTree<E extends Comparable> extends LinkedBinaryTree<E> {

    public int getAux(Node<E> p) {
        return ((BSTNode<E>) p).getAux();
    }

    public void setAux(Node<E> p, int value) {
        ((BSTNode<E>) p).setAux(value);
    }

    public Node<E> createNode(E element) {
        return new BSTNode<>(element);
    }

    private void relink(Node<E> parent, Node<E> child, boolean makeLeft) {
        child.setParent(parent);
        if (makeLeft) {
            parent.setLeft(child);
        } else {
            parent.setRight(child);
        }
    }

    public void rotate(Node<E> n) {
        Node<E> x = validate(n);
        Node<E> y = x.getParent();
        Node<E> z = y.getParent();

        if (z == null) {
            root = x;
            x.setParent(null);
        } else {
            relink(z, x, y == z.getLeft());
        }

        if (x == y.getLeft()) {
            relink(y, x.getRight(), true);
            relink(x, y, false);
        } else {
            relink(y, x.getLeft(), false);
            relink(x, y, true);
        }
    }

    public Node<E> restructure(Node<E> x) {
        Node<E> y = parent(x);
        Node<E> z = parent(y);

        if ((x == right(y)) == (y == right(z))) {
            rotate(y);
            return y;
        } else {
            rotate(x);
            rotate(x);
            return x;
        }
    }

}
