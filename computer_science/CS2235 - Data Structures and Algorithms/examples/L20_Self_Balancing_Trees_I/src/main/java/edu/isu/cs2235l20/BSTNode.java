package edu.isu.cs2235l20;

public class BSTNode<E extends Comparable> extends Node<E> {

    int aux = 0;

    public BSTNode(E element) {
        super(element);
    }

    public int getAux() {
        return aux;
    }

    public void setAux(int aux) {
        this.aux = aux;
    }
}
