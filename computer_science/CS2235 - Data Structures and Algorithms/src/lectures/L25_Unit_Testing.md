---
author:
- Isaac Griffith
title: Unit Testing
institute: |
  CS 2235

  Department of Informatics and Computer Science

  Idaho State University
fontsize: 11pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

#

\vfill
\centering
\Huge Unit Testing

# Outcomes

At the end of Today's Lecture you will be able to:

* Understand the basic concepts of Unit Testing
* Understand the basic lifecycle of Unit Testing and TDD
* Be capable of applying unit testing
* Be capable of using the JUnit unit testing framework

# Introduction

* Testing and debugging provide the basic components of the forth step in the Programming Process: **Testing and Correcting Errors**.
\pause
* In Programming there are many types of testing
\pause
   * **Unit Testing**
   * Integration Testing
   * White Box Testing
   * System Testing
   * Black Box Testing
   * UI Testing
\pause
* Testing provides a means to identify if the program is correctly implemented
\pause
* Debugging helps us to identify the exact location and cause of an error.

# Unit Testing

* Large programs consist of many smaller pieces
  - Classes, methods, packages, modules, etc.
* "Unit" is a generic term for these smaller pieces
* Unit Testing is done to test the smaller pieces in isolation before they are combined with other pieces
  - Usually done by the developers who write the code.

# What Unit Tests Do

* Unit tests create objects, call methods, and verify that the returned results are correct.
* Actual results vs. Expected results
* Unite tests should be automated so that they can be run frequently (many times a day) to ensure that changes, additions, bug fixes, etc. have not broken the code.
* Notifies you when changes have introduced bugs, and helps to avoid destabilizing the system.

# Test Driver Program

* The tests are run by a "test driver", which is a program that just runs all of the unit test cases.
* It must be really easy to add new tests to the test driver.
* At the end of the program, the test driver either tells you that everything worked, or gives you a list of tests that failed.
* Little or no manual labor is required to run tests and check the results.

# Selecting Test Cases

* How do you design test cases for a method?
* Ad Hoc Testing - try a variety of valid and invalid inputs, whatever comes to mind
* Exhaustive testing - create a test for each distinct possible path through the method
  - Trace the line numbers that are executed when the method executes
  - Each possible trace is a different "path"
  - Often the number of possible paths is so large that exhaustive testing is infeasible

# Selecting Test Cases

* We can't be exhaustive, so we instead use code coverage criteria to guide our selection of test cases
  - Line Coverage -- Test each line at least once
    * This is the minimal level of testing, and is usually not sufficient
  - Branch Coverage - Test the TRUE and FALSE cases of each branch at least once
  - Condition Coverage - test ALL possible ways that each condition can be TRUE or FALSE

* For the purposes of this class we will not focus on the coverage of your tests.

# What about missing code?

* Code coverage criteria helps to ensure that existing code is tested thoroughly
* What if there is no code at all to handle certain kinds of input?
  - Programmer forgot to handle some cases
* Code coverage doesn't find these errors
* Ad Hoc testing can be used to detect unhandled cases.

# Unit Testing Lifecycle

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module5/Testing/utlc.png}
\end{center}

# Unit Testing Tools

In Java we have several choices available to both perform and help perform unit testing:

::: columns
:::: column
**Testing Tools**

* JUnit
* AssertJ
* TestNG
* Spock
* JSpec \& DBSpec

::::
:::: column
**Test Helpers**

* Mockito
* Easy Mock
* JMockit
* EMMA

::::
:::

# Test Driven Development

\begin{center}
\includegraphics[width=.5\textwidth]{images/Module5/Testing/TDD2.png}
\end{center}

# Advantages/Disadvantages

**Advantages of Unit Testing**

* Improves understanding of the API
* Allows for refactoring.
* Can test early even when the rest of the system has yet to be built.

**Disadvantages of Unit Testing**

* Cannot catch every error in the program.
* Unit testing focuses on a unit of code and thus cannot find errors at the system level.

# JUnit

```java
public class Temperature
{
    private int fahrenheit;

    public Temperature(int inF)
    {
        fahrenheit = inF;
    }

    public int convertToCent()
    {
        return (int) Math.round((fahrenheit - 32) / 1.8);
    }
}
```

# Assertion Methods

The main JUnit Assertions Methods are:

* `assertEquals(Type exp, Type obs);`
* `assertEquals(double exp, double obs, double sig);`
* `assertTrue(boolean expr);`
* `assertFalse(boolean expr);`
* `assertNull(Object val);`
* `assertNotNull(Object val);`
* `assertSame(Type exp, Type obs);`
* `assertNotSame(Type exp, Type obs);`
* `fail();`

# Assertion Methods

The main JUnit Assertions Methods are:

* `assertEquals(String msg, Type exp, Type obs);`
* `assertEquals(String msg, double exp, double obs, double sig);`
* `assertTrue(String msg, boolean expr);`
* `assertFalse(String msg, boolean expr);`
* `assertNull(String msg, Object val);`
* `assertNotNull(String msg, Object val);`
* `assertSame(String msg, Type exp, Type obs);`
* `assertNotSame(String msg, Type exp, Type obs);`
* `fail(String msg);`

# Writing Unit Tests

**The Triple A Method**

* All Unit Tests are structured as follows:
  - Arrange: Setup the test **fixture** and any supporting dependencies/mock objects
  - Act: call the method under test on the test **fixture** to collect the expected value
  - Assert: call the specific assertions associated to evaluate the result against the expected value.

# Test Class Definition

## Definition

```java
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClassNameTest {
  // test content
}
```

# Test Method Def

## Definition

```java
@Test
public void MethodNameTest() {
    // Test Code
}
```

\pause

## Example

```java
@Test
public void convertToCentTest() {
    Temperature temp = new Temperature(32);

    assertEquals(0, temp1.convertToCent());
}
```

# Testing Strategies

* Test value selection is very important

\pause

* We need to account for the following types of values:

\pause

  * Normal values
  * Abnormal values
  * Boundary values

\pause

* Once you have created a test case you should always keep it in place, in case future modifications cause the same error.

\pause

* When thinking about what to test in Unit Testing there are two excellent acronyms: Right-BICEP and CORRECT

# Right BICEP

* Right -- Are the results \underline{right}?
\pause
* B -- are all the \underline{boundary conditions} correct?
\pause
* I -- can you check the \underline{inverse relationships}?
\pause
* C -- can you \underline{cross-check results} using other means?
\pause
* E -- can you force \underline{error conditions} to happen?
\pause
* P -- are \underline{performance characteristics} within bounds?

# CORRECT

* C -- Conformance -- does the value \underline{conform} to an expected format?
\pause
* O -- Ordering -- is the set of values ordered or unordered as appropriate?
\pause
* R -- Range -- is the value within reasonable minimum and maximum values?
\pause
* R -- Reference -- does the code reference anything external that isn't under direct control of the code itself?
\pause
* E -- Existence -- does the value exist (e.g. is not null, non-zero, present in a set)?
\pause
* C -- Cardinality -- are there exactly enough values?
\pause
* T -- Time (absolute and relative) -- is everything happening in order? At the right time? In time?

#

\vfill
\centering
\Huge Demo

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}

# For Next Time
