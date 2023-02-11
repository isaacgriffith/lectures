---
author:
- Dr. Isaac Griffith
title: Unit Testing
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
outline: false
...

# Bugs and Testing

* \small \textcolor{Roarange}{\textbf{Software Reliability:}} Probability that a software system will not cause failure under specified conditions.
  - \footnotesize Measured by uptime, MTTF (mean time till failure), crash data

\vskip.5em

* \small \textcolor{Roarange}{\textbf{Bugs}} are inevitable in any complex software system
  - \footnotesize Industry estimates: 10 - 50 bugs per 1000 lines of code.
  - \footnotesize A bug can be visible or can hide in your code until much later.

\vskip.5em

* \small \textcolor{Roarange}{\textbf{Testing:}} A systematic attempt to reveal errors
  - \footnotesize Failed test: an error was demonstrated
  - \footnotesize Passed test: no error was found (for this particular situation)

# Difficulties of Testing

* \small Perception by some developers and managers:
  - \footnotesize Testing is seen as a novice's job
  - \footnotesize Assigned to the least experienced team members
  - \footnotesize Done as an afterthought (if at all)
    * \scriptsize "My code is good; it won't have bugs. I don't need to test it."
    * \scriptsize "I'll just find the bugs by running the client program."

\vskip.5em

* \small Limitations of what testing can show you:
  - \footnotesize It is impossible to completely test a system
  - \footnotesize Testing does not always directly reveal the actual bugs in the code.
  - \footnotesize Testing does not prove the absence of errors in software.

# Outcomes

After today's lecture you will be able to:

::: columns
:::: {.column width=.7}
* \small Understand the basic ideas of testing and their importance to practice
* \small Implement unit tests using the JUnit framework
* \small Understand how to select what to test and how to test it
::::
:::: {.column width=.25}
\vfill
\vspace{5.75em}
\centering
\includegraphics[width=\textwidth]{images/brain-gears-invert2.png}
::::
:::

#

\centering
\vfill
\begin{minipage}{.375\textwidth}
{
\includegraphics[width=13pt]{images/mark.png}
\Huge Unit Testing
}
\vskip-.5em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# Unit Testing

* \small \textcolor{Roarange}{\textbf{unit testing:}} Looking for errors in a subsystem in isolation
  - \footnotesize Generally a "subsystem" means a particular class or object
  * \footnotesize The Java library \textcolor{Roarange}{\textbf{JUnit}} helps us to easily perform unit testing

\vskip.5em

* \small The basic idea:
  - \footnotesize For a given class `Foo`, create another class `FooTest` to test it, containing various "test case" methods to run.
  - \footnotesize Each method looks for particular results and passes / fails.

\vskip.5em

* \small JUnit provides "\textcolor{Roarange}{\textbf{assert}}" commands to help us write tests.
  - \footnotesize \textcolor{Roarange}{\textbf{The Idea:}} put assertion calls in your test methods to check things you expect to be true. If they aren't, the test will fail.

# JUnit and Gradle

\small

```java
    dependencies {
        // Use JUnit test framework
        testRuntime "org.junit.jupiter:junit-jupiter-engine:5.5.2"
        testRuntime "org.junit.platform:junit-platform-runner:1.5.2"
    }

    test {
        useJUnitPlatform()
    }
```

# A JUnit Test Class

\small

```java
    import org.junit.*;
    import static org.junit.Assert.*;

    public class name {
      ...

      @Test
      public void name() { // a test case method
        ...
      }
    }
```

* \small A method with `@Test` is flagged as a JUnit test case.
  - \footnotesize All `@Test` methods run when JUnit runs your test class.

# JUnit Assertion Methods

\small
+---------------------------------------+------------------------------------------------+
| \textcolor{Roarange}{\textbf{Method}} | \textcolor{Roarange}{\textbf{Description}}     |
+:======================================+:===============================================+
| `assertTrue(test)`                    | fails if the boolean test if false             |
+---------------------------------------+------------------------------------------------+
| `assertFalse(test)`                   | fails if the boolean test is true              |
+---------------------------------------+------------------------------------------------+
| `assertEquals(expected, actual)`      | fails if the values are not equal              |
+---------------------------------------+------------------------------------------------+
| `assertSame(expected, actual)`        | fails if the values are not the same (by `==`) |
+---------------------------------------+------------------------------------------------+
| `assertNull(value)`                   | fails if the given value is *not* null         |
+---------------------------------------+------------------------------------------------+
| `assertNotNull(value)`                | fails if the given value is null               |
+---------------------------------------+------------------------------------------------+
| `fail()`                              | causes current test to immediately fail        |
+---------------------------------------+------------------------------------------------+

