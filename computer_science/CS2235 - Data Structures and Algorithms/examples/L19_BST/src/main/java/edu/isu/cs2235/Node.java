package edu.isu.cs2235l20;

public class Node<E extends Comparable> {

    private E value;
    private Node<E> left;
    private Node<E> right;
    private Node<E> parent;

    public Node(E value) {
        this.value = value;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node getLeft() {
        return left;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

    public Node getRight() {
        return right;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getParent() {
        return parent;
    }
}
