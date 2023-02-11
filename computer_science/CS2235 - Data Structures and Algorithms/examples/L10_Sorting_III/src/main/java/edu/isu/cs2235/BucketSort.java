package edu.isu.cs2235l20;

public class BucketSort implements ArraySort {

    @Override
    public void sort(int[] array) {

        int[] counts = count(array);

        updateCounts(counts);

        int[] sorted = sortArray(array, counts);

        for (int i = 0; i < sorted.length; i++) {
            array[i] = sorted[i];
        }
    }

    private int[] count(int[] array) {
        int max = findMax(array);

        int[] counts = new int[max + 1];
        for (int i = 0; i < counts.length; i++)
            counts[i] = 0;

        for (int i : array) {
            counts[i] += 1;
        }

        return counts;
    }

    private void updateCounts(int[] counts) {
        int numBefore = 0;
        for (int i = 0; i < counts.length; i++) {
            int temp = counts[i];
            counts[i] = numBefore;
            numBefore += temp;
        }
    }

    private int findMax(int[] array) {
        int max = 0;
        for (int i : array) {
            if (i > max)
                max = i;
        }

        return max;
    }

    private int[] sortArray(int[] array, int[] counts) {
        int[] temp = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            temp[counts[array[i]]] = array[i];
            counts[array[i]] += 1;
        }

        return temp;
    }
}
