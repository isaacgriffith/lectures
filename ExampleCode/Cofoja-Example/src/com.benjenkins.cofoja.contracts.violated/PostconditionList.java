package com.benjenkins.cofoja.contracts.violated;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;

import java.util.ArrayList;
import java.util.List;

/**
 * An example of a Cofoja Postcondition with the Ensures tag. The postcondition is checked after the
 * method call.
 *
 * @author Ben
 * @since 2/7/2018.
 */
public class PostconditionList<E> {

    private List<E> list = new ArrayList<>();

    @Ensures({"element.equals(get(index))"})
    public void add(int index, E element) {
        // TODO: Add the element at the index someday...
    }

    // Used in the contract
    public E get(int index) {
        return list.get(index);
    }
}
