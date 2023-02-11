package cofoja;

import java.util.LinkedList;

import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;

@Invariant({ "elements != null", "isEmpty() || top() != null" }) // no null objects are allowed
public class CofojaStack<T> {

    private final LinkedList<T> elements = new LinkedList<T>();

    @Requires("o != null")
    @Ensures({ "!isEmpty()", "top() == o" })
    public void push(T o) {
        elements.add(o);
    }

    @Requires("!isEmpty()")
    @Ensures({ "result == old(top())", "result != null" })
    public T pop() {
        final T popped = top();
        elements.removeLast();
        return popped;
    }

    @Requires("!isEmpty()")
    @Ensures("result != null")
    public T top() {
        return elements.getLast();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
}