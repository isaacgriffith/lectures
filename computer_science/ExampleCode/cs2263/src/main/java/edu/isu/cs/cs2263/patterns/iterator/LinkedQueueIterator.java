package edu.isu.cs.cs2263.patterns.iterator;

public class LinkedQueueIterator implements Iterator {

    Node cursor;

    public LinkedQueueIterator(Node cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean hasNext() {
        return cursor != null;
    }

    @Override
    public Object next() {
        Object value = cursor.getData();
        cursor = cursor.getNext();
        return value;
    }
}
