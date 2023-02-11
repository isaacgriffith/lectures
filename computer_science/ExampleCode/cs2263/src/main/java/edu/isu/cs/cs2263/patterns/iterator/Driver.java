package edu.isu.cs.cs2263.patterns.iterator;

import java.util.LinkedList;

public class Driver {

    public static void main(String[] args) {
        Queue q = new LinkedQueue();
        java.util.Queue<Integer> q2 = new LinkedList<>();

        for (int i = 0; i < 20; i++) {
            q.add(i);
            q2.offer(i);
        }

        Iterator iter = q.iterator();
        while (iter.hasNext())
            System.out.println(iter.next());

        java.util.Iterator<Integer> iter2 = q2.iterator();
        while (iter2.hasNext())
            System.out.println(iter2.next());
    }
}
