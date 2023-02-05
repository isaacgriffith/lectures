package com.benjenkins.cofoja.contracts.violated;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * An example of a combined test of Cofoja's precondition and postcondition checks.
 *
 * @author Ben
 * @since 2/7/2018.
 */

class CombinedContractListTest {


    @Test
    @DisplayName("add should fail since violating precondition.")
    public void add1() {
        CombinedContractList<String> contractList = new CombinedContractList<>();
        contractList.add(2, "cat");
    }

    @Test
    @DisplayName("add should fail postcondition since logic isnt implemented")
    public void add2() {
        CombinedContractList<String> contractList = new CombinedContractList<>();
        contractList.add(0, "cat");
    }


}