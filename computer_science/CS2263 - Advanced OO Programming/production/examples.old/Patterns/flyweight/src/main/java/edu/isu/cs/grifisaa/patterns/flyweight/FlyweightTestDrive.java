package edu.isu.cs.grifisaa.patterns.flyweight;

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

public class FlyweightTestDrive {

    public static void main(String[] args) {
        CharacterFactory factory = new CharacterFactory();

        List l = new LinkedList();

        System.out.println(
            "Number of flyweights: " +
            factory.numberOfFlyweights());

        // try changing the number of this loop to experiment with
        // the effects of the flyweight pattern.

        for (int i = 0; i < 1000; i++) {
            char c = (char)(Math.random() * 26 + 'a');
            Glyph g = factory.getFlyweight(c);
            l.add(g);
        }

        int j = 0;

        Iterator itr = l.iterator();
        while (itr.hasNext()) {
            Glyph g = (Glyph)itr.next();
            System.out.println(g.myPosition(j++));
        }

        System.out.println(
            "Number of flyweights: " +
            factory.numberOfFlyweights());
   
    }
}
