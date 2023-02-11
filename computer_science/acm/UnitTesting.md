---
author:
- Isaac Griffith
title: Software Testing
institute: |
  ACM Student Chapter

  Department of Informatics and Computer Science

  Idaho State University
titlegraphic: '`images/acm_logo.eps`{=latex}'
fontsize: 12pt
...

# Introduction
\centering
\includegraphics[width=.875\textwidth]{images/testing/testing_wordcloud.eps}

# Types of Testing
\vspace{-2em}
\centering
\includegraphics[width=.75\textwidth]{images/testing/auto_manual.eps}

# Testing Methods

::: columns

:::: [.column width=33%]
\vspace{-1.5em}
\centering
\includegraphics[width=.9\textwidth]{images/testing/black_box_testing.eps}

**Advantages**

* Handles large Code Segments
* Code not required

**Disadvantages**

* Limited coverage
* Inefficient testing
* Difficult to design

::::

:::: [.column width=34%]
\vspace{-1.5em}
\centering
\includegraphics[width=.9\textwidth]{images/testing/gray_box_testing.eps}
::::

:::: [.column width=33%]
\vspace{-1.5em}
\centering
\includegraphics[width=.9\textwidth]{images/testing/white_box_testing.eps}
::::

:::

# Testing Methods

::: columns

:::: [.column width=33%]
\vspace{-1.5em}
\centering
\includegraphics[width=.9\textwidth]{images/testing/black_box_testing.eps}
::::

:::: [.column width=34%]
\vspace{-1.5em}
\centering
\includegraphics[width=.9\textwidth]{images/testing/gray_box_testing.eps}

**Advantages**

* Combined benefits of Black and White box testing
* Relies on Contracts
* User-centric

**Disadvantages**

* Limited coverage
* Tests may be redundant
::::

:::: [.column width=33%]
\vspace{-1.5em}
\centering
\includegraphics[width=.9\textwidth]{images/testing/white_box_testing.eps}
::::

:::

# Testing Methods

::: columns

:::: [.column width=33%]
\vspace{-1.5em}
\centering
\includegraphics[width=.9\textwidth]{images/testing/black_box_testing.eps}
::::

:::: [.column width=34%]
\vspace{-1.5em}
\centering
\includegraphics[width=.9\textwidth]{images/testing/gray_box_testing.eps}
::::

:::: [.column width=33%]
\vspace{-1.5em}
\centering
\includegraphics[width=.9\textwidth]{images/testing/white_box_testing.eps}

**Advantages**

* Helps to optimize code
* Can find hidden defects
* Maximizes coverage

**Disadvantages**

* High cost for high skill
* Difficult to maintain

::::

:::

# Testing Levels

::: columns

:::: column

\Large Typical Levels of Testing
\centering
\includegraphics[width=.95\textwidth]{images/testing/testing_pyramid.eps}

::::

:::: column

\Large Developer Testing Levels
\centering
\includegraphics[width=.70\textwidth]{images/testing/dev_test_pyramid.eps}

::::

:::

# Unit Testing
\centering
\includegraphics[width=.75\textwidth]{images/testing/utlc.png}

# Unit Testing Strategies
\centering
\includegraphics[width=.9\textwidth]{images/testing/strategies.eps}

# Unit Testing C#

::: columns

:::: column

\Large Creating Unit Tests

1. From the code editor window, right-click and choose Create Unit Tests from the context menu.
2. Click OK to accept the defaults to create your unit tests, or change the values used to create and name the unit test project and the unit tests.
3. The unit test stubs are created in a new unit test project for all the  methods in the class.

::::

:::: column

\Large The AAA Method
\centering
\includegraphics[width=.5\textwidth]{images/testing/aaa_method.eps}

::::

:::

# The AAA Method

The AAA (Arrange, Act, Assert) pattern is a common way of writing unit tests for a method under test.

* The Arrange section of a unit test method initializes objects and sets the value of the data that is passed to the method under test.

* The Act section invokes the method under test with the arranged parameters.

* The Assert section verifies that the action of the method under test behaves as expected.

# Unit Testing C#

```CSharp
[TestMethod]
public void Withdraw_ValidAmount_ChangesBalance()
{
  // arrange
  double currentBalance = 10.0;
  double withdrawal = 1.0;
  double expected = 9.0;
  var account = new CheckingAccount("JohnDoe", currentBalance);
  // act
  account.Withdraw(withdrawal);
  double actual = account.Balance;
  // assert
  Assert.AreEqual(expected, actual);
}
```

#

\centering
\Huge Demo

# 7 Deadly Sins of Unit Testing
\vspace{-1.5em}
\centering
\includegraphics[width=.85\textwidth]{images/testing/7sins.eps}

# Test Driven Development
\vspace{-1.5em}
\centering
\includegraphics[width=.70\textwidth]{images/testing/TDD.eps}

#

\centering
\Huge Demo

#

\centering
\Huge Active Learning

\includegraphics[width=.85\textwidth]{images/testing/door.eps}

# Connections

::: columns

:::: column
\vspace{-2em}
\centering
\includegraphics[width=.75\textwidth]{images/testing/bdd_tdd.eps}
::::

:::: column
\vspace{-2em}
\centering
\includegraphics[width=.75\textwidth]{images/testing/devops.eps}
::::

:::

\vspace{-3em}
\centering
\includegraphics[width=.35\textwidth]{images/testing/sdlc.eps}

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge **Are there any questions?**
