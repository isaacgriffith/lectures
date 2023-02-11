package edu.isu.cs2235l20;

public class SinglyLinkedList implements List {

    protected Node head;
    protected Node tail;
    private int size = 0;

    @Override
    public void addFirst(int item) {
        Node temp = new Node(item);
        temp.setNext(head);
        head = temp;
        size++;

        if (size == 1)
            tail = head;
    }

    @Override
    public void addLast(int item) {
        Node temp = new Node(item);
        tail.setNext(temp);
        tail = temp;
        size++;

        if (size == 1)
            head = tail;
    }

    @Override
    public void insert(int item, int index) {
        if (index >= size || index < 0)
            throw new IllegalArgumentException();

        Node curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.getNext();
        }

        Node temp = new Node(item);
        temp.setNext(curr.getNext());
        curr.setNext(temp);
    }

    @Override
    public int removeFirst() {
        int value = head.getData();
        Node temp = head.getNext();
        head.setNext(null);
        head = temp;
        size--;

        if (size == 0)
            tail = null;

        return value;
    }

    @Override
    public int removeLast() {
        return remove(size - 1);
    }

    @Override
    public int remove(int index) {
        if (index == -1 || index >= size)
            throw new IllegalArgumentException();

        Node curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.getNext();
        }
        Node temp = curr.getNext();
        curr.setNext(null);
        tail = curr;
        size--;

        if (size == 0)
            head = null;

        return temp.getData();
    }

    @Override
    public int get(int index) {
        if (index >= size || index < 0)
            throw new IllegalArgumentException();

        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.getNext();
        }

        return curr.getData();
    }

    @Override
    public int first() {
        if (head == null)
            throw new IllegalArgumentException();

        return head.getData();
    }

    @Override
    public int last() {
        if (tail == null)
            throw new IllegalArgumentException();

        return tail.getData();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size > 0;
    }
}
