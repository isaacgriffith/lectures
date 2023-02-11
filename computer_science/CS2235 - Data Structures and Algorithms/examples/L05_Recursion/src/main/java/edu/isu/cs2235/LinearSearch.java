package edu.isu.cs2235l20;

public class LinearSearch implements ArraySearch {

    @Override
    public int search(int[] array, int item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == item)
                return i;
        }

        return -1;
    }
}
