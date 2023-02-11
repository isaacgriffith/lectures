package edu.isu.cs2235;

public interface PriorityQueue {

    Integer poll();

    void offer(Integer item);

    int size();

    boolean isEmpty();

    Integer peek();
}
