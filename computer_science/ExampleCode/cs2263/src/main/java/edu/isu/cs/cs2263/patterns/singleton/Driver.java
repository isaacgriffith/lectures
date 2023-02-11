package edu.isu.cs.cs2263.patterns.singleton;

public class Driver {

    public static void main(String[] args) {
        WithHelper wh1 = WithHelper.instance();
        WithHelper wh2 = WithHelper.instance();

        if (wh1 == wh2) {
            System.out.println("They are the same");
        }

        if (wh1.equals(wh2)) {
            System.out.println("They are equivalent");
        }
    }
}
