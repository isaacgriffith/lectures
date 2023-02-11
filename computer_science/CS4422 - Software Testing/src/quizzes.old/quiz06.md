Password: 5639

1. (5 pts.) Answer the following questions concisely.
    1. Order the following three activities in traditional development: Code, Design, Test.


    2. Order the following three activities in TDD development: Code, Design, Test.


    3. What is the “TDD-name” for “Design”?


    4. What is the importance of the amount of time between when an error is made and that error is discovered?


    4. Why don’t TDD tests make good functional tests?



2. (5 pts.) Consider the following JUnit test class:

```java
public class quiz5Test {
   private Set mySet = new HashSet();
   @After public void tearDown() {
      mySet = null;
   }
   @Before public void setUp() {
      mySet = new HashSet();
   }
   @Test public void test1() {
      mySet.add("microsoft");
      assertEquals("[microsoft]", mySet.toString());
   }

   @Test public void test2() {
      mySet.add("google");
      mySet.add("facebook");
      mySet.add("google");
      assertEquals("[google, facebook, google]",
                    mySet.toString());
   }
   @Test public void test3() {
      assertEquals("null", mySet.toString());
   }
}
```

    a. How many times will the tearDown() method be run?



    b. Will test2() work correctly? Why or why not?



    c. Does test3() have the correct expected output?
