package edu.isu.cs2235l20;

public class InsertionSort implements ArraySort {

    @Override
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            insert(array, i, array[i]);
        }
    }

    private void insert(int[] array, int position, int value) {
        int i = position - 1;
        while (i >= 0 && array[i] > value) {
            array[i + 1] = array[i];
            i--;
        }

        array[i + 1] = value;
    }
}
