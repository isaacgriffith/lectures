package edu.isu.cs.cs2263.patterns.iterator;

public class LinkedQueue implements Queue {

    private int numElements;
    private Node head;
    private Node tail;

    @Override
    public boolean add(Object value) {
        if (value == null)
            return false;

        if (head == null)
            head = tail = new Node(value);
        else {
            Node next = new Node(value);
            tail.setNext(next);
            tail = next;
        }

        numElements++;

        return true;
    }

    @Override
    public Object remove() {
        if (head != null) {
            Object val = head.getData();
            head = head.getNext();

            numElements--;

            return val;
        }

        return null;
    }

    @Override
    public Iterator iterator() {
        return new LinkedQueueIterator(head);
    }
}
