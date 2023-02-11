package edu.isu.cs2263.examples.cofoja;

import com.google.java.contract.PreconditionError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CofojaStackTest {

  @Test
  public void emptyStackFailsPreconditionOnPop() {
    CofojaStack<String> stack = new CofojaStack<>();
    Assertions.assertThrows(PreconditionError.class, stack::pop);
  }
}
