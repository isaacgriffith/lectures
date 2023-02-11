* Use one of the following terms to fill in each blank below. If in doubt, use the **closest matching** term.

  | Availability    | Scalability    |
  | Maintainability | Security       | 
  | Performance     | Time-to-market |
  | Reliability     | Usabilitly     |
  
  - _____ of software is less important than in the past  (c) Performance
  - This course focuses on increasing _______ and _______ (c) Maintainability and Reliability
  - _____ means the software can be run anytime from anywhere  (c) Availability
  - _____ refers to the ability to add more users (c) Scalability
  
* Consider the following Java method:

  ```java
  private boolean isValid(int X, int Y) {
      if (X * Y > 25) // Should be X + Y
          return true;
      else
          return false;
  }
  ```
  
  A test for this method has two integer values, one for X and one for Y. Suppose the fault is that the multiplication operator should have been addition.
  
  - Give a test that causes the fault to result in a failure.
  - Give a test that **does not** cause the fault to result in a failure.
  
* Briefly define 2 of the 3 Lehman's Laws below (pick two);

  1. Law of Continuing Change
  2. Law of Increasing Complexity
  3. Law of Self Regulation
  
* Which of the following are true statements about *evolutionary design*?

  (c) Hand-crafting was part of evolutionary design pre-industrial revolution.
  (n) Assembly lines encourage evolutionary design.
  (c) Manufacturing all but eliminated evolutionary design.
  (c) Our essay said that programming equates to **design** in hardware.
  
* Why have support costs been going down for software? (Note that you can answer this in one word.)

* According to the reading, **maintenance debt** is:

  (n) a bill for fixing something broken.
  (c) a habit that makes future changes harder.
  (n) having to change something you didn't expect to change.
  
* Answer each of the following questions about *Coding tips for Java* with either true or false.

  - Be precise--Sloppy style looks like sloppy thinking (c) True
  - Do not optimize until you know what needs to be optimized (c) True
  - If you implement `hashCode()` then the default `equals()` will always work find (c) False
  - `equals()` should raise exceptions when called on the wrong type (c) False
  
* Put the following terms in order in terms of more or less coupling.

   **Most Coupling:** 1. Method Calls
                      2. Shared data structures
                      3. Remote method invocation
                      4. Databases
  **Least Coupling:** 5. Messages
  
* Consider a method that converts temperatures in Fahrenheit to Celcius. Label the following pairs of inputs (temperature in F) and expected outputs (temperature in C) as "Happy path" (**H**) or "Exception inputs" (**E**). (You can assume the expected outputs are correct as given.)

  1. **H** F = 32, C = 0
  2. **E** F = 1000, C = 5538
  3. **E** F = xyzzy, C = exception
  4. **H** F = 0, C = -18
  5. **H** F = -40, C = -40
  
* The following JUnit test method for the `analyzeIntArray()` method has a non-syntactic flaw. The method returns the number of elements, the sum of the elements, and the average (mean) of the elements. Identify the flaw and describe it in terms of the RIPR model. Be as precise, specific, and concise as you can. For full credit, you must use the terminology introduced in the book.

  ```java
  @Test
  public void testAnalyzeIntArray() {
      int[] inputs = new int[] {1, 2, 3};
      aia.analyzeIntArray(inputs);
      assertTrue("analyzeIntArray() failed", (aia.getLen() == 3 && aia.getSum() == 6));
  }
  ```
  
* Label the following as either **synchronous** or **asynchronous** communication.

  - Lectures (c) Synchronous
  - Text Messages (c) Asynchronous

* Answer the following questions concisely.

  1. Order the following three activities in traditional development: Code, Design, Test.
  2. Order the following three activities in TDD development: Code, Design, Test
  3. What is the "TDD-name" for "Design"?
  4. What is the importance of the amount of time between when an error is made and that error is discovered?
  5. Why don't TDD tests make good functional tests?
  
* Consider the following JUnit test class:

  ```java
  public class quiz5Test {
      private Set mySet = new HashSet();
    
      @After
      public void tearDown() {
	  mySet = null;
      }

      @Before
      public void setUp() {
	  mySet = new HashSet();
      }

      @Test
      public void test1() {
	  mySet.add("microsoft");
	  assertEquals("[microsoft]", mySet.toString());
      }

      @Test 
      public void test2() {
	  mySet.add("google");
  	  mySet.add("facebook");
    	  mySet.add("google");
	  assertEquals("[google, facebook, google]", mySet.toString());
      }

      @Test public void test3() {
	  assertEquals("null", mySet.toString());
      }
  }
  ```
  
  - How many times will the `tearDown()` method be run?

    (c) 3
  
  - Will `test2()` work correctly?
  
    (c) No
  
  - Does `test3()` have the correct expected output?
  
    (c) No
