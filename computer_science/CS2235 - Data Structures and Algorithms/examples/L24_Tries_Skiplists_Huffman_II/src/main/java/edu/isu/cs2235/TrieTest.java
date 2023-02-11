package edu.isu.cs2235;

import static org.junit.Assert.*;

public class TrieTest {

    @org.junit.Test
    public void insert() {
        Trie fixture = new Trie();
        String value = "value";

        fixture.insert(value);

        assertTrue(fixture.contains(value));
    }

    @Test
    public void insert() {
        Trie fixture = new Trie();
        String value = "value";
        String value2 = "value";

        fixture.insert(value);
        int size = fixture.size();
        fixture.insert(value2);

        assertEquals(size, fixture.size());
    }

    @Test
    public void insert_3() {
        Trie fixture  = new Trie();
        String value = "value";
        String values = "values";

        fixture.insert(value);
        int size = fixture.size();
        fixture.insert(values);

        assertEquals(size + 1, fixture.size());
    }

    @org.junit.Test
    public void contains() {
        Trie fixture = new Trie();

        String value = "value";

        assertFalse(fixture.contains(value));
    }

    @Test
    public void contains_2() {
        Trie fixture = new Trie();

        String value = null;

        assertFalse(fixture.contains(value));
    }

    @Test
    public void contains_3() {
        Trie fixture = new Trie();

        String value = "";

        assertFalse(fixture.contains(value));
    }

    public void construct() {
        Trie fixture = new Trie();

        assertNotNull(fixture.getRoot());
    }

    @org.junit.Test
    public void isEmpty() {
    }

    @org.junit.Test
    public void size() {
    }
}