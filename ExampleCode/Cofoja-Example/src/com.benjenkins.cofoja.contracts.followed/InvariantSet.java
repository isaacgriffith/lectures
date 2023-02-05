package com.benjenkins.cofoja.contracts.followed;

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

    private List<E> list = new ArrayList<>();

    public void add(E element) {
        if (list.contains(element)) {
            return;
        }
        list.add(element);
    }

    // Used in the contract
    private boolean hasUniqueElements() {
        for (E element : list) {
            if (list.indexOf(element) != list.lastIndexOf(element)) {
                return false;
            }
        }
        return true;
    }
}
