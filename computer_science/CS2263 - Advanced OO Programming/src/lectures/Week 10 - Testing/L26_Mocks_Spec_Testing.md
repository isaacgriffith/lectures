---
author:
- Isaac Griffith
title: Mocking and Specification Testing
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
outline: false
...

# Test Doubles

* Often our objects are hard to isolate because of interactions with other objects, databases, networks, etc.
* However, we have come up with several approaches to get around this

::: columns
:::: {.column width=.333}

\includegraphics[width=\textwidth]{images/testing/fake-inv.png}

::::
:::: {.column width=.333}

\includegraphics[width=\textwidth]{images/testing/stub-inv.png}

::::
:::: {.column width=.333}

\includegraphics[width=\textwidth]{images/testing/mock-inv.png}

::::
:::


# Mock Objects

* **Mock Objects** are dummy implementations for an interface or class

\vskip.5em

* These allow us to define the output of certain method calls

\vskip.5em

* By recording the interaction with the system

\vskip.5em

* Allowing tests to validate the outcome

<!-- https://laptrinhx.com/test-doubles-fakes-mocks-and-stubs-3097989503/ -->

# The Mocking Process

* Follows the AAA method:
  - **Arrange** - Setup the mock dependencies for the class under test
  - **Act** - Execute the code in the class under test
  - **Assert** - Validate if the code executed as expected

# Outcomes

After today's lecture you will be able to:

::: columns
:::: {.column width=.7}
* Describe the basic concepts of Mock Objects
* Use the Mockito Project to provide Mocking for JUnit Jupiter
* Describe the basic concepts of specification testing
* Use the Spock framework to implement and execute specification tests
* Understand how Spock is useful for BDD
* Evaluate the effectiveness of your tests using the code coverage tool jacoco
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
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Mock Objects
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# Mockito

* A popular open source framework for mocking Java objects

\vskip.5em

* Works in conjunction with JUnit

\vskip.5em

* Greatly simplifies the Mocking experience

\vskip.5em

* Although it does provide many great advantages it is not without its limitations...

# Mockito and Gradle

\begin{center}
We can add mockito to our gradle builds by including the following dependencies
\end{center}

```groovy
    dependencies {
        testImplementation 'org.mockito:mockito-inline:4.0.0'
        testImplementation 'org.mockito:mockito-junit-jupiter:4.0.0'
    }
```

# Mockito Mock Objects

* There are several ways to create mock objects with Mockito

\vskip.5em

* The two basic approaches are by either:
  - Using the `@Mock` annotation
  - Using the static `mock()` method

\vskip.5em

* **Note:** if you use the `@Mock` annotation, you will need to trigger the initialization of annotated fields
  - This can be done using `@ExtendWith(MockitoExtension.class)` annotation on the test class

# Example

::: columns
:::: column
\scriptsize **Let's start with the data model**

\tiny
```java
public class Database {
  public boolean isAvailable() {
    return false;
  }
  public int getUniqueId() {
    return 42;
  }
}

public class Service {
  private Database database;

  public Service(Database database) {
    this.database = database;
  }

  public boolean query(String query) {
    return database.isAvailable();
  }

  @Override
  public String toString() {
    return "Using database with id: " +
      String.valueOf(database.getUniqueId());
  }
}
```

::::
:::: column

**Add the test with Mocks**

\tiny
```java
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ServiceTest {

    @Mock
    Database databaseMock;

    @Test
    public void testQuery()  {
        assertNotNull(databaseMock);
        when(databaseMock.isAvailable()).thenReturn(true);
        Service t  = new Service(databaseMock);
        boolean check = t.query("* from t");
        assertTrue(check);
    }
}
```

::::
:::

#

\centering
\vfill
\begin{minipage}{.375\textwidth}
{
\includegraphics[width=13pt]{images/mark.png}
\Huge Spec Testing
}
\vskip-.5em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# Why not just use JUnit or TestNG?

* JUnit and TestNG are good testing frameworks, but
  - often need an additional mocking or stubbing library
  - syntax generally limited to Java

\vskip.5em

* Spock has some built-in advantages:
  - mocking and stubbing part of core
  - succinct syntax for data driven testing
  - leverages Groovy syntax

# Do we need another framework?

* Spock incorporates the best concepts from JUnit, RSpec, jMock, and Mockito

\vskip.5em

* The answer is obviously yes; otherwise there wouldn't be this lecture, right?

