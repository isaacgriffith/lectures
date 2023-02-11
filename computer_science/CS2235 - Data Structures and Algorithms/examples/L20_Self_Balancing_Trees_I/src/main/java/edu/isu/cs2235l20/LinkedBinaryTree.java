package edu.isu.cs2235l20;

import java.util.Iterator;

public class LinkedBinaryTree<E extends Comparable> extends AbstractBinaryTree<E> {

    Node<E> root;
    private int size = 0;

    public LinkedBinaryTree() {
    }

    public int size() {
        return size;
    }

    protected Node<E> validate(Node<E> n) throws IllegalArgumentException {
        if (n.getParent() == n)
            throw new IllegalArgumentException("n is no longer in the tree");
        return n;
    }

    public Node<E> root() {
        return root;
    }

    public Node<E> parent(Node<E> n) {
        Node<E> node = validate(n);
        return node.getParent();
    }

    public Node<E> left(Node<E> n) {
        Node<E> node = validate(n);
        return node.getLeft();
    }

    public Node<E> right(Node<E> n) {
        Node<E> node = validate(n);
        return node.getRight();
    }

    public Node<E> addRoot(E element) {
        if (!isEmpty()) throw new IllegalStateException("Tree is not empty");
        root = createNode(element);
        size = 1;
        return root;
    }

    public Node<E> addLeft(Node<E> p, E element) {
        Node<E> parent = validate(p);
        if (parent.getLeft() != null) {
            throw new IllegalArgumentException("p already has a left child");
        }

        Node<E> child = createNode(element);
        child.setParent(parent);
        parent.setLeft(child);
        size++;
        return child;
    }

    public Node<E> addRight(Node<E> p, E element) {
        Node<E> parent = validate(p);
        if (parent.getRight() != null) {
            throw new IllegalArgumentException("p already has a right child");
        }

        Node<E> child = createNode(element);
        child.setParent(parent);
        parent.setRight(child);
        size++;
        return child;
    }

    public E set(Node<E> n, E e) {
        Node<E> node = validate(n);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    public void attach(Node<E> n, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) {
        Node<E> node = validate(n);

        if (isInternal(n)) throw new IllegalArgumentException("n must be a leaf");

        size += t1.size() + t2.size();
        if (!t1.isEmpty()) {
            t1.root.setParent(node);
            node.setLeft(t1.root);
            t1.root = null;
            t1.size = 0;
        }

        if (!t2.isEmpty()) {
            t2.root.setParent(node);
            node.setRight(t2.root);
            t2.root = null;
            t2.size = 0;
        }
    }

    public E remove(Node<E> n) {
        Node<E> node = validate(n);
        if (numChildren(n) == 2) {
            throw new IllegalArgumentException("n has two children");
        }
        Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
        if (child != null)
            child.setParent(node.getParent());
        if (node == root)
            root = child;
        else {
            Node<E> parent = node.getParent();
            if (node == parent.getLeft())
                parent.setLeft(child);
            else
                parent.setRight(child);
        }
        size--;
        E temp = node.getElement();
        node.setElement(null);
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node);
        return temp;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Iterable<Node<E>> positions() {
        return null;
    }

    protected Node<E> createNode(E element) {
        return new Node<>(element);
    }
}
