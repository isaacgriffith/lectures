package com.benjenkins.cofoja.contracts.followed;

import com.google.java.contract.Ensures;

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
        list.add(index, element);
    }

    // Used in the contract
    public E get(int index) {
        return list.get(index);
    }
}
