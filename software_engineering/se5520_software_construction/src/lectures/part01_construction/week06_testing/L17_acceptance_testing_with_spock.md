---
author:
- Isaac Griffith
title: Acceptance Testing
institute: |
  SE 5520 - Software Construction and Configuration Management

  Department of Software Engineering

  Idaho State University
fontsize: 12pt
cornerLogo: "../../../images/spirit.png"
wideLogo: "../../../images/wide.png"
lowerCornerLogo: "../../../images/roar.eps"
...

# Outcomes

At the end of Today's Lecture you will be able to:

::: columns
:::: {.column width=.7}
* Describe the basic concepts of specification testing
* Use the Spock framework to implement and execute specification tests
* Understand how Spock is useful for BDD
::::
:::: {.column width=.25}
\vskip-2em
\centering
\includegraphics[width=\textwidth]{../../../images/brain-gears.jpg}
::::
:::

# Inspiration


#

\centering
\vfill
\begin{minipage}{.75\textwidth}
\begin{minipage}{3.5em}
\vskip-3em
\includegraphics[width=\textwidth]{../../../images/bengal-black.png}
\end{minipage}
\begin{minipage}{.75\textwidth}
\Huge Spec Testing
\vskip-0.75em
\rule{\textwidth}{2pt}

\large \color{Roarange}\textbf{SE 5520}
\end{minipage}
\end{minipage}

# Why not just use JUnit or TestNG?

* JUnit and TestNG are good testing frameworks, but
  - often need an additional mocking or stubbing library
  - syntax generally limited to Java

* Spock has some built-in advantages:
  - mocking and stubbing part of core
  - succinct syntax for data driven testing
  - leverages Groovy syntax

# Do we need another framework?

* Spock incorporates the best concepts from JUnit, RSpec, jMock, and Mockito

* The answer is obviously yes; otherwise there wouldn't be this lecture, right?

* Plus Spock makes testing fun!

# How Spock Measures Up

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

* Spock does all of this

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
\footnotesize
```
CalculatorTest > testSimpleAdditon FAILED
  java.lang.AssertionError: 2+2=4 expected:<5> but was:<4>
    at org.junit.Assert.fail(Assert.java:88)
    at org.junit.Assert.failNotEquals(Assert.java:834)
    at org.junit.Assert.assertEquals(Assert.java:645)
    at CalculatorTest.testSimpleAddition(CalculatorTest.java:15)
```

**Spock Failed Test Output**
\footnotesize
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

# Will Spock play with my IDE

* Spock has a built in JUnit runner called Sputnik that makes it transparent to most Java IDE's and build tools

# Summary


# For Next Time

::: columns
:::: {.column width=.6}

::::
:::: {.column width=.4}
\centering
\includegraphics[width=.85\textwidth]{../../../images/next_time.png}
::::
:::

#

\centering
\vfill
\includegraphics[scale=.40]{../../../images/questions.png}

\Huge \textbf{Are there any questions?}
