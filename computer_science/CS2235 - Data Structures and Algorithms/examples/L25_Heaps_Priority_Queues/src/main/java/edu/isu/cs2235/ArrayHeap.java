package edu.isu.cs2235;

import java.util.Arrays;

public class ArrayHeap implements Heap<Integer> {

    private static final int MIN_SIZE = 10;
    private int[] array;
    private int last;
    private boolean max;

    public ArrayHeap(boolean max) {
        last = -1;
        this.max = max;
        array = new int[100];
        Arrays.fill(array, -1);
    }

    @Override
    public Integer top() {
        return array[0];
    }

    @Override
    public Integer removeTop() {
        swap(0, last);
        int toReturn = array[last];
        array[last] = -1;
        last -= 1;

        bubbleDown(0);
        if (last <= .25 * array.length)
            reduceSize();

        return toReturn;
    }

    @Override
    public void insert(Integer item) {
        last += 1;
        array[last] = item;

        bubbleUp(last);
        if (last >= .75 * array.length)
            increaseSize();
    }

    private void bubbleDown(int index) {
        if (hasLeft(index)) {
            int left = getLeftChildIndex(index);
            int smallest = left;
            if (hasRight(index)) {
                int right = getRightChildIndex(index);
                if (max) {
                    if (array[left] < array[right])
                        smallest = right;
                } else {
                    if (array[left] > array[right])
                        smallest = right;
                }
            }
            if (max) {
                if (array[index] >= array[smallest])
                    return;
            } else {
                if (array[index] <= array[smallest])
                    return;
            }
            swap(index, smallest);
            bubbleDown(smallest);
        }
    }

    private boolean hasLeft(int index) {
        if (getLeftChildIndex(index) > last || getLeftChildIndex(index) > array.length)
            return false;
        return array[getLeftChildIndex(index)] != -1;
    }

    private boolean hasRight(int index) {
        if (getRightChildIndex(index) > last || getRightChildIndex(index) > array.length)
            return false;
        return array[getRightChildIndex(index)] != -1;
    }

    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    private void bubbleUp(int index) {
        if (index > 0) {
            int parent = getParentIndex(index);
            if (max) {
                if (array[index] <= array[parent])
                    return;
            } else {
                if (array[index] >= array[parent])
                    return;
            }
            swap(index, parent);
            bubbleUp(parent);
        }
    }

    private void swap(int index, int other) {
        int temp = array[index];
        array[index] = array[other];
        array[other] = temp;
    }

    private int getParentIndex(int i) {
        if (i % 2 == 0) {
            return i / 2 - 1;
        }
        return i / 2;
    }

    @Override
    public int size() {
        return last + 1;
    }

    @Override
    public boolean isEmpty() {
        return array[0] == -1;
    }

    private void reduceSize() {
        if (array.length <= MIN_SIZE)
            return;

        int[] temp = new int[array.length / 2];
        Arrays.fill(temp, -1);
        for (int i = 0; i <= last; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    private void increaseSize() {
        int[] temp = new int[array.length * 2];
        Arrays.fill(temp, -1);
        for (int i = 0; i <= last; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }
}
