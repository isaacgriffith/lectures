package edu.isu.cs.cs2263.patterns.adapter;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DequeImpl<E> implements Deque<E> {

    private List<E> data = new LinkedList<>();

    @Override
    public boolean addAtTail(E value) {
        return data.add(value);
    }

    @Override
    public E removeAtTail() {
        return data.remove(data.size() - 1);
    }

    @Override
    public E getTail() {
        return data.get(data.size() - 1);
    }

    @Override
    public boolean addAtHead(E value) {
        data.add(0, value);
        return true;
    }

    @Override
    public E removeAtHead() {
        return data.remove(0);
    }

    @Override
    public E getHead() {
        return data.get(0);
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public void clear() {
        data.clear();
    }

    @Override
    public Iterator<E> iterator() {
        return data.iterator();
    }
}
