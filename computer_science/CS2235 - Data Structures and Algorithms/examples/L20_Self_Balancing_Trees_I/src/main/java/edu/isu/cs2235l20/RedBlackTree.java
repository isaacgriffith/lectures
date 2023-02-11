package edu.isu.cs2235l20;

public class RedBlackTree<E extends Comparable> extends BalanceableBinaryTree<E> {

    public RedBlackTree() {
    }

    private boolean isBlack(Node<E> p) {
        return getAux(p) == 0;
    }

    private boolean isRed(Node<E> p) {
        return getAux(p) == 1;
    }

    private void makeBlack(Node<E> p) {
        setAux(p, 0);
    }

    private void makeRed(Node<E> p) {
        setAux(p, 1);
    }

    private void setColor(Node<E> p, boolean toRed) {
        setAux(p, toRed ? 1 : 0);
    }

    protected void rebalanceInsert(Node<E> p) {
        if (!isRoot(p)) {
            makeRed(p);
            resolveRed(p);
        }
    }

    private void resolveRed(Node<E> p) {
        Node<E> parent, uncle, middle, grand;

        parent = parent(p);
        if (isRed(parent)) {
            uncle = sibling(parent);
            if (isBlack(uncle)) {
                middle = restructure(p);
                makeBlack(middle);
                makeRed(left(middle));
                makeRed(right(middle));
            } else {
                makeBlack(parent);
                makeBlack(uncle);
                grand = parent(parent);
                if (!isRoot(grand)) {
                    makeRed(grand);
                    resolveRed(grand);
                }
            }
        }
    }

    protected void rebalanceDelete(Node<E> p) {
        if (isRed(p))
            makeBlack(p);
        else if (!isRoot(p)) {
            Node<E> sib = sibling(p);
            if (isInternal(sib) && isBlack(sib) || isInternal(left(sib)))
                remedyDoubleBlack(p);
        }
    }

    private void remedyDoubleBlack(Node<E> p) {
        Node<E> z = parent(p);
        Node<E> y = sibling(p);
        if (isBlack(y)) {
            if (isRed(left(y)) || isRed(right(y))) {
                Node<E> x = (isRed(left(y)) ? left(y) : right(y));
                Node<E> middle = restructure(x);
                setColor(middle, isRed(z));
                makeBlack(left(middle));
                makeBlack(right(middle));
            } else {
                makeRed(y);
                if (isRed(z))
                    makeBlack(z);
                else if (!isRoot(z))
                    remedyDoubleBlack(z);
            }
        } else {
            rotate(y);
            makeBlack(y);
            makeRed(z);
            remedyDoubleBlack(p);
        }
    }

}
