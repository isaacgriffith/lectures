---
author:
- Dr. Isaac Griffith
title: Java Review II
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

After today's lecture you will:

::: columns
:::: {.column width=.7}
* Understand how to define the different member types
  - Fields including Constants and Enum Literals
  - Methods including Constructors and Destructors
  - Initializers
  - Contained Types
* Understand the basic statements types
  - Basic I/O
  - Flow Control
    - Selection: If/Switch
    - Iteration: For, ForEach, While, Do..While
* Understand the basics of Functional Programming in Java
::::
:::: {.column width=.25}
\vskip-2em
\centering
\includegraphics[width=\textwidth]{images/brain-gears.jpg}
::::
:::

# What's in it for Me?

Before we start this lecture, I would like you to:

1. Take out a sheet of paper
2. On this piece of paper, write the following:
   - One thing you feel you know well from the list of outcomes
   - Two things you want to know more about from the list of outcomes.
3. Pause the lecture and complete the list.
4. When you are finished, resume the lecture.

#

\centering
\vfill
\begin{minipage}{.45\textwidth}
\begin{center}
\includegraphics[width=22pt]{images/bengal-black.png}
\Huge Type Members
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# Type Members

* All types contain zero or more of the following members:
  - Fields
    * Constants
    * Enum Literals
  - Methods
    - Constructors
    - Destructors
  - Initializers
  - Contained Types

# Fields

* Provide the ability to store data local to a specific class and shared across all methods of the class, there are two forms:
  - **Instance Fields:** variables whose values are local to a specific object instance of the class
  - **Class Fields:** variables whose values are local to a specific class but not to any specific instance

**Examples**:

```java
public class A {
  // instance fields
  private int width;
  private int height;

  // class fields
  private static int x;
  private static int y;
}
```

# Constants

\footnotesize

* Constants provide the ability to repeatedly reference values that never change
* Useful, so that we can write them once and reference them many times
  - \scriptsize If the value changes, we need only change it once.
* Though, I would suggest probably reading constants in rather than programming them in
* Constants are defined as variables with the following modifiers:
  - \scriptsize `public` can be accessed by anyone (though you could use any access modifier)
  - \scriptsize `static` belong to the class, not an object instance, in which they are declared
  - \scriptsize `final` cannot be modified
* Typically have all caps names
* Note: all variables defined in Interfaces are constants

**Examples**

```java
public static final double PI = 3.14159265359;
public static final double E = 2.71828182845;
public static final double G = 9.8;
```

# Methods

* Methods define the behavior, or functionality, of a class
* There are several types of methods that can be defined
  - Instance Methods defined within a Class, Enum, or Record
    * Accessors and Mutators defined within a Class or Enum
  - Static Methods defined within a Class, Enum, or Record
  - Constructors and Destructors within a Class or Enum
  - Interface Methods defined within an Interface
    * Default Methods defined within an Interface

# Instance Methods

* These are the basic building blocks of programming in Java
* Provide all functionality (or behavior) for all programs
* Have four parts:
  - Return type - The type of value to be returned (Java only allows one)
  - Method Name - The name of the method (not necessarily unique)
  - Parameters - The inputs to the method
  - Body - the section containing the code (if the method is not abstract)

**Example**

```java
public abstract int multiply(int a, int b);

public void printArray(int[] array) {
  // do something
}
```

# Method Overloading/Overriding

::: columns
:::: column

\footnotesize

**Overloading**: having multiple methods with the same name, but with

  - A different set of parameters, and/or
  - A different return type
  - **Note:** It is better to have one method overloaded than two methods that do the same thing

**Example:**

```java
public class Test {
  int myMethod(int x) {}
  float myMethod(float x) {}
  double myMethod(double x, double y) {}
}
```

::::
:::: column

\footnotesize

**Overriding**: defining a method in a subclass with the same signature as a method in an ancestor class

  - Typically done to provide additional functionality
  - If you override a method, you should call the `super` form to utilize the functionality from the ancestor class
    * \scriptsize otherwise, you are violating good OOP

**Example:**

\scriptsize

```java
public class A {

  int myMethod(int x) {}
}

public class B extends A {

  int myMethod(int x) {
    super.myMethod(x);
  }
}
```

::::
:::

# Final Methods

* Final methods are those declared with the `final` modifier
* These methods cannot be overridden by subclasses
* Represent the final form of the method
  - Thus you cannot have a method that is both `abstract` and `final`

**Example**

```java
public final int multiply(int a, int b) {

}
```

# Default Methods

\footnotesize

