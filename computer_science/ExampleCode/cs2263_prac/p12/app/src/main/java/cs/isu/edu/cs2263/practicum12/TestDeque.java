package cs.isu.edu.cs2263.practicum12;

import java.util.Iterator;
import java.util.LinkedList;

public class TestDeque implements Deque {

    LinkedList list;
    public TestDeque() {
        list = new LinkedList();
    }

    @Override
    public void addAtTail(Object value) {
        list.add(value);
    }

    @Override
    public Object removeElementAtTail() {
        return list.removeLast();
    }

    @Override
    public Object getElementAtTail() {
        return list.getLast();
    }

    @Override
    public void addAtHead(Object value) {
        list.addFirst(value);
    }

    @Override
    public Object removeElementAtHead() {
        return list.removeFirst();
    }

    @Override
    public Object getElementAtHead() {
        return list.getFirst();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public Iterator iterator() {
        return list.iterator();
    }
}
