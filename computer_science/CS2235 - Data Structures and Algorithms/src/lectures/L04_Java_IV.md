---
author:
- Isaac Griffith
title: Java IV
institute: |
  CS 2235

  Department of Informatics and Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

#

\vfill
\centering
\Huge Java IV

# Outcomes

At the end of Today's Lecture you will be able to:

* Be able to explain the basic principles of OO
* Be able to describe what Abstract Data Types are
* Use generics in Java
* Define class hierarchies in Java
* Be able to describe polymorphism and how it works in Java

#

\vfill
\begin{center}
{\Huge Java Generics}
\end{center}

# Object-Oriented Software Design

* Responsibilities: Divide the work into different actors, each with a different responsibility. These actors become classes.

* Independence: Define the work for each class to be as independent from other classes as possible.

* Behaviors: Define the behaviors for each class carefully and precisely, so that the consequences of each action performed by a class will be well understood by other classes that interact with it.

# Software must be

* **Correct:** works correctly on all expected inputs
* **Readable:** easily understandable & verifiable by others
* **Robust:** capable of handling unexpected inputs that are not explicitly defined for its intended application
* **Efficient:** makes good use of computing time & memory resources.
* **Adaptable:** able to evolve over time in response to changing conditions in its environment. Is easy to update & debug.
* **Flexible:** easily generalizable to handle many related scenarios.
* **Reusable:** the same code should be usable a a component of different systems in various applications.

# Object-Oriented Design Principles

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module1/Java/oodp}
\end{center}

# Abstraction

* **Abstraction** is to distill a system to its most fundamental parts.
  - _The psychological profiling of a programmer is mostly the ability to shift levels of abstraction, from low level to high level. To see something in the small and to see something in the large._ -- Donald Knuth


# Encapsulation

* Information hiding.

* Objects reveal only what other objects need to see.

* Internal details are kept private

* This allows the programmer to implement the object as they wish, as long as the requirements of the abstract interface are satisfied.

# Modularity

* Complex software systems are hard to conceptualize, design & maintain.
* This is greatly facilitated by breaking the system up into distinct modules.

* Each module has a well-specified role.
* Modules communicate through well-specified interfaces.
* The primary unit for a module in Java is a package.

# A Hierarchy

\vspace{-2em}
\begin{center}
\includegraphics[width=.65\textwidth]{images/Module1/Java/hierarchy}
\end{center}

# Hierarchical Design

Hierarchical class definitions allow efficient re-use of common software over different contexts.

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module1/Java/hierarchical_design.png}
\end{center}

#

\vfill
\begin{center}
{\Huge Activity 1}
\end{center}

#

\vfill
\begin{center}
{\Huge ADTs}
\end{center}

# Abstract Data Types

* **Abstraction** is to distill a system to its most fundamental parts.
* Applying the abstraction paradigm to the design of data structures gives rise to **abstract data types** (ADTs) with state (data) & behavior (functionality).
* An ADT is a model of a data structure that specifies the **type** of data stored, the **operations** supported on them, and the types of parameters of the operations.
* An ADT specifies **what** each operation does, but not **how** it does it.
  - The "**how**" is provided by the **software** that implements the ADT.
* The collective set of behaviors supported by an ADT is its **public interface**. The interface guarantees certain **invariants**.
* **Invariant:** a fact about the ADT that is always true, e.g., a Date object always represents a valid date.

# Class Definitions

* A **class** serves as the primary means for abstraction in OOP.
* In Java, every variable is either a base type or is a reference to an **object** which is an **instance** of some class.
* Each class presents to the outside world a concise and consistent view of the objects that are its instances, without revealing too much unnecessary detail or giving others access to the inner workings of the objects.
* The class definition specifies its members. These are typically **instance variables** (aka, **fields** or **data members**) that any instance object contains, as well as the **methods**, (aka, **member functions**) that the object can execute.

# Unified Modeling Language (UML)

* A **class diagram** has three parts:
  1. The name of the (concrete or abstract) class or interface
  2. The recommended instance variables or fields
  3. The recommended methods of the class.

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module1/Java/uml}
\end{center}

# Interfaces

* The main structural element in Java that enforces an application programming interface (API) is an interface.

* An **interface** contains constants & abstract methods with no bodies; all public by default.

* It has no constructors & can't be directly instantiated.

* A class that implements an interface, must implement **all** of the methods declared in the interface (no inheritance) or it must be declared abstract, otherwise it won't compile.

# Abstract Classes

* An **abstract class** also cannot be instantiated, but it can define one or more methods that all implementations of the abstraction will have.

* Their sole purpose is to be extended.

* A class must be a subclass of an abstract class to **extend** it & implement all its abstract methods (or else be abstract itself).


# Interfaces & Abstract Classes

* A class that implements an **interface**, must implement **all** of the method declared in the interface (no inheritance); otherwise it won't compile.

* As a result, unlike abstract classes, interfaces are non-adaptable: you can't add new methods to it without breaking its contract.

* However, interfaces offer great flexibility for their implementers: a class can **implement** any number of interfaces, regardless of where that class is in the class hierarchy.