* \small Each method can also be passed a string to display if it fails:
  - \footnotesize e.g. `assertEquals("message", expected, actual)`
  - \footnotesize Why is there no `pass()` method?

# ArrayIntList JUnit Test

\scriptsize
::: columns
:::: column
```java
import org.junit.*;
import static org.junit.Assert.*;

public class TestArrayIntList {
    @Test
    public void testAddGet1() {
        ArrayIntList list = new ArrayIntList();
        list.add(42);
        list.add(-3);
        list.add(15);
        assertEquals(42, list.get(0));
        assertEquals(-3, list.get(1));
        assertEquals(15, list.get(2));
    }
```
::::
:::: column
```java
    @Test
    public void testIsEmpty() {
        ArrayIntList list = new ArrayIntList();
        assertTrue(list.isEmpty());
        list.add(123);
        assertFalse(list.isEmpty());
        list.remove(0);
        assertTrue(list.isEmpty());
    }
}





```
::::
:::


# JUnit Exercise

::: columns
:::: {.column width=.6}

* \small Given a `Date` class with the following methods

  * \scriptsize `public Date(int year, int month, int day)`
  * \scriptsize `public Date() // today`
  * \scriptsize `public int getDay(), getMonth(), getYear()`
  * \scriptsize `public void addDays(int days) // advance by days`
  * \scriptsize `public int daysInMonth()`
  * \scriptsize `public String dayOfWeek() // e.g. "Sunday"`
  * \scriptsize `public boolean equals(Object o)`
  * \scriptsize `public boolean isLeapYear()`
  * \scriptsize `public void nextDay() // advances by 1 day`
  * \scriptsize `public String toString()`

::::
:::: {.column width=.4}

* \small Come up with unit tests to check the following:
  - \footnotesize That no `Date` object can ever get into an invalid state
  - \footnotesize That the `addDays` method works properly
    * \scriptsize It should be efficient enough to add 1,000,000 days in a call.

::::
:::

# What's wrong with this?

\scriptsize
```java
public class DateTest {
    @Test
    public void test1() {
        Date d = new Date(2050, 2, 15);
        d.addDays(4);
        assertEquals(d.getYear(), 2050);
        assertEquals(d.getMonth(), 2);
        assertEquals(d.getDay(), 19);
    }

    @Test
    public void test2() {
        Date d = new Date(2050, 2, 15);
        d.addDays(14);
        assertEquals(d.getYear(), 2050);
        assertEquals(d.getMonth(), 3);
        assertEquals(d.getDay(), 1);
    }
}
```

# Well-Structured Assertions

\scriptsize
```java
public class DateTest {
    @Test
    public void test1() {
        Date d = new Date(2050, 2, 15);
        d.addDays(4);
        assertEquals(2050, d.getYear());  // expected
        assertEquals(2, d.getMonth());    // value should
        assertEquals(19, d.getDay());     // be at LEFT
    }

    @Test
    public void test2() {
        Date d = new Date(2050, 2, 15);
        d.addDays(14);
        assertEquals("year after +14 days", 2050, d.getYear());
        assertEquals("month after +14 days", 3, d.getMonth());
        assertEquals("day after +14 days", 1, d.getDay());
    }   // test cases should usually have messages explaining
}       // what is being checked, for better failure output
```

# Expected Answer Objects

\scriptsize
```java
public class DateTest {
    @Test
    public void test1() {
        Date d = new Date(2050, 2, 15);
        d.addDays(4);
        Date expected = new Date(2050, 2, 19);
        assertEquals(expected, d);  // use an expected answer
    }                               // object to minimize tests

                                    // (Date must have toString
    @Test                           //  and equals methods)
    public void test2() {
        Date d = new Date(2050, 2, 15);
        d.addDays(14);
        Date expected = new Date(2050, 3, 1);
        assertEquals("date after +14 days", expected, d);
    }
}
```

# Naming Test Cases

\scriptsize
```java
public class DateTest {
    @Test
    public void test_addDays_withinSameMonth_1() {
        Date actual = new Date(2050, 2, 15);
        actual.addDays(4);
        Date expected = new Date(2050, 2, 19);
        assertEquals("date after +4 days", expected, actual);
    }
    // give test case methods really long descriptive names

    @Test
    public void test_addDays_wrapToNextMonth_2() {
        Date actual = new Date(2050, 2, 15);
        actual.addDays(14);
        Date expected = new Date(2050, 3, 1);
        assertEquals("date after +14 days", expected, actual);
    }
    // give descriptive names to expected/actual values
}
```

