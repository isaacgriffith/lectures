---
author:
- Isaac Griffith
title: Design By Contract
institute: |
  CS 2263

  Department of Computer Science

  Idaho State University
fontsize: 11pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Outcomes

After today's lecture you will be able to:

::: columns
:::: {.column width=.7}
* Understand the basics of Design By Contract (DbC)
* Use the Cofoja library to apply DbC in your Java Code
::::
:::: {.column width=.25}
\vskip-2em
\centering
\includegraphics[width=\textwidth]{images/brain-gears.jpg}
::::
:::

#

\centering
\vfill
\begin{minipage}{.70\textwidth}
\begin{minipage}{3.5em}
\includegraphics[width=\textwidth]{images/bengal-black.png}
\end{minipage}
\begin{minipage}{.85\textwidth}
\Huge Design by Contract
\vskip-0.75em
\rule{.875\textwidth}{2pt}

\large \color{Roarange}\textbf{CS 2263}
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

#

\centering
\vfill
\begin{minipage}{.85\textwidth}
\begin{minipage}{3.5em}
\includegraphics[width=\textwidth]{images/bengal-black.png}
\end{minipage}
\begin{minipage}{.95\textwidth}
\Huge Contracts for Java (Cofoja)
\vskip-0.75em
\rule{.9\textwidth}{2pt}

\large \color{Roarange}\textbf{CS 2263}
\end{minipage}
\end{minipage}

# Cofoja??

* An annotation processing tool which provides java with design by contract capabilities
* This allows for run-time checking (similar to assertions) rather than static checking

# Installing

* Can be used by simply adding the following dependency:

    ```java
    configurations {
      cofoja
    }

    dependencies {
      cofoja group: 'org.huoc', name: 'cofoja', version: '1.3.1'
      compile configuration.cofoja.dependencies
    }

    test {
      jvmArgs '-ea', '-javaagent:' + configurations.cofoja.files[0]
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

# Example

* An implementation of Java's `List` `add(int index, E element)` method with a contract

  ```java
  @Requires({"index >= 0", "index <= size()"})
  @Ensures({"element.equals(get(index))"})
  public void add(int index, E element) {
    // implementation
  }
  ```

# Keywords

* There are several keywords which allow DbC to work:
  - `old` - the value on method entry (applies to `@Ensures`)
  - `result` - the value to be returned (applies to `@Ensures`)

* Example:

  ```java
  @Requires("x >= 0")
  @Ensures("result == 2 * old(x)")
  static double doubleIt(double x);
  ```

# Example Old

* The `@ThrowEnsures` annotation guarantees that the exception method exits do not inadvertently alter the state of the object.
  - The keyword `signal` is used to access the exception object that was thrown

```java
class RestrictedInteger {
  int x;

  @Ensures("x == y")
  @ThrowEnsures({ "IllegalArgumentException", "x == old (x)" })
  void setX(int y) throws IllegalArgumentException {
    ...
  }
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

# Extended Example

\tiny
::: columns
:::: column
```java
import java.util.LinkedList;
import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;

@Invariant({ "elements != null",
             "isEmpty() || top() != null" }) // (1)
public class CofojaStack<T> {

  private final LinkedList<T> elements = new LinkedList<T>();

  @Requires("o != null") // (2)
  @Ensures({ "!isEmpty()", "top() == o" }) // (3)
  public void push(T o) {
    elements.add(o);
  }

  @Requires("!isEmpty()")
  @Ensures({ "result == old(top())", "result != null" })
  public T pop() {
    final T popped = top();
    elements.removeLast();
    return popped;
  }
```

::::
:::: column
```java

  @Requires("!isEmpty()")
  @Ensures("result != null")
  public T top() {
    return elements.getLast();
  }

  public boolean isEmpty() {
    return elements.isEmpty();
  }

}
```
::::
:::

# For Next Time

::: columns
:::: column
* Review this Lecture
* Read Ch 10.1 - 10.5
* Watch Lecture 27
::::
:::: column
\centering
\includegraphics[width=.85\textwidth]{images/next_time.png}
::::
:::

#

\vfill
\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
