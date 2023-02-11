package edu.isu.cs.cs2263.patterns.adapter;

import java.util.Iterator;

public class Driver {

    public static void main(String[] args) {
        Deque<Integer> i = new DequeImpl<>();

        i.addAtHead(0);
        i.addAtHead(1);
        i.addAtTail(2);
        i.addAtHead(3);
        i.addAtTail(4);

        Iterator<Integer> iter = i.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