# What's Wrong with This?

\scriptsize
```java
public class DateTest {
    @Test
    public void test_addDays_addJustOneDay_1() {
        Date actual = new Date(2050, 2, 15);
        actual.addDays(1);
        Date expected = new Date(2050, 2, 16);
        assertEquals(
            "should have gotten " + expected + "\n" +
            " but instead got " + actual + "\n",
            expected, actual);
    }
    ...
}
```

# Good Assertion Messages

\scriptsize
```java
public class DateTest {
    @Test
    public void test_addDays_addJustOneDay_1() {
        Date actual = new Date(2050, 2, 15);
        actual.addDays(1);
        Date expected = new Date(2050, 2, 16);
        assertEquals("adding one day to 2050/2/15",
            expected, actual);
    }
    ...
}

// JUnit will already show
// the expected and actual
// values in its output;
//
// don't need to repeat them
// in the assertion message
```

# Tests with a Timeout

\small

```java
@Test(timeout = 5000)
public void name() { ... }
```

* \small The above method will be considered a failure if it doesn't finish running within 5000 ms

\small

```java
private static final int TIMEOUT = 2000;
...

@Test(timeout = TIMEOUT)
public void name() { ... }
```

* \small Times out/fails after 2000 ms

# Pervasive Timeouts

\tiny
```java
public class DateTest {
    @Test(timeout = DEFAULT_TIMEOUT)
    public void test_addDays_withinSameMonth_1() {
        Date d = new Date(2050, 2, 15);
        d.addDays(4);
        Date expected = new Date(2050, 2, 19);
        assertEquals("date after +4 days", expected, d);
    }


    @Test(timeout = DEFAULT_TIMEOUT)
    public void test_addDays_wrapToNextMonth_2() {
        Date d = new Date(2050, 2, 15);
        d.addDays(14);
        Date expected = new Date(2050, 3, 1);
        assertEquals("date after +14 days", expected, d);
    }

    // almost every test should have a timeout so it can't
    // lead to an infinite loop; good to set a default, too
    private static final int DEFAULT_TIMEOUT = 2000;
}
```

# Testing for Exceptions

\small

```java
@Test(expected = ExceptionType.class)
public void name() {
  ...
}
```

* \small Will pass if it \textcolor{Buttons}{\textit{does}} through the given exception.
  - \footnotesize If the execption is \textcolor{Buttons}{\textit{not}} thrown, the test fails.
  - \footnotesize Use this to test for expected errors.

\small

```java
@Test(expected = ArrayIndexOutOfBoundsException.class)
public void testBadIndex() {
    ArrayIntList list = new ArrayIntList();
    list.get(4);   // should fail
}
```

# Setup and Teardown

\small

```java
@Before
public void name() { ... }

@After
public void name() { ... }
```

* \small Methods to run before/after each test case method is called

\small

```java
@BeforeClass
public static void name() { ... }

@AfterClass
public static void name() { ... }
```

* \small Methods to run once before/after the entire test class runs

# Tips for Testing

* \small You cannot test every possible input, parameter value, etc.
  - \footnotesize So you must think of a limited set of tests likely to expose bugs

* \small Think about boundary cases
  - \footnotesize positive; zero; negative numbers
  - \footnotesize right at the edge of an array or collection's size

* \small Think about empty cases and error cases
  - \footnotesize 0, -1, null; an empty list or array
  - \footnotesize empty string

* \small Test behavior in combination
  - \footnotesize maybe `add` usually works, but fails after you call `remove`
  - \footnotesize make multiple calls; maybe `size` fails the second time only

# Tips for Writing Tests

* \small Follow the AAA Method
  - \footnotesize \textcolor{Roarange}{\textbf{Arrange:}} Perform the setup and initialization required for the test
  - \footnotesize \textcolor{Roarange}{\textbf{Act:}} Take action(s) required for the test
  - \footnotesize \textcolor{Roarange}{\textbf{Assert:}} Verify the outcome(s) of the test

* \small Utilize a test fixture object (object under test) and `@Before` to initialize the object before every test
  - \footnotesize Reduce redundant and duplicate code

# What's Wrong with This?