\vskip.5em

* Plus Spock makes testing fun!

# How Spock Measures Up

::: columns
:::: column

* Unit Testing
  - JUnit
  - TestNG
* Mocking and Stubbing
  - EasyMock
  - jMock
  - Mockito
  - PowerMock
  - jMockit
* BDD
  - Cucumber
  - JBehave

::::
:::: column

\centering

The Spock Framework does all of this

\vskip.5em

\includegraphics[width=.65\textwidth]{images/testing/spock.png}

* Additionally, Spock has a built in JUnit runner called Sputnik that makes it transparent to most Java IDE's and build tools

::::
:::

# Comparison to JUnit Concepts

+--------------------+---------------------+
| JUnit              | Spock               |
+:===================+:====================+
| Test Class         | Specification       |
+--------------------+---------------------+
| Test               | Feature             |
+--------------------+---------------------+
| Test Method        | Feature method      |
+--------------------+---------------------+
| @Before            | setup()             |
+--------------------+---------------------+
| @After             | cleanup()           |
+--------------------+---------------------+
| Assertion          | Condition           |
+--------------------+---------------------+
| @TEST(expected...) | Exception condition |
+--------------------+---------------------+

# Simple Broken Tests

::: columns
:::: column
**JUnit**

\footnotesize
```java
public class CalculatorTest {
  Calculator calculator;

  @Before
  public void setup() {
    calculator = new Calculator();
  }

  @Test
  public void testSimpleAddition() {
    assertEquals("2+2=4", 5,
        calculator.add(2, 2));
  }
}
```
::::
:::: column
**Spock**
\footnotesize
```java
class CalculatorSpec extends Specification {
  def calculator

  def setup() {
    calculator = new Calculator()
  }

  def "Test Simple Addition"() {
    expect:
      calculator.add(2, 2) == 5
  }
}





```
::::
:::

# Simple Broken Test Results

**JUnit Failed Test Output**
\scriptsize
```
CalculatorTest > testSimpleAdditon FAILED
  java.lang.AssertionError: 2+2=4 expected:<5> but was:<4>
    at org.junit.Assert.fail(Assert.java:88)
    at org.junit.Assert.failNotEquals(Assert.java:834)
    at org.junit.Assert.assertEquals(Assert.java:645)
    at CalculatorTest.testSimpleAddition(CalculatorTest.java:15)
```

**Spock Failed Test Output**
\scriptsize
```
CalculatorSpec > Test Simple Addition FAILED
    Condition not satisfied:

    calculator.add(2,2) == 5
    |          |        |
    |          4        false
    Calculator@11dd18e
        at CalculatorSpec.Test Simple Additon(CalculatorSpec.groovy:13)
```

# Spruced up using Spock Parameterization

```java
class CalculatorSpec extends Specification {
  @Unroll
  def "#a + #b = #c"() {
    setup:
      def calculator = new Calculator()
    expect:
      calculator.add(a, b) == c
    where:
      a | b || c
      2 | 2 || 4
      2 | 2 || 5
  }
}
```

# Parameterized Test Output

**Spock Passed Test Output:**

```
CalculatorSpec > 2 + 2 = 4 PASSED
```

**Spock Failed Test Output:**

```
CalculatorSpec > 2 + 2 = 5 FAILED
    Condition not satisfied:

    calculator.add(a,b) == c
    |          |   | |  |  |
    |          4   2 2  |  5
    Calculator@11dd18e  false
        at CalculatorSpec.#a + #b = #c(CalculatorSpec.groovy:19)
```

# Spock and Mocking

```java
def "Mocked calculator"() {
  setup:
    def calculator = Mock(Calculator)
  when:
    calculator.add(2,2)
  then:
    1 * calculator.add(2,2)
}
```

# Spock and Mocking

```java
def "Mocked calculator"() {
  setup:
    def calculator = Mock(Calculator)
  when:
    calculator.add(2,2)
  then:
    1 * calculator.add(2,2)
    0 * calculator.add(_,_)
}
```

# Spock and Stubbing

```java
def "Stubbed calculator"() {
  setup:
    def calcultor = Stub(Calculator) {
      add(2,2) >> 4
    }
  expect:
    calculator.add(a,b) == c
  where:
    a | b || c
    2 | 2 || 4
}
```

# Spock and Stubbing

