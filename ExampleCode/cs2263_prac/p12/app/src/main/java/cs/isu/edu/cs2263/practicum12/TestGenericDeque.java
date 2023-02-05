package cs.isu.edu.cs2263.practicum12;

import java.util.Iterator;
import java.util.LinkedList;

public class TestGenericDeque<T> implements GenericDeque<T> {

    LinkedList<T> list;
    public TestGenericDeque() {
        list = new LinkedList<>();
    }

    @Override
    public boolean addAtTail(T value) {
        return list.add(value);
    }

    @Override
    public T removeElementAtTail() {
        return list.removeLast();
    }

    @Override
    public T getElementAtTail() {
        return list.getLast();
    }

    @Override
    public boolean addAtHead(T value) {
        list.addFirst(value);
        return true;
    }

    @Override
    public T removeElementAtHead() {
        return list.removeFirst();
    }

    @Override
    public T getElementAtHead() {
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
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
