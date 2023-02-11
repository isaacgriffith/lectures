package com.benjenkins.cofoja.contracts.violated;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link PostconditionList}'s Cofoja postconditions.
 *
 * @author Ben
 * @since 2/7/2018.
 */
class PostconditionListTest {

    @Test
    @DisplayName("add should cause postcondition to fail if it isnt implemented.")
    public void unimplementedAdd() {
        PostconditionList<String> postconditionList = new PostconditionList<>();
        postconditionList.add(0, "cat");
    }

}