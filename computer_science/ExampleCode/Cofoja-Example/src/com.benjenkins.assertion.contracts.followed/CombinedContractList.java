package com.benjenkins.assertion.contracts.followed;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;

import java.util.ArrayList;
import java.util.List;

/**
 * An example of Cofoja's precondition and postcondition checking combined.
 *
 * An invariant could be combined, but is not in this example.
 *
 * @author Ben
 * @since 2/7/2018.
 */
public class CombinedContractList<E> {

    private List<E> list = new ArrayList<>();

    public void add(int index, E element) {
        // Preconditions: index in valid range
        assert index >= 0 && index <= size();

        // TODO: Logic for adding 'element' at 'index'

        // Postconditions: 'element' is now at 'index'
        assert element.equals(get(index));
    }

    // Used in the contract
    public int size() {
        return list.size();
    }

    public E get(int index) {
        return list.get(index);
    }
}
