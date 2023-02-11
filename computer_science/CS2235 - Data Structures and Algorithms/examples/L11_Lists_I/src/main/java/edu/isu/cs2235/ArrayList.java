package edu.isu.cs2235l20;

import java.util.Arrays;

public class ArrayList implements List {

    int[] data;
    int tail = -1;
    int head = -1;

    public ArrayList(int size) {
        data = new int[size];
    }

    @Override
    public void addFirst(int item) {
        insert(item, 0);
    }

    @Override
    public void addLast(int item) {
        insert(item, tail + 1);
    }

    @Override
    public void insert(int item, int index) {
        if (tail + 1 > .75 * data.length) {
            expand();
        }

        shiftUp(index);
        data[index] = item;

        if (head < 0)
            head = 0;
    }

    @Override
    public int removeFirst() {
        return remove(head);
    }

    @Override
    public int removeLast() {
        return remove(tail);
    }

    @Override
    public int remove(int index) {
        if (index > tail || index < 0)
            throw new IllegalArgumentException();

        int item = data[index];

        shiftDown(index + 1);
        if (tail < .25 * data.length) {
            contract();
        }
        if (tail < 0)
            head = tail;

        return item;
    }

    @Override
    public int get(int index) {
        if (index > tail || index < 0)
            throw new IllegalArgumentException();

        return data[index];
    }

    @Override
    public int first() {
        return data[head];
    }

    @Override
    public int last() {
        return data[tail];
    }

    @Override
    public int size() {
        return tail + 1;
    }

    @Override
    public boolean isEmpty() {
        return head == -1;
    }

    private void expand() {
        data = Arrays.copyOf(data, data.length * 2);
    }

    private void contract() {
        data = Arrays.copyOfRange(data, 0, data.length / 2);
    }

    private void shiftUp(int start) {
        for (int i = tail; i >= start; i--) {
            data[i + 1] = data[i];
        }
        tail += 1;
    }

    private void shiftDown(int start) {
        for (int i = start; i <= tail; i++) {
            data[i - 1] = i;
        }

        tail -= 1;
    }
}
