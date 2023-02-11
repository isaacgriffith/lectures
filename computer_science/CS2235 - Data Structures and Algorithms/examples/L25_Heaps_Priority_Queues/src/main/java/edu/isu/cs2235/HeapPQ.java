package edu.isu.cs2235;

public class HeapPQ implements PriorityQueue {

    Heap<Integer> heap = new ArrayHeap(true);

    @Override
    public Integer poll() {
        return heap.removeTop();
    }

    @Override
    public void offer(Integer item) {
        heap.insert(item);
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public Integer peek() {
        return heap.top();
    }
}
