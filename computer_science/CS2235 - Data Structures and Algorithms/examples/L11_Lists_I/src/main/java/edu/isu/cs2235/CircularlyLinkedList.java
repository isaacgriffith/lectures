package edu.isu.cs2235l20;

public class CircularlyLinkedList extends SinglyLinkedList {

    @Override
    public void addFirst(int item) {
        super.addFirst(item);

        if (tail != null)
            tail.setNext(head);
    }

    @Override
    public void addLast(int item) {
        super.addLast(item);

        if (tail != null && tail.getNext() == null)
            tail.setNext(head);
    }

    @Override
    public int removeFirst() {
        int value = super.removeFirst();

        if (tail != null)
            tail.setNext(head);

        return value;
    }

    @Override
    public int removeLast() {
        int value = super.removeLast();

        if (tail != null)
            tail.setNext(head);

        return value;
    }
}
