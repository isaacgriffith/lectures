package edu.isu.cs2235l20;

public class SelectionSort implements ArraySort {

    @Override
    public void sort(int[] array) {
        for (int first = 0; first < array.length; first++) {
            int min = first + 1;
            for (int i = min; i < array.length; i++) {
                if (array[i] < array[min])
                    min = i;
            }

            swap(array, first, min);
        }
    }

    private void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