\scriptsize
```java
public class DateTest {
    // test every day of the year
    @Test(timeout = 10000)
    public void tortureTest() {
        Date date = new Date(2050, 1, 1);
        int month = 1;
        int day = 1;
        for (int i = 1; i < 365; i++) {
            date.addDays(1);
            if (day < DAYS_PER_MONTH[month]) {day++;}
            else                             {month++; day=1;}
            assertEquals(new Date(2050, month, day), date);
        }
    }

    private static final int[] DAYS_PER_MONTH = {
        0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    }; // Jan Feb Mar Apr May Jun Jul Aug Sep Oct Nov Dec
}
```

# Trustworthy Tests

* \small Test one thing at a time per test method
  - \footnotesize 10 small tests are much better than 1 test 10x as large.

* \small Each test method should have few (likely 1) assert statements
  - \footnotesize If you assert many things, the first that fails stops the test.
  - \footnotesize You won't know whether a later assertion would have failed.

* \small Tests should avoid logic
  - \footnotesize minimize `if/else`, `loops`, `switch`, etc.
  - \footnotesize avoid `try/catch`
    * \scriptsize If it's supposed to throw, use `expected=...` if not, let JUnit catch it

* Torture tests are \textcolor{Buttons}{\textit{okay, but only in addition to}} simple tests.

<!--
# JUnit Exercise

* \small Given our `Date` class seen previously

  * `public Date(int year, int month, int day)`
  * `public Date() // today`
  * `public int getDay(), getMonth(), getYear()`
  * `public void addDays(int days) // advance by days`
  * `public int daysInMonth()`
  * `public String dayOfWeek() // e.g. "Sunday"`
  * `public boolean equals(Object o)`
  * `public boolean isLeapYear()`
  * `public void nextDay() // advances by 1 day`
  * `public String toString()`

* \small Come up with unit tests to check the following:
  - \footnotesize That no `Date` object can ever get into an invalid state
  - \footnotesize That the `addDays` method works properly
    * \scriptsize It should be efficient enough to add 1,000,000 days in a call.

-->

# Squashing Redundancy

\tiny
```java
public class DateTest {
    @Test(timeout = DEFAULT_TIMEOUT)
    public void addDays_withinSameMonth_1() {
        addHelper(2050, 2, 15, +4, 2050, 2, 19);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void addDays_wrapToNextMonth_2() {
        addHelper(2050, 2, 15, +14, 2050, 3, 1);
    }

    // use lots of helpers to make actual tests extremely short
    private void addHelper(int y1, int m1, int d1, int add,
                           int y2, int m2, int d2) {
        Date act = new Date(y, m, d);
        actual.addDays(add);
        Date exp = new Date(y2, m2, d2);
        assertEquals("after +" + add + " days", exp, act);
    }

    // can also use "parameterized tests" in some frameworks
    ...
}
```

# Flexible Helpers

\tiny
```java
public class DateTest {
    @Test(timeout = DEFAULT_TIMEOUT)
    public void addDays_multipleCalls_wrapToNextMonth2x() {
        Date d = addHelper(2050, 2, 15, +14, 2050, 3, 1);
        addhelper(d, +32, 2050, 4, 2);
        addhelper(d, +98, 2050, 7, 9);
    }

    // Helpers can box you in; hard to test many calls/combine.
    // Create variations that allow better flexibility
    private Date addHelper(int y1, int m1, int d1, int add,
                           int y2, int m2, int d2) {
        Date date = new Date(y, m, d);
        addHelper(date, add, y2, m2, d2);
        return d;
    }

    private void addHelper(Date date, int add,
                           int y2, int m2, int d2) {
        date.addDays(add);
        Date expect = new Date(y2, m2, d2);
        assertEquals("date after +" + add + " days", expect, d);
    }
    ...
}
```

# Regression Testing

* \small \textcolor{Roarange}{\textbf{regression:}} When a feature that used to work, no longer works.
  - \footnotesize Likely to happen when code changes and grows over time.
  - \footnotesize A new feature/fix can cause a new bug or reintroduce an old bug.

\vskip.5em

* \small \textcolor{Roarange}{\textbf{regression testing:}} Re-executing prior unit tests after a change.
  - \footnotesize Often done by scripts during automated testing.
  - \footnotesize Used to ensure that old fixed bugs are still fixed.
  - \footnotesize Gives your app a minimum level of working functionality.

\vskip.5em

* \small Many products have a set of mandatory check-in tests that must pass before code can be added to a source code repository.

# Test-Driven Development

* \small Unit tests can be written after, during, or even \textcolor{Buttons}{\textit{before}} coding
  - \footnotesize \textcolor{Roarange}{\textbf{test-driven development:}} Write test, \textcolor{Buttons}{\textit{then}} write code to pass them.

