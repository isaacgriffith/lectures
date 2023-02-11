package edu.isu.cs2235l20;

public class AVLTree<E extends Comparable> extends BalanceableBinaryTree<E> {

    @Override
    public int height(Node<E> p) {
        return getAux(p);
    }

    protected void recomputeHeight(Node<E> p) {
        setAux(p, 1 + Math.max(height(left(p)), height(right(p))));
    }

    protected boolean isBalanced(Node<E> p) {
        return Math.abs(height(left(p)) - height(right(p))) <= 1;
    }

    protected Node<E> tallerChild(Node<E> p) {
        if (height(left(p)) > height(right(p))) return left(p);
        if (height(left(p)) < height(right(p))) return right(p);

        if (isRoot(p)) return left(p);
        if (p == left(parent(p))) return left(p);
        else return right(p);
    }

    protected void rebalance(Node<E> p) {
        int oldHeight, newHeight;

        do {
            oldHeight = height(p);
            if (!isBalanced(p)) {
                p = restructure(tallerChild(tallerChild(p)));
                recomputeHeight(left(p));
                recomputeHeight(right(p));
            }
            recomputeHeight(p);
            newHeight = height(p);
            p = parent(p);
        } while (oldHeight != newHeight && p != null);
    }

    protected void rebalanceInsert(Node<E> p) {
        rebalance(p);
    }

    protected void rebalanceDelete(Node<E> p) {
        if (!isRoot(p))
            rebalance(parent(p));
    }
}
