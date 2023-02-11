package edu.isu.cs.cs3308.examples.lecture14;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class ParallelQuickSort implements SortStrategy {
    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        ForkJoinTask.invokeAll(new QuickSortAction<>(array, 0, array.length - 1));
    }

    public String toString() {
        return "Parallel QuickSort";
    }
}

class QuickSortAction<T extends Comparable<T>> extends RecursiveAction {
    private int start;
    private int end;
    private T[] array;

    public QuickSortAction(T[] array, int start, int end) {
        this.start = start;
        this.end = end;
        this.array = array;
    }

    @Override
    protected void compute() {
        quickSort();
    }

    private void quickSort() {
        if (start < end) {
            int pivot = selectPivot(array);

            int left = start;
            int right = end - 1;

            int x = 0;
            while (left <= right) {
                if (array[right].compareTo(array[pivot]) >= 0)
                    right--;
                else
                    x++;
                if (array[left].compareTo(array[pivot]) < 0)
                    left++;
                else
                    x++;

                if (x == 2) {
                    swap(array, left, right);
                    x = 0;
                }
            }

            swap(array, left, pivot);

            invokeAll(new QuickSortAction<>(array, start, right),
                        new QuickSortAction<>(array, left + 1, end));
        }
    }

    public void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int selectPivot(T[] array) {
        return array.length - 1;
    }
}
