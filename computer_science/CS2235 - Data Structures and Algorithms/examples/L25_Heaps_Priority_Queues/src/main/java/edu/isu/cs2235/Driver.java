package edu.isu.cs2235;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Driver {

    public static void main(String[] args) {
        PriorityQueue pq = new HeapPQ();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            list.add(i);
        }
        Collections.shuffle(list);

        for (Integer i : list) {
            pq.offer(i);
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}