# Inheritance

* is a mechanism for modular and hierarchical organization
* A (child) **subclass extends** a (parent) **superclass**.
* A subclass inherits (non-constructor) members of its superclass.

* Two ways a subclass can differ from its superclass:

  - Can **extend** the superclass by providing brand-new data members & methods (besides those inherited from the superclass, other than constructors).
  - **Polymorphism:** may specialize an existing behavior by providing a new implementation to **override** an existing non-static method of the superclass.


# Java is Single Inheritance

* Java (unlike C++) is a **single inheritance** OOL: any class other than the root class **Object**, \textit{extends exactly one} parent superclass. That is, Java classes form a **tree hierarchy**.

* Regardless of where it is in the inheritance tree, a class can _implement several interfaces._

This is {\color{Roarange} multi-role playing} (aka, {\color{Roarange} mixin}), **not** multiple inheritance.

# Class Inheritance Tree Hierarchy

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module1/Java/class_tree}
\end{center}

# Class/Interface DAG Hierarchy

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module1/Java/class_dag}
\end{center}

# Constructors

* A user can create an instance of a class by using the **new** operator with a method that has the same name as the class.

* Such a method, known as a **constructor**, establishes a new object with appropriate initial values for its instance variables.

# Inheritance and Constructors

* **Constructors are never inherited in Java;** hence, every class must define a constructor

  - Which can refine a superclass constructor.
  - Must properly initialize all class fields, including any inherited fields.

* The first operation within the body of a constructor must be to invoke a constructor of the superclass, which initializes the fields defined in the superclass.
* A constructor of the superclass is invoked explicitly by using the keyword **super** with appropriate parameters.
* If a constructor for a subclass does not make an explicit call to **super** or **this** as its first command, then an implicit call to **super**(), the zero-parameter version of the superclass constructor, will be made.

#

\vfill
\begin{center}
{\Huge Activity 2}
\end{center}

#

\vfill
\begin{center}
{\Huge Polymorphism}
\end{center}

# Polymorphism

* **Polymorphism:** means taking on many forms
* **Example:** `Super var = new Sub(...);`

says `var` is declared as `Super` type, but is instanceof and references an object of `Sub` type.

* `var` is **polymorphic**; it can take one of many forms, depending on the specific class or subclass of the object to which it refers at runtime.

# Dynamic Dispatch

* With polymorphism, one method works on many classes, even if the classes need different implementations of that method.
* **Dynamic dispatch** is a process used by the JVM at runtime to call the version of the overridden method most specific to the actual (dynamic) type, not declared (static) type, of the polymorphic variable `var`.

* **Example:** `Super var = New Sub(...);`

Suppose we call `var.myMethod`

and at runtime `(var instanceof Sub)` is **true**

will the JVM execute `var.(Sub.myMethod)` or `var.(Super.myMethod)`?

* The JVM calls `Sub.myMethod`, since `var` refers to an instance of `Sub`, even though its static type is `Super`.

# Overriding vs. Overloading

* **Overridden** method selection is **dynamic** (uses dynamic dispatch)
* **Overloaded** method selection is **static**, based on compile-time type of the parameters.
* Because overriding is the norm and overloading is the exception, overriding sets people's expectations for the behavior of method invocation.
* Most often, instead of overloading, we can use different names.
* **Constructors** can't use different names & are typically overloaded, but fortunately they cannot be overridden!

## Motto
Avoid confusing uses of overloading


# Example: Overriding
```java
  // What does this program print?
  public class Wine {
      String name() { return "wine"; }
  }
  public class SparklingWine extends Wine {
      @Override String name() { return "sparkling wine"; }
  }
  public class Champagne extends SparklingWine {
      @Override String name() { return "champagne"; }
  }
  public class Overriding {
      public static void main(String[] args) {
          Wine[] wines = {new Wine(), new SparklingWine(), new Champagne()};
          for (Wine wine : wines) System.out.println(wine.name());
      }
  }
```

# Example: Overloading

```java
  // Broken! What does this program print?
  public class WineRegion {
      public static String region (Wine w) { return "Napa Valley"; }
      public static String region (SparklingWine s) { return "Niagara"; }
      public static String region (Champagne c) { return "France"; }

      public static void main(Stirng[] args) {
          Wine[] wines = {
              new Wine(),
              new SparklingWine(),
              new Champagne()
          };
          for (Wine w : wines) System.out.println(region(w));
      }
  }
```

# Example: Overloading -- fixed

```java
  // Fixed by a single method that does an explicit instanceof test
  public class WineRegion {
      public static String region(Wine w) {
          return (w instanceof Champagne) ? "France" :
                ((w instanceof SparklingWine) ? "Niagara" : "Napa Valley");
      }
      public static void main(Stirng[] args) {
          Wine[] wines = {
              new Wine(),
              new SparklingWine(),
              new Champagne()
          };
          for (Wine w : wines) System.out.println(region(w));
      }
  }
```

# Class Definition Syntax