\vskip.5em

* \small Imagine that we'd like to add a method `subtractWeeks` to our `Date` class, that shifts this `Date` backward in time by the given number of weeks.

\vskip.5em

* \small Write code to test this method \textcolor{Buttons}{\textit{before}} it has been written.
  - \footnotesize Then once we do implement the method, we'll know if it works.

\vskip.5em

* \small \textcolor{Roarange}{\textbf{TDD}} works well when we are implementing a system similar to what we have already implemented in the past
* \small \textcolor{Roarange}{\textbf{Test Last Development}} works best when we are implementing a system with which we have little experience

# Test-Driven Development

\centering
\includegraphics[width=.75\textwidth]{images/testing/tddlc-invert.png}

# Tests and Data Structures

* \small Need to pass lots of arrays? Use array literals

\footnotesize
```java
public void exampleMethod(int[] values) { ... }
...
exampleMethod(new int[] {1, 2, 3, 4});
exampleMethod(new int[] {5, 6, 7});
```

* \small Need a quick `ArrayList`? Try `Arrays.asList`

\footnotesize
```java
List<Integer> list = Arrays.asList(7, 4, -2, 3, 9, 18);
```

* \small Need a quick set, queue, etc.? Many collections can take a list

\footnotesize
```java
Set<Integer> list = new HashSet<Integer>(
                        Arrays.asList(7, 4, -2, 9));
```

# What's Wrong with This?

\tiny
```java
public class DateTest {
    // shared Date object to test with (saves memory!!1)
    private static Date DATE;

    @Test(timeout = DEFAULT_TIMEOUT)
    public void addDays_sameMonth() {
        DATE = new Date(2050, 2, 15);      // first test;
        addhelper(DATE,  +4, 2050, 2, 19); // DATE = 2/15 here
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void addDays_nextMonthWrap() {  // second test;
        addhelper(DATE, +10, 2050, 3, 1);  // DATE = 2/19 here
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void addDays_multipleCalls() {  // third test;
        addDays_sameMonth();               // go back to 2/19;
        addhelper(DATE, +1, 2050, 2, 20);  // test two calls
        addhelper(DATE, +1, 2050, 2, 21);
    }
    ...
}
```

# Test Case "Smells"

* \small Tests should be self-contained and not care about each other

* \small "\textcolor{Roarange}{\textbf{Smells}}" (bad things to avoid) in tests:

  - \footnotesize \textcolor{Buttons}{\textit{Constrained test order:}} Test A must run before Test B.
    (usually a misguided attempt to test order/flow)
  - \footnotesize \textcolor{Buttons}{\textit{Tests call each other:}} Test A calls Test B's method
    (calling a shared helper is OK, though)
  - \footnotesize \textcolor{Buttons}{\textit{Mutable shared state:}} Tests A/B both use a shared object.
    (If A breaks it, what happens to B?)

# JUnit Summary

* \small Tests need *failure atomicity* (ability to know exactly what failed).
  - \footnotesize Each test should have a clear, long, descriptive name.
  - \footnotesize Assertions should always have clear messages to know what failed.
  - \footnotesize Write many small tests, not one big test.
    * \scriptsize Each test should have roughly just 1 assertion at its end.
* \small Always use a `timeout` parameter to every test
* \small Test for expected errors / exceptions
* \small Choose a descriptive assert method, not always `assertTrue`
* \small Avoid complex logic in test methods if possible.
* \small Use helpers, `@Before` to reduce redundancy between tests.

# Additional Topics

* \small Though we did cover the basics of Unit Testing, there is much more to be learned
  - \footnotesize A key to good unit testing is isolation of the unit
  - \footnotesize We want to test only the object/class under test and nothing else
  - \footnotesize This is often difficult to do when our class uses many other classes, or our methods call many other methods
  - \footnotesize In these cases, \textcolor{Roarange}{\textbf{Mocking Frameworks}} allow us to fake-out those objects and method calls
  - \footnotesize Examples of such frameworks are:
    * \scriptsize Mockito
    * \scriptsize EasyMock
  - \footnotesize Spock (a groovy based specification testing framework) does this and much more as we will see soon...

# For Next Time

::: columns
:::: column
* Review the Moodle Unit Testing Resources
* Review this lecture
* Come to Lecture!
::::
:::: column
\centering
\includegraphics[width=.85\textwidth]{images/next_time-invert2.png}
::::
:::

#

\centering
\includegraphics[scale=.40]{images/questions-invert2.png}

\Huge \textbf{Are there any questions?}
