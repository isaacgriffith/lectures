---
author:
- Isaac Griffith
title: Defensive Programming - Design By Contract
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
* Understand the basic principles of Design by Contract (DbC)
* Use the Cofoja library to apply DbC in your Java or Groovy Code
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
\Huge
\vskip-0.75em
\rule{\textwidth}{2pt}

\large \color{Roarange}\textbf{SE 5520}
\end{minipage}
\end{minipage}

# Design By Contract

These principles are about reliability. There are fundamentally two (not mutually exclusive) approaches to make software more reliable:

* Design by contract: write a clear contract on how method caller is supposed to use method, and assume caller is disciplined and obeys the contract to *e.g.* not pass a null object.

* Defensive Programming: library writer is cautious and is guarding against callers improperly *e.g.* passing null object by explicitly checking for that condition and taking appropriate action.

Another way to view it is DbC puts the onus on the *caller* and DP puts the onus on the *callee* of a method to meet the specification

# DbC Example

\begin{center}
\includegraphics[width=.85\textwidth]{images/principles/hfooand-contractual-example.jpg}
\end{center}

# DP Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/principles/hfooand-defensive-example.jpg}
\end{center}

# DbC and DP

\footnotesize
Which to do and how much?

* You should usually be doing some of both in different aspects of application
* If there is a contract make sure it is *documented* or users of API will not know about it.
* The more distant your users are (e.g., if you are writing a library), the more defensive & contractual you need to be

Tradeoffs:

* Defensive programming can slow down code due to the overhead of all the checks and raise new exceptions at runtime whereas contracts are compile-time

* Contracts are just words so code may in fact not obey the intent of the contract and without defensive programming backup something bad could happen at runtime.

# Cofoja??

* An annotation processing tool which provides java with design by contract capabilities
* This allows for run-time checking (similar to assertions) rather than static checking

# Installing

* Can be used by simply adding the following dependency:

```java
dependencies {
  compile group: 'org.huoc', name: 'cofoja', version: '1.3.1'
}
```

* Note you will need to allow annotation processing and ensure that it is correctly configured

# Basics

* We can use Cofoja to define pre- and post-conditions for our methods
  - preconditions are defined using the `@Requires` annotation
  - postconditions are defined using the `@Ensures` annotation

* We can use Cofoja to define class level invariants
  - invariants are defined using the `@Invariant` annotation

# Violations

* If we violate a precondition, a `PreconditionError` is thrown
* If we violate a postcondition, a `PostconditionError` is thrown
* If we violate an invariant, an `InvariantError` is thrown

# DbC vs. Assertions

**Advantages**

- DbC allows application logic to be separated from contract logic
- The contract is included in the JavaDoc
  * assertions force us to maintain both the contract and the documentation separately, which is error prone
- Provides enhanced defect localization and reduced debugging time
- Helps to easily determine the cause of an error

**Disadvantages**

- Lack of native language support

# Contracts and Inheritance

* The contracts defined are applicable to all objects of an associated type.
  - This includes any instances of derived classes

* Derived classes may refine contracts with additional
  - Preconditions
  - Postconditions
  - Invariants

* Derived classes may not replace inherited contracts, but
  - Preconditions may be weakened
  - Postconditions may be strengthened
  - Invariants may be strengthened

# Keywords

* There are several keywords which allow DbC to work:
  - `old` - the value on method entry (applies to `@Ensures`)
  - `result` - the value to be returned (applies to `@Ensures`)

* Example:

# Example

* An implementation of Java's `List` `add(int index, E element)` method with a contract

```java
@Requires({"index >= 0", "index <= size()"})
@Ensures({"element.equals(get(index))"})
public void add(int index, E element) {
  // implementation
}
```

# Example using result

```java
@Requires("x >= 0")
@Ensures("result >= 0")
static double(double x);
```

# Example Old

* The `@ThrowEnsures` annotation guarantees that the exception method exits do not inadvertently alter the state of the object.
  - The keyword `signal` is used to access the exception object that was thrown

```java
class RestrictedInteger {
  int x;

  @Ensures("x == y")
  @ThrowEnsures({ "IllegalArgumentException", "x == old (x)" })
  void
}
```

# Example

* An invariant to indicate that a Set may contain only unique elements

```java
@Invariant("hasUniqueElements()")
public class InvariantSet<E> {
  // implementation
}
```

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
