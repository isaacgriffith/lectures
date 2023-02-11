package edu.isu.cs2235l20;

public interface List {

    void addFirst(int item);
    void addLast(int item);
    void insert(int item, int index);
    int removeFirst();
    int removeLast();
    int remove(int index);
    int get(int index);
    int first();
    int last();
    int size();
    boolean isEmpty();
}
