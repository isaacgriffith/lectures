---
author:
- Isaac Griffith
title: Java II
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
\Huge Java II

# Outcomes

At the end of Today's Lecture you will be able to:

* Utilize Java's If and Switch statements
* Know and use the different types of operators in Java
* Gather Input from the user (at the command line)
* Provide output to the user (at the command line)
* Understand the different modifiers and their meanings in Java

#

\vfill
\begin{center}
{\Huge Introduction}
\end{center}

#

\vfill
\begin{center}
{\Huge Modifiers and Operators}
\end{center}

# Modifiers

* Access modifiers: `public`, `protected`, `private`, default
* Change modifier: `final`
* Instantiation modifier: `static`
* Field modifiers: `transient`, `volatile`
* Method modifiers: `abstract`, `native`, `synchronized`

# Access Control Modifier

Specifies who has access to a defined aspect of a class:
\begin{center}
Motto: \textit{Information Hiding} -- make each class or member as inaccessible as possible
\end{center}


* **private:** accessible by members of the given class.
* **default (package-protected):** accessible by classes in the same package as the given class
* **protected:** accessible by subclasses, as well as classes in the same package as the given class.
* **public:** accessible by all classes.

# Static Modifier

* When a field or method member of a class is declared as **static**, it is associated with the class as a whole, and is shared by all instances of that class
\vskip1em
* static member access: `ClassName.memberName`

  e.g., `Math.sqrt(2)` (in the java Library package java.lang)

\vskip1em

* Primary purpose for static vs. (non-static) instance methods:

  * **static methods**: to implement (utility) functions
  * **instance methods**: to implement data-type operations.

# Other Modifiers

* **abstract**

  * method: has declaration, but no body
  * class: can have abstract methods
  * interface: is abstract class with only abstract methods; no fields, no constructors.

* **final**

  * field: non-resetable (constant)
  * method: non-overridable
  * class: cannot be abstract or sub-classed

# The Keyword this

Within the body of a method, the keyword **this** is automatically defined as an "alias" to the instance upon which the method was invoked. There are three common uses:

* To store the reference in a variable, or send it as a parameter to another method that expects an instance of that type as an argument.
* To differentiate between an instance variable and a local variable or parameter with the same name.
* To allow one constructor bod to invoke another constructor body.

\vskip1em

**Example:**

`public Counter(int count) { this.count = count; }`

# Expressions and Operators

* Existing values can be combined into expressions using special symbols and keywords known as operators.
\vskip1em
* The semantics of an operator depends upon the type of its operands (see "overloading" later)

\vskip1em
**Example:**

```java
  int x = a + b;
  String s = "rewar" + "ding";
```

# Arithmetic Operators

* Java supports the following **binary** arithmetic operators:

  * $+$ addition
  * $-$ subtraction
  * $*$ multiplication
  * $/$ division
  * $\%$ the modulus operator

* If both operands have type **int**, then the result is an **int**; if one or both operands have type **double**, the result is a **double**
* Integer division has its result truncated

# Increment and Decrement Operators

* Java provides the plus-one increment (`++`) and decrement (`--`) **unary** operators.

  * If such an operator is used as **prefix** to a variable reference, then 1 is added to (or subtracted from) the variable, **then** its value is read into the expression.
  * If it is used as **postfix** to a variable reference, then the value is **first** read, and **then** the variable is incremented or decremented by 1.

#

\vfill
\begin{center}
{\Huge Coding Activity}
\end{center}

Write a Java class, `Flower`, that has three instance variables of type **String**, **int**, and **float**, which respectively represent the name of the flower, its number of petals, and price. Your class must include a constructor method that initializes each variable to an appropriate value, and your class should include methods for setting the value of each type, and getting the value of each type.

#

\vfill
\begin{center}
{\Huge Selection}
\end{center}

# Comparison Operators

* Java supports the following operators for numerical values which result in Boolean values:

  * `<` less than
  * `<=` less than or equal to
  * `==` equal to
  * `!=` not equal to
  * `>=` greater than or equal to
  * `>` greater than

# Logical Operators

* Boolean values also have the following operators:

  * `!` not (prefix)
  * `&&` conditional and
  * `||` conditional or

* The and and or operators **short circuit**, in that they do not evaluate the second operand if the result can be determined based on the value of the first operand.

# Conditional Operator

* Java supports the following **ternary** operator:

\begin{center}
`(booleanExpression) ? valueIfTrue : valueIfFalse;`
\end{center}

**Example:**

