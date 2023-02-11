package edu.isu.cs2235l20.generics;

public class GenericDemo {

    public static <T> void reverse(T[] data) {
        int low = 0, high = data.length - 1;

        while (low < high) {
            T temp = data[low];
            data[low++] = data[high];
            data[high--] = temp;
        }
    }
}