* A special form of a method used only in interfaces
* This provides a default implementation of an interface method
  - \scriptsize Though it may be overridden by implementing classes
  - \scriptsize Provides binary compatibility with systems written for older versions of the interface

**Example:**

\scriptsize

```java
import java.time.*;

public interface TimeClient {
  void setTime(int hour, int minute, int second);
  void setDate(int day, int month, int year);
  void setDateAndTime(int day, int month, int year,
                 int hour, int minute, int second);
  ZoneId getZoneId (String zoneString);
  String getLocalDateTime();

  default ZonedDateTime getZonedDateTime(String zoneString) {
    return ZonedDateTime.of(getLocalDateTime(), getZoneId(zoneString));
  }
}
```

# Constructors

::: columns
:::: column

\footnotesize

* A special method used to setup a new instance of a class
* Java provides a default no-parameter, empty constructor.
  - \scriptsize If you implement a constructor then the default is no longer provided
  - \scriptsize If you implement one or more constructors, all subclasses must call at least one from their own constructor
    * \tiny Called using `super(...)` which must be the first line of the child constructor
  - \scriptsize You can also call other constructors from the same class
    * \tiny Called using `this(...)` and must be the first line of the constructor
* Must be named the same as the class containing it
* Has no return type

::::
:::: column

**Example:**

\scriptsize

```java
public abstract class Vehicle {
  protected int year;

  public Vehicle(int year) {
    this.year = year;
  }
}

public class Car extends Vehicle {

  private String make, model;

  public Car() {
    this("Ford", "F150", "2021")
  }

  public Car(String make, String model, int year) {
    super(year)
    this.make = make;
    this.model = model;
  }
}
```

::::
:::

# Destructors

::: columns
:::: column

* Destructors are similar to constructors, but rather than setup an instance, they tear them down
* In Java, this functionality is provided in the superclass `java.lang.Object` in the method `finalize()`
* `finalize()` is called by the Garbage Collector when an object is removed from the heap
* It is useful if you have any resources that need to be removed, when an instance is removed

::::
:::: column

**Example:**

```java
public class TestA {

  @Override
  public void finalize() {
    // do something
  }
}
```

::::
:::

# Contained Types

**Example:**

```java
public class TestA {

  enum ItemType {}

  class ContainedItem {}
}
```

# Initializers

::: columns
:::: column

* Provides the ability to execute code upon the creation of an object or upon the class loading (static form).
* **Note:** if there are multiple initializers, they are executed in the order in which they occur in the class

::::
:::: column

**Example**:

```java
public class Test {
  int x, y;
  long id;
  static long ID;

  {
    x = 0;
    y = 1;
    id = ID++;
  }

  static {
    ID = 0;
  }
}
```

::::
:::

#

\centering
\vfill
\begin{minipage}{.375\textwidth}
\begin{center}
\includegraphics[width=22pt]{images/bengal-black.png}
\Huge Statements
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# Basic Input and Output

::: columns
:::: column

\scriptsize

**Basic Input:**

1. `BufferedReader` class
   - \tiny This may throw an exception

   ```java
   BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
   String name = reader.readLine();
   ```

2. Using the `Scanner` class

   ```java
   Scanner in = new Scanner(System.in);
   String s = in.nextLine();
   int a = in.nextInt();
   ```

3. Using the `Console` class
   - \tiny `System.console()` will return null if there is no console.

   ```java
   String name = System.console().readLine();
   ```

4. Command Line Args

   \tiny
   ```java
   public static void main(String[] args) {
     if (args.length > 0) {
       for (String val : args)
         System.out.println(val);
     } else {
       System.out.println("No args!");
     }
   }
   ```

::::
:::: column

\scriptsize

**Basic Output:**

1. The simplest form of output is to write to the standard out:

   ```java
   System.out.println("Hello World!")
   System.out.printf("%s\n", "Hello World!");
   System.out.print("Hello World!\n");
   ```

2. A better approach (if on a terminal) is to use the System Console:
   - \tiny However is a console is not available `System.console()` will return null.

   \tiny
   ```java
   System.console().writer().println("Hello World!");
   System.console().writer().printf("%s\n", "Hello World!");
   System.console().writer().print("Hello World!\n");
   ```

::::
:::

# Flow Control

* There are two main ways in which we can adjust the logical flow of a program
  - *Selection*: which allows us to conditionally execute blocks of code
    - Achieved using either `if` or `switch` statements
  - *Iteration*: which allows us to conditionally repeat the execution of blocks of code
    - Achieved using one of `for`, `for each`, `while`, or `do..while` loops

