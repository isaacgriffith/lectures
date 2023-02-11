package com.benjenkins.cofoja.contracts.violated;

import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;

import java.util.ArrayList;
import java.util.List;

/**
 * An example of Cofoja's precondition and postcondition checking combined.
 *
 * @author Ben
 * @since 2/7/2018.
 */
public class CombinedContractList<E> {

    private List<E> list = new ArrayList<>();

    /**
     * Inserts the element at the position, shifting any subsequent elements right.
     *
     * @param index   where the element will be inserted
     * @param element any element
     */
    @Requires({"index >= 0", "index <= size()"})
    @Ensures({"element.equals(get(index))"})
    public void add(int index, E element) {
        // TODO: Add implementation later.
    }

    // Used in the contract
    public int size() {
        return list.size();
    }

    public E get(int index) {
        return index < list.size() ? list.get(index) : null;
    }

    private boolean hasUniqueElements() {
        for (E element : list) {
            if (list.indexOf(element) != list.lastIndexOf(element)) {
                return false;
            }
        }
        return true;
    }
}
