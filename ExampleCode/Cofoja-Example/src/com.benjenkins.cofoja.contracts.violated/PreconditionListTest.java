package com.benjenkins.cofoja.contracts.violated;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * An example of the PreconditionError thrown by an incorrect argument passed to a method.
 *
 * @author Ben
 * @since 2/7/2018.
 */
class PreconditionListTest {
    @Test
    @DisplayName("add with an index which is too large should cause precondition to fail.")
    public void add() {
        PreconditionList<String> preconditionList = new PreconditionList<>();
        preconditionList.add(2, "cat");
    }
}