# Selection

\footnotesize

::: columns
:::: column

**Original Switch Example:**

```java
String s = "";
//...
switch(s) {
  case "val1":
    System.out.println("ans2");
    break;
  case "val2":
    System.out.println("ans1");
    break;
  default:
    System.out.println("default");
}
```

::::
:::: column

**New Switch Example:**

```java
String s = "";
//...
switch(s) {
  case "val1" -> System.out.println("ans1");
  case "val2" -> System.out.println("ans2");
  default -> System.out.println("default");
}
```

**If Statements**

```java
if (x < 3) {
  // do something
} else if (x > 4) {
  // do something
} else {
  // do something
}
```

::::
:::

# Loops

\footnotesize

::: columns
:::: column

**For Loop**

```java
for (int i = 0; i < 1000; i++) {
  System.out.println(i);
}
```

**For Each Loop**

```java
int[] array
List<Integer> list

for(int i : array) System.out.println(i);
for(int i : list) System.out.println(i);

list.forEach(i -> System.out.println(i););
list.forEach(System.out::println);
```

::::
:::: column

**While Loops**

```java
int i = 0;
while(i < 1000) {
  System.out.println(i);
  i++;
}
```

**Do..While Loops**

```java
int i = 0;
do {
  System.out.println(i);
  i++;
} while(i < 0)
```

::::
:::

# Arrays

::: columns
:::: column

* Provide the ability to store multiple values of a single type in a single variable
* Arrays are useful when you know (or can calculate) the exact number of items you need
* Arrays are useful when you need to access each item in O(1) time
* Arrays are a type of object, but can hold primitive or object types

::::
:::: column

**Examples**

\footnotesize

```java
// Initialization
int[] x = { 1, 2, 3, 4 };

int[] x = new int[4];
Arrays.fill(x, 0);

// Accessing items
int y = x[0]; // 0 indexed

// Iteration
for (int i = 0; i < x.length; i++)
  System.out.println(x[i]);

for (int item : x)
  System.out.println(item);
```

::::
:::

# Text Blocks (aka Multiline Strings)

* Often times we have a need to have a string span across multiple lines
* We can achieve this with text blocks

**Example:**

```java
String html = """
            <html>
                <body>
                    <p>Hello, world</p>
                </body>
            </html>
            """;
```

#

\centering
\vfill
\begin{minipage}{.725\textwidth}
\begin{center}
\includegraphics[width=22pt]{images/bengal-black.png}
\Huge Functional Programming
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# Lambda Expressions

* Provide a short block of code that takes parameters and returns a value
* Similar to methods but do not need a name and can be implemented inside a method

::: columns
:::: column

\footnotesize

**Syntax:**

* Simplest form takes a single parameter and an expression

  ```java
  parameter -> expression
  ```

* For more than one parameter, wrap them in parentheses

  ```java
  (parameter1, parameter2) -> expression
  ```

* For more advanced code you can wrap the code in curly braces

  ```java
  (parameter1, parameter2) -> { code block }
  ```

::::
:::: column

\footnotesize

**Example**

```java
  import java.util.ArrayList;

  public class Main {
    public static void main(String[] args) {
      ArrayList<Integer> numbers =
            new ArrayList<>(5,9,8,1);
      numbers.forEach( (n) -> {
        System.out.println(n);
      });
    }
  }
```

::::
:::

# Referencing Lambdas

* You can store a lambda expression in a variable for repeated use later

**Example**

```java
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ArrayList<Integer> numbers = new ArrayList<>(5,9,8,1);
    Consumer<Integer> method = (n) -> { System.out.println(n); };
    numbers.forEach( method );
  }
}
```

# Method References

* Provides a shorthand for executing a method
* Can only be used to replace a single method of a lambda expression
* Does not allow for passing arguments to the method
* Works for both Static and non-static methods

**Example**

```java
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ArrayList<Integer> numbers = new ArrayList<>(5,9,8,1);
    numbers.forEach( System.out::println );
  }
}
```

# Closing

In closing, let's return to your paper from the beginning of the lecture:

* Ask yourself the following questions:
  1. For the item you felt you knew well:
     - Did you learning anything new?
     - Did you know it as well as you thought?
  2. For the items you wanted to know more about:
     - Did you learn anything new about those concepts?
     - Did you find that you knew more than you thought?

# For Next Time

::: columns
:::: column
* Review Chapter 2.3 - 2.6
* Review the Lecture
* Come to Class
* Read the Build Automation Article
* Continue working on Homework 01
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
