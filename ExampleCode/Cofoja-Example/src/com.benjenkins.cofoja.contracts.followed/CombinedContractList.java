package com.benjenkins.cofoja.contracts.followed;

import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
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

    @Requires({"index >= 0", "index <= size()"})
    @Ensures({"element.equals(get(index))"})
    public void add(int index, E element) {
        list.add(index, element);
    }

    // Used in the contract
    public int size() {
        return list.size();
    }

    public E get(int index) {
        return list.get(index);
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
