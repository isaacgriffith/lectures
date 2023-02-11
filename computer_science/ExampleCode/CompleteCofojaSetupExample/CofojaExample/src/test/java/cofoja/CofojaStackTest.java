package cofoja;

import org.junit.Test;

import com.google.java.contract.PreconditionError;

public class CofojaStackTest {

    @Test(expected = PreconditionError.class)
    public void emptyStackFailsPreconditionOnPop() {
        CofojaStack<String> s = new CofojaStack<String>();
        s.pop(); // throws PreconditionError (instead of NoSuchElementException)
    }

}