```java
  /** This method returns the larger of a or b */
  public static int max(int a, int b) {
      return (a > b) ? a : b;
  }
```

# Bitwise Operators

* Java provides the following bitwise operators for integers and Booleans:

  * `~` bitwise complement (prefix unary operator)
  * `&` bitwise and
  * `|` bitwise or
  * `^` bitwise exclusive-or
  * `<<` shift bits left, filling in with zeros
  * `>>` shift bits right, filling in with sign bit
  * `>>>` shift bits right, filling in with zeros

# If Statements

* The syntax of a simple **if** statement is as follows:

```
   if (booleanExpression)
       trueBody
   else
       falseBody
```

* booleanExpression is a boolean expression and trueBody and falseBody are each either a single statement or a block of statements enclosed in braces ("**{**" and "**}**").

# Compound If Statements

* There is also a way to group a number of boolean tests, as follows:

```
   if (firtBooleanExpression)
       firstBody
   else if (secondBooleanExpression)
       secondBody
   else
       thirdBody
```

# Switch Statements

* Java provides for multiple-value control flow using the **switch** statement.
* The switch statement evaluates an **integer**, **string**, or **enum** expression and causes control flow to jump to the code location labeled with the value of this expression.
* If there is no **matching label**, then control flow jumps to the location labeled "**default**".
* This is the only explicit jump performed by the switch statement, however, so flow of control **"falls through"** to the **next case** if the code for a case is not ended with a `break` statement.

# Switch Example
\scriptsize
```java
  switch(d) {
      case MON:
          System.out.println("This is tough.");
          break;
      case TUE:
          System.out.println("This is getting better.");
          break;
      case WED:
          System.out.println("Half way there.");
          break;
      case THU:
          System.out.println("I can see the light.");
          break;
      case FRI:
          System.out.println("Now we are talking.");
          break;
      default:
          System.out.println("Day off!");
  }
```

# Break and Continue

* Java supports a `break` statement that immediately terminate a while or for loop when executed within its body.

```java
            break label // label is optional
```

\vskip1em

* Java also supports a `continue` statement that causes the current iteration of a loop body to stop, but with subsequent passes of the loop proceeding as expected.

#

\vfill
\begin{center}
{\Huge Input and Output}
\end{center}

# Simple Input with Scanner

* The `Scanner` class reads the input stream and divides it into tokens, which are strings of characters separated by delimiters.

  * `hasNext()`: returns true if there is another token in the input stream
  * `next()`: returns the next token string in the input stream; generates an error if there are no more tokens left.
  * `hasNextType()`: returns true if there is another token in the input stream and it can be interpreted as the corresponding base type, *Type*, where *Type* can be Boolean, Byte, Double, Float, Int, Long, or Short.
  * `nextType()`: return the next token in the input stream, returned as the base type corresponding to *Type*; generates an error if there are no more tokens left of if the next token cannot be interpreted as a base type corresponding to *Type*.

# Simple Output

* Java provides a built-in static object, called `System.out` that performs output to the "standard output" device, with the following methods:

  * `print(String s)`: print the string s
  * `print(Object o)`: print the object o using its `toString` method
  * `print(baseType b)`: print the base type value b
  * `println(String s)`: print the string s, followed by the newline character
  * `println(Object o)`: Similar to `print(o)`, followed by the newline character
  * `println(baseType b)`: Similar to `print(b)`, followed by the newline character

# Example: Input/Output

\footnotesize
```java
  import java.util.Scanner;
  import java.io.PrintStream;

  public class IOExample {
      public static void main(String[] args) {
          Scanner input = new Scanner(System.in);
          PrintStream output = System.out;
          output.print("Enter your age in years: ");
          double age = input.nextDouble();
          output.print("Enter your maximum heart rate: ");
          double rate = input.nextDouble();
          double fb = (rate - age) * 0.65;
          output.println("Your ideal fat-burning heart rate is " + fb);
          input.close(); // potential memory leak if not closed!
      }
  }
```

#

\vfill
\begin{center}
{\Huge Coding Activity}
\end{center}

Write a short program that takes as input three integers, `a`, `b`, and `c`, from the Java console and determines if they can be used in a correct arithmetic formula (in the given order), like "a + b = c", "a = b - c", or "a * b = c."

#

\vfill
\begin{center}
{\Huge Gradle}
\end{center}

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}

# For Next Time

* Work through the Java and Gradle tutorials posted on Moodle
* Read Chapter 1 and Chapter 2 of the book
* Review Lecture 1 and Lecture 2
