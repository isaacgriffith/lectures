package com.benjenkins.cofoja.contracts.violated;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;

import java.util.ArrayList;
import java.util.List;

/**
 * An example of Cofoja's precondition checking. The precondition is checked before the method
 * call.
 *
 * @author Ben
 * @since 2/7/2018.
 */
public class PreconditionList<E> {

    private List<E> list = new ArrayList<>();

    @Requires({"index >= 0", "index <= size()"})
    public void add(int index, E element) {
        // TODO: Add implementation later.
    }

    // Used in the contract
    public int size() {
        return list.size();
    }
}
