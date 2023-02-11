package edu.isu.cs.grifisaa.patterns.flyweight;

import java.util.Map;
import java.util.HashMap;

public class CharacterFactory {

    private Map flyweights = new HashMap();

    public Glyph getFlyweight(char c) {
        Character key = new Character(c);
        if (flyweights.containsKey(key)) {
            return (Glyph)flyweights.get(key);
        } else {
            Glyph g = new Glyph(c);
            flyweights.put(key, g);
            return g;
        }
    }

    public int numberOfFlyweights() {
        return flyweights.size();
    }
}
