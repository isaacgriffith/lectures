package edu.isu.cs2235l20;

import java.util.Arrays;

public class MergeSort implements ArraySort {

    @Override
    public void sort(int[] array) {
        mergeSort(array);
    }

    private int[] mergeSort(int[] array) {
        if (array.length <= 1)
            return array;
        else {
            int[] lower = mergeSort(Arrays.copyOfRange(array, 0, array.length / 2));
            int[] upper = mergeSort(Arrays.copyOfRange(array, array.length / 2 + 1, array.length - 1));

            return merge(array, lower, upper);
        }
    }

    private int[] merge(int[] original, int[] lower, int[] upper) {
        int i = 0;
        int j = 0;

        while (i + j < original.length) {
            if (i >= lower.length) {
                original[i + j] = upper[j];
                j += 1;
            }
            else if (j >= upper.length) {
                original[i + j] = lower[i];
                i += 1;
            }
            else if (lower[i] < upper[j]) {
                original[i + j] = lower[i];
                i += 1;
            }
            else {
                original[i + j] = upper[j];
                j += 1;
            }
        }

        return original;
    }
}
