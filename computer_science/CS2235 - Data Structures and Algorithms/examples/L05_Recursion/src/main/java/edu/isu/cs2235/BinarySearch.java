package edu.isu.cs2235l20;

public class BinarySearch implements ArraySearch {

    @Override
    public int search(int[] array, int item) {
        return binarySearch(array, item, 0, array.length - 1);
    }

    private int binarySearch(int[] array, int item, int start, int end) {
        if (start > end)
            return -1;
        else if (array[(end - start) / 2] == item || start == end)
            return array.length / 2;
        else {
            int mid = (end - start) / 2;
            if (item > array[mid])
                return binarySearch(array, item, mid + 1, end);
            else
                return binarySearch(array, item, start, mid);
        }
    }
}
