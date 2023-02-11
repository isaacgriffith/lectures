package com.benjenkins.cofoja.contracts.followed;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * An example of a combined test of Cofoja's precondition, postcondition, and invariant checks.
 *
 * @author Ben
 * @since 2/7/2018.
 */

class CombinedContractListTest {

    @Test
    @DisplayName("add with precondition and postcondition checks.")
    public void add() {
        CombinedContractList<String> contractList = new CombinedContractList<>();
        contractList.add(0, "cat");
    }


}