```java
  class SubClass extends SuperClass implements Interface1, Interface2 {
      // definitions of non-inherited instance variable
      // subclass constructors
      // overridden superclass methods
      // other, inherited, superclass methods omitted
      // implementation of all interface methods
      // brand-new method
  }
```

# Interface Definition Syntax

```java
  interface YourNewInterface extends YourInterface1, YourInterface2 {
      ...
  }
```

# Example

```java
  abstract class Figure {
      abstract double area();
  }
  class Circle extends Figure {
      final double radius;
      Circle(double radius) { this.radius = radius; }
      double area() { return Math.PI * radius * radius; }
  }
  class Rectangle extends Figure {
      final double length, width;
      Rectangle (double length, double width) {
          this.length = length;
          this.width = width;
      }
      double area() { return length * width; }
  }
  class Square extends Rectangle {
      Square (double side) { super(side, side); }
  }
```

#

\vfill
\begin{center}
{\Huge Generics}
\end{center}

# Generics

* Java includes support for writing **generic** types that can operate on a variety of data types while avoiding the need for explicit casts & with type safety through compile-time type-checking.

* Prior to generics (as of Java SE 5), **Object** was used as the universal super-type. Disadvantages:

  * frequent casting to specific actual type.
  * thwarted compiler's type-checking mechanism

* The generics framework allows us to define a class in terms of a set of **formal type parameters**, undefined at compile time, which can then be used as the declared **non-primitive** type for variables, parameters, and return values within the class definition.

* Those formal type parameters are later specified by **actual type arguments** when using the generic class as a type elsewhere in a program.

# Syntax for Generics


* **Example:** a generic paired item by composition:

```java
  public class Pair<A, B> {
     A first;
     B second;

     public Pair(A a, B b) {
        first = a;
        second = b;
     }

     public A getFirst() { return first; }
     public B getSecond() { return second; }
  }
```

* Can be re-used to instantiate any paired item:

  * Person: (String name, Integer age);
  * Stock-ticker: (String stock, Double price);
  * 2D point: (Double x, Double y);

# Type inference with generics

1.
```java
        // declare explicit actual type
        Pair<String, Double> bid;
```

2.
```java
        // instantiate by explicit actual type
        bid = new Pair<>("ORCL", 32.07);
```

3.
```java
        // combined declaration & instantiation
        Pair<String, Double> bid = new Pair<>("ORCL", 32.07);
```
4.
```java
        String stock = bid.getFirst();
        double price = bid.getSecond(); // auto unboxing
```

# Bounded Generics

* **Wild-card "?"** stands for "any class or interface"

* **Bounded generics** with wild-cards

`<? extends T>`

stands for any subtype of T: any class or interface in the hierarchy rooted at the type represented by the generic type T.

`<? super T>`

stands for any supertype of T: the generic type `<T>` or higher up in its hierarchy (as direct or indirect super-class or super-interface).

* **Recursive type bounding:**

e.g., `<T extends Comparable<T>>`

may be read as: "for any type T that can be compared to itself"

# Generic Methods

```java
  public class GenericDemo {

     // modifier <T> indicates this is a generic method
     public static <T> void reverse(T[] data) {
        int low = 0, high = data.length - 1;
        while (low < high) { // swap data[low] & data[high]
           T temp = data[low];
           data[low++] = data[high]; // post-increment low
           data[high--] = temp; // post-decrement high
        }
     }
  }
```

\color{Roarange} A call to `reverse(arr)` reverse elements of array `arr` of any declared reference type.

# Bounded wildcards increase API flexibility

* For maximum flexibility, use wildcard types on input parameters that represent **producers** or **consumers**.
* Don't use wildcards on return types.

\begin{block}{Motto}
PECS stands for producer-extends, consumer-super.
\end{block}

* **Example:** method **max(list)** returns the maximum element of **list**. This needs elements of **list** to be **Comparable** so that we can apply the **compareTo** method on them.

  * \color{Roarange} max: list is producer, Comparable is consumer.
  * The attempted generic solutions follow:


# Bounded wildcards...

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module1/Java/bounded_wildcards}
\end{center}

# Bounded wildcards...

```java
  public static <E extends Comparable<? super E>>
  E max(List<? extends E> list) {
     ...
  }
```

# Nested Classes

* a class definition nested inside the definition of another class.
* There are 4 kinds of nested classes:

  * **static, non-static, anonymous, local**. All but the first are called inner classes.

* The main use for nested classes is when defining a class that is strongly affiliated with another class.

  * Enhances encapsulation & reduces undesired name conflicts

* Nested classes are a valuable technique to implement data structures. A nested class can be used to represent a small portion of a larger data structure, or an auxiliary class that helps navigate a primary data structure.

#

\vfill
\begin{center}
{\Huge Activity 4}
\end{center}

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}

# For Next Time

1. Review Lectures 1 - 4
2. Read Chapter 5 on Recursion
3. On Monday start looking into Programming Assignment 01
4. On Monday start looking into Programming Project 01
5. Enjoy your weekend (last free one without homework in this class)
6. Come to class Tuesday
