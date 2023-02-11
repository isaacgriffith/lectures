Password: 1451

1. (5 pts.) Consider a method that converts temperatures in Farenheit to Celcius. Label the following pairs of inputs (temperature in F) and expected outputs (temperature in C) as "Happy path" (**H**) or "Exception inputs" (**E**). (You can assume the expected outputs are correct as given.)

     1. __ F = 32, C = 0

     2. __ F = 1000, C = 5538

     3. __ F = xyzzy, C = exception

     4. __ F = 0, C = -18

     5. __ F = -40, C = -40

2. (5 pts.) The following JUnit test method for the `analyzeIntArray()` method has a non-syntactic flaw. The method returns the number of elements, the sum of the elements, and the average (mean) of the elements. Identify the flaw and describe it in terms of the RIPR model. Be as precise, specific, and concise as you can. For full credit, you must use the terminology introduced in the book.
You can assume that an object has been created (**aia**) and **getter** methods have been tested.

```java
@Test
public void testAnalyzeIntArray() {
   int[] inputs = new int[] {1,2,3};
   aia.analyzeIntArray(inputs);
   assertTrue("analyzeIntArray() failed",
            (aia.getLen()==3 && aia.getSum()==6));
}
```
