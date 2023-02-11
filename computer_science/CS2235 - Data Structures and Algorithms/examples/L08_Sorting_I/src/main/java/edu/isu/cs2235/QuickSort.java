package edu.isu.cs2235l20;

public class QuickSort implements ArraySort {

    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pi = partition(array, left, right);
            quickSort(array, left, pi - 1);
            quickSort(array, pi + 1, right);
        }
    }

    private int partition(int[] array, int left, int right) {
        int pivot = array[left];

        int i = left + 1;
        int j = right;

        while (i <= j) {
            if (array[i] > pivot && array[j] <= pivot) {
                swap(array, i, j);
                i += 1;
                j -= 1;
            }
            else {
                if (array[i] <= pivot) {
                    i += 1;
                }
                if (array[j] > pivot) {
                    j -= 1;
                }
            }
        }

        swap(array, left, j);
        return j;
    }

    private void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
