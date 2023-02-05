package com.benjenkins.cofoja.contracts.violated;

import com.google.java.contract.Invariant;

import java.util.ArrayList;
import java.util.List;

/**
 * An example of a Cofoja Invariant checking. The Invariant is checked before and after each method
 * call.
 *
 * @author Ben
 * @since 2/7/2018.
 */
@Invariant("hasUniqueElements()")
public class InvariantSet<E> {

    private List<E> elements = new ArrayList<>();

    public void add(E element) {
        elements.add(element);
    }

    // Used in the contract

    /**
     * @return true if all elements are unique
     */
    private boolean hasUniqueElements() {
        for (E element : elements) {
            // The first occurrence should be the same as the last occurrence, if this isn't true,
            // return false
            if (elements.indexOf(element) != elements.lastIndexOf(element)) {
                return false;
            }
        }
        return true;
    }
}