```java
def "Stubbed calculator"() {
  setup:
    def calcultor = Stub(Calculator) {
      add(2,2) >> 4
      add(_,_) >> {x, y -> x + y}
    }
  expect:
    calculator.add(a,b) == c
  where:
    a | b || c
    2 | 2 || 4
    3 | 3 || 6
    4 | 3 || 7
}
```

# Spock and BDD

::: columns
:::: column
**Classic Example of BDD:**

\vskip.5em

**Scenario**: Multiple Givens

**Given:** one thing

**And:** another thing

**And:** yet another thing

**When:** I open my eyes

**Then:** I see something

**But:** I don't see something else
::::
:::: column
**Valid Spock Code**

```java
def "Multiple Givens"() {
  given: "one thing"
  and: "another thing"
  and: "yet another thing"
  when: "I open my eyes"
  then: "I see something"
  and: "I don't see something else"
}
```
::::
:::

# Spock plus BDD and Parameterization

```java
@Unroll
def "BDD: #a + #b = #c"() {
  given: "a new calculator"
    def calculator = new Calculator()
  and: "nothing is done to the calculator before addition"
  when: "adding two values together"
    def sum = calculator.add(a, b)
  then: "the result is the expected sum"
    c == sum
  where:
    a | b || c
    2 | 2 || 4
    3 | 2 || 5
}
```

#

\centering
\vfill
\begin{minipage}{.415\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Code Coverage
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# What is Code Coverage?

* **Code coverage** is a metric used to evaluate a test suite

\vskip.5em

* Essentially it evaluates how much of a program was executed by the test suite

\vskip.5em

* Thus, it returns a percentage value:
  - Across each method
  - Across each class
  - Across each package
  - Across the entire program

\vskip.5em

* Coverage also gives us the ability to determine when we can stop testing a system.
  - Our goal with testing is to simply cover the entire program
  - Thus, we need only write enough tests to achieve 100% coverage

# Coverage with Jacoco

* Jacoco is a tool which works with your test environment to determine how much coverage your tests provide.

\vskip.5em

* It informs us the percentage of lines covered by the tests executed
  - Show this at the Package, class, and method level

\vskip.5em

* The ultimate goal is to achieve 100% code coverage, but often this is not possible.
  - Thus, a good stopping goal is 85% code coverage

# Using Jacoco

::: columns
:::: column

**build.gradle**

\tiny

```java
plugins {
  id 'jacoco'
}

jacoco {
  toolVersion = "0.8.6"
  reportsDirectory = file("$builddir/jacoco")
}

test {
  // report is generated after tests run
  finalizedBy jacocoTestReport
}

jacocoTestReport {
  // tests are required to run first
  dependsOn test
  reports {
    xml.enabled false
    csv.enabled false
    html.destination file("${buildDir}/jacocoHtml")
  }
}
```

::::
:::: column

* Jacoco works with the `test` phase of the build

\vskip.5em

* Adds the following tasks:
  - **jacocoTestCoverageVerification** - verifies code coverage metrics based on specified rules for the test task
  - **jacocoTestReport** - generates the code coverage report for the test task

::::
:::

# Setting Coverage Goals

::: columns
:::: column

**build.gradle**

\scriptsize
```java
jacocoTestCoverageVerification {
    violationRules {
        rule {
            limit {
                counter = 'LINE'
                value = 'COVEREDRATIO'
                minimum = 0.85
            }
        }
    }
}
```

* Rules can note the element (`CLASS`, `LINE`, `METHOD`, etc)

\vskip.5em

* Rules can also have an includes and excludes section both of which contain a list of classes

::::
:::: column

* \footnotesize This rule states that we have a minimum of 85% line coverage

\vskip.25em

* \footnotesize We could also replace "`LINE`" with:
  - \scriptsize `BRANCH` - number of execution branches
  - \scriptsize `CLASS` - number of classes
  - \scriptsize `INSTRUCTION` - number of code instructions
  - \scriptsize `METHOD` - number of methods

\vskip.25em

* \footnotesize We can replace the value "COVEREDRATIO" with:
  - \scriptsize `COVEREDCOUNT` - absolute number of covered items
  - \scriptsize `MISSEDCOUNT` - absolute number of items not covered
  - \scriptsize `MISSEDRATIO` - ratio of items not covered
  - \scriptsize `TOTALCOUNT` - total number of items

::::
:::

# For Next Time

::: columns
:::: column
* Review the Moodle Mocking and Spec Testing Resources
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
