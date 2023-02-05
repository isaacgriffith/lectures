package com.benjenkins.cofoja.contracts.followed;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test for {@link InvariantSet}'s Cofoja invariants.
 *
 * @author Ben
 * @since 2/7/2018.
 */
class InvariantSetTest {

    @Test
    @DisplayName("add that doesnt enforce unique elements in a set should fail invariant")
    public void add() {
        InvariantSet<String> invariantSet = new InvariantSet<>();
        invariantSet.add("cat");
        invariantSet.add("dog");

        // Adding the element twice
        invariantSet.add("cat");
    }

}