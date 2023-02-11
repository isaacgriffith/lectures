Password: 9572

1. (6 pts.) Consider the following six code segments from a random string class.

```java
// Segment A:
   public class randomString {
      private List myStrings = new ArrayList();
      public void add(String x) { myStrings.add(x); }
      public String getRandomValue() {
         Random generator = new Random();
         int size = myStrings.size();
         int randomIndex = generator.nextInt(size);
         return myStrings.get(randomIndex);
      }
   }
// Segment B:
   @Test public void tryOneChar() throws Exception {
     randomString rs = new randomString();
     rs.add('x');
     assertEquals('x', rs.getRandomValue());
  }
// Segment C:
  @Test public void tryOneString() throws Exception {
      randomString rs = new randomString();
      rs.add("Rendon");
      assertEquals("Rendon", rs.getRandomValue());
  }
// Segment D:
   public class randomString {
      char value;
      public void add(char x) { value = x; }
      public char getRandomValue() { return value; }
   }
// Segment E:
   @Test public void multipleStrings() throws Exception {
      randomString rs = new randomString();
      rs.add("Turner");
      rs.add("Soto");
      rs.add("Robles");
      String rando = rs.getRandomValue();
      assertTrue(rando.equals("Robles") ||
                 rando.equals("Turner") ||
                 rando.equals("Soto"));
  }
// Segment F:
   public class randomString {
      String value;
      public void add(String x) { value = x; }
      public String getRandomValue() { return value; }
   }
```

Place the code segments in the order they would appear in a TDD process.
a. Place the letters A-F in the appropriate order
b. Circle the appropriate status beside each selection

  * __________   Does not compile;    Red bar;     Green bar

  * __________   Does not compile;    Red bar;     Green bar

  * __________   Does not compile;    Red bar;     Green bar

  * __________   Does not compile;    Red bar;     Green bar

  * __________   Does not compile;    Red bar;     Green bar

  * __________   Does not compile;    Red bar;     Green bar

2. (2 pts.) After the last of the 6 segments above is run, the randomString class returns strings **with replacement**. Write a test that forces the class to return strings **without replacement**.





3. (2 pts.) Briefly describe **ONE** refactoring you would apply to the above tests.
