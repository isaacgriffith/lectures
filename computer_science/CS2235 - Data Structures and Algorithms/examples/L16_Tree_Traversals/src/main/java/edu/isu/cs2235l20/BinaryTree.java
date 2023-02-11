package edu.isu.cs2235l20;

public interface BinaryTree<E extends Comparable> {

    Node<E> left(Node<E> p);
    Node<E> right(Node<E> p);
    Node<E> sibling(Node<E> p);
}
