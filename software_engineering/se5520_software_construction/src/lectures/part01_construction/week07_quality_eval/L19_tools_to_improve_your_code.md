---
author:
- Isaac Griffith
title: Coding Style and Documentation
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
\footnotesize
* Understand and use JavaDoc to document your code following good practices
* Understand basics of source code licensing
* Understand the basics of Code Style and using the Checkstyle tool to check your source code
* Reduce boilerplate and make Java programming fun again using Project Lombok
* How to check your code for common programming issues in order to make your code more professional
* How to better issue information from your system via logging
* How to evaluate the effectiveness of your tests using the code coverage tool jacoco
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
\Huge Documenting Your Code
\vskip-0.75em
\rule{\textwidth}{2pt}

\large \color{Roarange}\textbf{SE 5520}
\end{minipage}
\end{minipage}

# JavaDoc

* JavaDoc provides you a means to communicate the purpose and use of your code to yourself and others

* Towards this end, Javadoc provides the following tags:

\scriptsize
+-----------------+----------------------------------------------+-------------------------------------------+
| **Tag**         | **Description**                              | **Syntax**                                |
+:================+:=============================================+:==========================================+
| `@author`       | Adds the author of a class                   | `@author name-text` \vskip0.5em           |
+-----------------+----------------------------------------------+-------------------------------------------+
| `{@inheritDoc}` | Inherits a comment from the **nearest**      | \vskip0.5em                               |
|                 | inheritable class or implementable interface |                                           |
+-----------------+----------------------------------------------+-------------------------------------------+
| `@version`      | Adds a "version" subheading with the         | `@version version-text`                   |
|                 | specified version-text to the generated docs |                                           |
|                 | when the -version option is used             |                                           |
+-----------------+----------------------------------------------+-------------------------------------------+
| `@param`        | Adds a parameter with the specified          | `@param parameter-name`                   |
|                 | parameter-name followed by the specified     | `description`                             |
|                 | description to the "Parameters" section      | \vskip0.5em                               |
+-----------------+----------------------------------------------+-------------------------------------------+
| `@return`       | Adds a "Returns" section with the            | `@return description`                     
|                 | description text                             | \vskip0.5em                               |
+-----------------+----------------------------------------------+-------------------------------------------+

# JavaDoc

* JavaDoc provides you a means to communicate the purpose and use of your code to yourself and others

* Towards this end, Javadoc provides the following tags:

\scriptsize
+-----------------+----------------------------------------------+-------------------------------------------+
| **Tag**         | **Description**                              | **Syntax**                                |
+:================+:=============================================+:==========================================+
| `@exception`    | Adds a **Throws** subheading to the          | `@exception class-name`                   |
|                 | generated documentation, with the classname  | `description`                             |
|                 | and description text                         | \vskip0.5em                               |
+-----------------+----------------------------------------------+-------------------------------------------+
| `@throws`       | synonym for `@exception`                     | \vskip0.5em                               |
+-----------------+----------------------------------------------+-------------------------------------------+
| `@see`          | Adds a "See Also" heading with a link or     | `@see reference`                          |
|                 | text entry that points to reference          | \vskip0.5em                               |
+-----------------+----------------------------------------------+-------------------------------------------+
| `@since`        | Adds a "Since" heading with the specified    | `@since release`                          |
|                 | since-text to the generated documentation    | \vskip0.5em                               |
+-----------------+----------------------------------------------+-------------------------------------------+
| `@deprecated`   | Adds a comment indicating that               | `@deprecated deprecatedtext`              |
|                 | this API should no longer be used            | \vskip0.5em                               |
+-----------------+----------------------------------------------+-------------------------------------------+

# JavaDoc

* JavaDoc provides you a means to communicate the purpose and use of your code to yourself and others

* Towards this end, Javadoc provides the following tags:

\scriptsize
+-----------------+----------------------------------------------+-------------------------------------------+
| **Tag**         | **Description**                              | **Syntax**                                |
+:================+:=============================================+:==========================================+
| `@link`         | Inserts an in-line link that the visible     | `{@link package.class#member label}`      |
|                 | text label that points to the documentation  |                                           |
|                 | for the specified package, class, or member  |                                           |
|                 | name of a referenced class.                  | \vskip0.5em                               |
+-----------------+----------------------------------------------+-------------------------------------------+
| `@linkplain`    | Identical to `{@link}`, except the link's    | `{@linkplain package.class#member label}` |
|                 | label is displayed in plain text rather than |                                           |
|                 | code font.                                   | \vskip0.5em                               |
+-----------------+----------------------------------------------+-------------------------------------------+
| `{@code}`       | Displays text in code font without           | `{@code text}`                            |
|                 | interpreting the text as HTML markup         |                                           |
|                 | or nested javadoc tags                       | \vskip0.5em                               |
+-----------------+----------------------------------------------+-------------------------------------------+
| `{@value}`      | When `{@value}` is used in the doc           | `{@value package.class#field}`            |
|                 | comment of a static field, it                |                                           |
|                 | displays the value of that constant          | \vskip0.5em                               |
+-----------------+----------------------------------------------+-------------------------------------------+

# JavaDoc Standards

* Write Javadoc to be read as source code
* All public/protected methods should be fully defined with Javadoc
  - If a method is overridden use `@Override` to indicate that the Javadoc is inherited
* Use the standard style for javadoc comment

  ```java
  /**
   * Standard comment
   */
  ```

* Use "this" to refer to an instance of the class
* Aim for short single line sentences

# JavaDoc Standards

* Do not use `@code` for `null`, `true`, or `false`
* Use `@param` for generics
* Use one blank line before `@param`
* Treat `@param` and `@return` as a phrase
* Treat `@throws` as an if clause
* `@param` should have two spaces after param name

# JavaDoc Standards

* Define null-handling for all parameters and return types
* Include implementation notes [Example](https://github.com/ThreeTen/threeten/blob/0b071a60997f409e44b9bbccde013b004f24fe22/src/main/java/javax/time/Clock.java#L74)
* Use a single `<p>` tag between paragraphs
* Use a single `<li>` tag for items in a list

# JavaDoc Best Practices

The following are several tips/best practices for documenting your code with JavaDoc

1. Use `@link` and `@linkplain` for point to some code
2. Use `@code` for Code Snippets
3. Use `@value` to insert the value of a field in the documentation
4. Indicate when features have been available with `@since`
5. Don't be anonymous, use `@author`
6. For non-void methods, always use `@return`
7. Clarify what parameters mean with `@param`
8. Use `DocCheck` to your advantage

# Generating JavaDoc

* You can utilize Gradle to automate generating JavaDoc

* This is part of the `java` plugin

::: columns
:::: column

* In your build file add the following (assuming standard directory structure)

## build.gradle

```java
plugins {
  apply 'java'
}

javadoc {
  source = sourceSets.main.allJava
  classpath = configurations.compile
}
```

::::
:::: column

* Generate using the following command

```shell
$ gradle javadoc
```

* This will produce the JavaDoc in the following location

  `project-root/build/docs/javadoc`

::::
:::

# GitHub Pages

\footnotesize

* GitHub provides the capability of adding a static site to a project or organization in order to allow you to have a landing page to showcase what you have done.
* These pages use markdown and jekyll to generate html.
* You can configure your project (in the settings) to utilize the `docs/` folder to serve these pages.
* Thus, if you provided an index with a link to `api/index.html` you could copy your generated javadoc to this location as part of the build.
* With this in place you could then provide api documentation automatically.

## build.gradle

```java
javadoc {
  source = sourceSets.main.allJava
  classpath = configurations.compile
  destinationDir = file('../docs/javadoc')
}
```

#

\centering
\vfill
\begin{minipage}{.75\textwidth}
\begin{minipage}{3.5em}
\vskip-1em
\includegraphics[width=\textwidth]{images/bengal-black.png}
\end{minipage}
\begin{minipage}{.775\textwidth}
\Huge Licensing Your Code
\vskip-0.75em
\rule{.975\textwidth}{2pt}

\large \color{Roarange}\textbf{SE 5520}
\end{minipage}
\end{minipage}

# Licensing your Code

* Programming and software development are an exercise in creativity.
* As such, they are a form of property known as Intellectual Property.
* Thus, it needs protection
* Code can be protected under copyright law.
* In addition to copyright, you should protect your code and yourself by stating the terms of use via a license.
* All companies license their software under either a conventional closed source or an open source license.
  - The latter, allows for the users to not only have free use of the software, but also rights to use the source code (according to the constraints of the license)
* There are many variations of these licenses
  - For open source license information: [https://opensource.org/licenses](https://opensource.org/licenses)

# Licensing your Code

* Popular Open Source Licenses are:
  - Apache License 2.0
  - BSD 3-Clause "New" or "Revise" license
  - BSD 2-Clause "Simplified" or "FreeBSD" license
  - GNU General Public License (GPL)
  - GNU Library or "Lesser" General Public License (LGPL)
  - MIT License (my favorite)
  - Mozilla Public License 2.0
  - Common Development and Distribution License
  - Eclipse Public License version 2.0

* [choosealicense.com](https://choosealicense.com/) is an extremely helpful site that is designed to help you select an open source license that is right for you.
  - They also note what happens if you choose not to license your code.

# Licensing your Code

* Regardless of which license you select, you need to add a `LICENSE` file to the root directory of your project (next to the `README.md` and `CHANGELOG.md` files)
* Additionally, it is considered good practice to insert (as a comment) the license header at the top of each of your source code files.
  - As this is a tedious process, there is a gradle plugin that will help you deal with this issue
  - The Gradle License Plugin, which uses your `LICENSE` file and adds its contents to each code file in your project.

## build.gradle

```java
    plugins {
        id "com.github.hierynomus.license" version "0.15.0"
    }
```

# License Plugin

* This adds several tasks to the build lifecycle
  * `licenseMain(LicenseCheck)`: checks header consistency in the main source set
  * `licenseFormatMain(LicenseFormat)`: applies the license found in the header file in files missing the header
  * `licenseTest(LicenseCheck)`: checks header consistency in the test source set
  * `licenseFormatTest(LicenseFormat)`: applies the license found in the header file in files missing the header in the test source set

* The `licenseCheck` tasks are executed during the build process in the `check` phase
  - will fail the build if it detects files that are not consistent or missing the header
* You can run the format using the following command:

  ```shell
  $ gradle licenseFormat
  ```

  from the root directory of your project

#

\centering
\vfill
\begin{minipage}{.65\textwidth}
\begin{minipage}{3.5em}
\vskip-1em
\includegraphics[width=\textwidth]{images/bengal-black.png}
\end{minipage}
\begin{minipage}{.775\textwidth}
\Huge Styling Your Code
\vskip-0.75em
\rule{.975\textwidth}{2pt}

\large \color{Roarange}\textbf{SE 5520}
\end{minipage}
\end{minipage}

# Why Style Your Code?

* Every programming language has its own nuances and way of being written well
* Additionally, most software companies have a documented way or style for writing code that they will consider acceptable
* Several of these style conventions have been made public for most languages.
* For Java the two most well known are
  - Sun's Java Coding Conventions (now defunct)
  - Google's Java Style Guide

# Examples

* Source File Structure (Google Guide Sect. 3)
  - A source file consists of, **in order**
    1. License or copyright information, if present
    2. Package statement
    3. Import statements
    4. Exactly one top-level class
  - **Exactly one blank line** separates each section that is present

  - **Import Statements**
    * No wildcard imports
    * No line-wrapping
    * No static import for classes

# Google Style Guide

* The prior example is not a complete description of section 3 as there is far more detail than can be shown in this lecture.
* Additionally there are 7 sections of the guide:
  1. Introduction
  2. Source file basics
  3. Source file structure
  4. Formatting
  5. Naming
  6. Programming Practices
  7. JavaDoc
* I would suggest that you review the guide and become familiar with it.

# CheckStyle

* Because style guides tend to be quite large and contain a significant amount of information
* We need a tool which can help ensure that our code conforms to the style guide
* Thus, we have **CheckStyle**, which simply ensures that our source code conforms to a selected style guide
* Additionally, it provides us the ability to extend existing style guides, or even to create our own

# Using CheckStyle

* Given that CheckStyle is a useful tool, and one that can be easily automated, there is a gradle plugin for it.

* This plugin allows us to execute CheckStyle against our source code as part of the `check` phase of the build.

::: columns
:::: {.column width=.55}

## build.gradle

\tiny
```java
plugins {
  id 'checkstyle'
}

checkstyle {
  toolVersion '8.40'
  configFile file("${rootDir}/config/checkstyle/checkstyle.xml")
}
checkstyleMain {
  source = "${projectDir}/src/main/java"
}
checkstyleTest {
  source = "${projectDir}/src/test/java"
}
```
::::
:::: {.column width=.45}

* This plugin adds the following tasks:
  - **checkstyleMain** - runs Checkstyle against production Java source files
  - **checkstyleTest** - runs Checkstyle against test Java source files

* We can execute each of these tasks as follows:

  ```shell
  $ gradle checkstyleMain
  $ gradle checkstyleTest
  ```
::::
:::

#

\centering
\vfill
\begin{minipage}{.75\textwidth}
\begin{minipage}{3.5em}
\vskip-1em
\includegraphics[width=\textwidth]{images/bengal-black.png}
\end{minipage}
\begin{minipage}{.775\textwidth}
\Huge Reducing Boilerplate
\vskip-0.75em
\rule{.975\textwidth}{2pt}

\large \color{Roarange}\textbf{SE 5520}
\end{minipage}
\end{minipage}

# Boilerplate Code?

* One of the arguments against Java is that it contains a large amount of structural boilerplate.

* For example let's contrast what is needed to simply print hello world in Java and in Python

::: columns
:::: {.column width=.35}
**Python**

```python
1. print("Hello World")
```

::::
:::: {.column width=.65}
**Java**

```java
1. public class Main {
2.   public static void main(String[] args) {
3.     System.out.println("Hello World");
4.   }
5. }
```

::::
:::

# Boilerplate Code

::: columns
:::: column

* Java has been accused of requiring the following types of common boilerplate code components:
  - Getters and Setters for fields
  - Constructors which take parameters to set all fields
  - No argument constructors
  - ToString methods
  - Equals and HashCode Methods

::::
:::: column

* Java also requires some tricky code but redundant code when creating
  - Immutable classes
  - Simple Data Classes
  - Synchronization
  - Immutable Setters
  - Adding in Logging
  - Cleaning up Streams
  - Issues with requiring null checks for parameter values

::::
:::

* So how is it that we deal with this but retain the dependability and stability of Java?

##

\centering
\Large Enter [Project lombok](https://projectlombok.org)

# Project Lombok

* Project lombok is a framework designed to reduce all of the above mention issues (and several others) to a single line of code (or less)
* It does this by adding several annotations:
  - `@NonNull`
  - `@Getter/@Setter`
  - `@ToString`
  - `@EqualsAndHashCode`
  - `@NoArgsConstructor/@AllArgsConstructor/@RequiredArgsConstructor`
  - `@Data`

* We'll explore each of these in the following

# `@NonNull`

* If on a parameter - generates a null-check in the method for you
* If on a field - will generate a null check if used in a generated method

::: columns
:::: column

**Lombok Code**

\tiny
```java
import lombok.NonNull;

public class NonNullExample extends Something {
 private String name;

 public NonNullExample(@NonNull Person person) {
   super("Hello");
   this.name = person.getName();
 }
}
```

::::
:::: column

**Vanilla Java**

\tiny
```java
import lombok.NonNull;

public class NonNullExample extends Something {
 private String name;

 public NonNullExample(@NonNull Person person) {
   super("Hello");
   if (person == null) {
     throw new NullPointerException("person is marked " +
                                    "@NonNull but is null");
   }
   this.name = person.getName();
 }
}
```

::::
:::

# `@Getter` and `@Setter`

\scriptsize

::: columns
:::: column
* `@Getter` generates a basic getter for the field
* `@Setter` generates a basic setter for the field


**Lombok**

\tiny
```java
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class GetterSetterExample {
 /**
  * Age of the person. Water is wet.
  *
  * @param age New value for this person's age. Sky is blue.
  * @return The current value of this person's age. Circles are round.
  */
 @Getter @Setter private int age = 10;

 /**
  * Name of the person.
  * -- SETTER --
  * Changes the name of this person.
  *
  * @param name The new value.
  */
 @Setter(AccessLevel.PROTECTED) private String name;

 @Override public String toString() {
   return String.format("%s (age: %d)", name, age);
 }
}
```

::::
:::: column
**Vanilla Java**

\tiny
```java
public class GetterSetterExample {
 /**
  * Age of the person. Water is wet.
  */
 private int age = 10;
 /**
  * Name of the person.
  */
 private String name;
 @Override public String toString() {
   return String.format("%s (age: %d)", name, age);
 }
 /**
  * Age of the person. Water is wet.
  *
  * @return The current value of this person's age. Circles are round.
  */
 public int getAge() {
   return age;
 }
 /**
  * Age of the person. Water is wet.
  *
  * @param age New value for this person's age. Sky is blue.
  */
 public void setAge(int age) {
   this.age = age;
 }
 /**
  * Changes the name of this person.
  *
  * @param name The new value.
  */
 protected void setName(String name) {
   this.name = name;
 }
}
```

::::
:::

# `@ToString`

\footnotesize

* Applies to a class, and generates a toString method for all included fields

::: columns
:::: {.column width=.4}
**Lombok**

\tiny
```java
import lombok.ToString;

@ToString
public class ToStringExample {
 private static final int STATIC_VAR = 10;
 private String name;
 private Shape shape = new Square(5, 10);
 private String[] tags;
 @ToString.Exclude private int id;

 public String getName() {
   return this.name;
 }

 @ToString(callSuper=true, includeFieldNames=true)
 public static class Square extends Shape {
   private final int width, height;

   public Square(int width, int height) {
     this.width = width;
     this.height = height;
   }
 }
}
```
::::
:::: {.column width=.60}
**Vanilla Java**

\tiny
```java
import java.util.Arrays;

public class ToStringExample {
 private static final int STATIC_VAR = 10;
 private String name;
 private Shape shape = new Square(5, 10);
 private String[] tags;
 private int id;

 public String getName() {
   return this.name;
 }
 public static class Square extends Shape {
   private final int width, height;
   public Square(int width, int height) {
     this.width = width;
     this.height = height;
   }
   @Override public String toString() {
     return "Square(super=" + super.toString() + ", width=" + this.width +
            ", height=" + this.height + ")";
   }
 }
 @Override public String toString() {
   return "ToStringExample(" + this.getName() + ", " + this.shape + ", " +
          Arrays.deepToString(this.tags) + ")";
 }
}
```
::::
:::

# `@EqualsAndHashCode`

* Generates `hashCode` and `equals` implementations from the fields of the object

::: columns
:::: column
**Lombok**

\tiny
```java
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class EqualsAndHashCodeExample {
 private transient int transientVar = 10;
 private String name;
 private double score;
 @EqualsAndHashCode.Exclude private Shape shape = new Square(5, 10);
 private String[] tags;
 @EqualsAndHashCode.Exclude private int id;

 public String getName() {
   return this.name;
 }

 @EqualsAndHashCode(callSuper=true)
 public static class Square extends Shape {
   private final int width, height;

   public Square(int width, int height) {
     this.width = width;
     this.height = height;
   }
 }
}
```
::::
:::: column

**Vanilla Java**

\tiny
```java
import java.util.Arrays;

public class EqualsAndHashCodeExample {
 private transient int transientVar = 10;
 private String name;
 private double score;
 private Shape shape = new Square(5, 10);
 private String[] tags;
 private int id;

 public String getName() {
   return this.name;
 }

 @Override public boolean equals(Object o) {
   if (o == this) return true;
   if (!(o instanceof EqualsAndHashCodeExample)) return false;
   EqualsAndHashCodeExample other = (EqualsAndHashCodeExample) o;
   if (!other.canEqual((Object)this)) return false;
   if (this.getName() == null ? other.getName() != null :
       !this.getName().equals(other.getName())) return false;
   if (Double.compare(this.score, other.score) != 0) return false;
   if (!Arrays.deepEquals(this.tags, other.tags)) return false;
   return true;
 }
```

::::
:::

# `@EqualsAndHashCode`

\tiny

::: columns
:::: column

```java
 @Override public int hashCode() {
   final int PRIME = 59;
   int result = 1;
   final long temp1 = Double.doubleToLongBits(this.score);
   result = (result*PRIME) + (this.name == null ? 43 :
            this.name.hashCode());
   result = (result*PRIME) + (int)(temp1 ^ (temp1 >>> 32));
   result = (result*PRIME) + Arrays.deepHashCode(this.tags);
   return result;
 }

 protected boolean canEqual(Object other) {
   return other instanceof EqualsAndHashCodeExample;
 }

 public static class Square extends Shape {
   private final int width, height;

   public Square(int width, int height) {
     this.width = width;
     this.height = height;
   }
```

::::
:::: column

```java
   @Override public boolean equals(Object o) {
     if (o == this) return true;
     if (!(o instanceof Square)) return false;
     Square other = (Square) o;
     if (!other.canEqual((Object)this)) return false;
     if (!super.equals(o)) return false;
     if (this.width != other.width) return false;
     if (this.height != other.height) return false;
     return true;
   }

   @Override public int hashCode() {
     final int PRIME = 59;
     int result = 1;
     result = (result*PRIME) + super.hashCode();
     result = (result*PRIME) + this.width;
     result = (result*PRIME) + this.height;
     return result;
   }

   protected boolean canEqual(Object other) {
     return other instanceof Square;
   }
 }
}
```

::::
:::

# Constructors

::: columns
:::: column
\footnotesize

* `@NoArgsConstructor`
  - \scriptsize generates a no-args constructor
* `@AllArgsConstructor`
  - \scriptsize generates a constructor for all fields
* `@RequiredArgsConstructor`
  - \scriptsize generates a constructor for all final and non-null fields

**Lombok**

\tiny
```java
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ConstructorExample<T> {
 private int x, y;
 @NonNull private T description;

 @NoArgsConstructor
 public static class NoArgsExample {
   @NonNull private String field;
 }
}
```

::::
:::: column
**Vanilla Java**

\tiny
```java
public class ConstructorExample<T> {
 private int x, y;
 @NonNull private T description;

 private ConstructorExample(T description) {
   if (description == null) throw new NullPointerException("description");
   this.description = description;
 }

 public static <T> ConstructorExample<T> of(T description) {
   return new ConstructorExample<T>(description);
 }

 @java.beans.ConstructorProperties({"x", "y", "description"})
 protected ConstructorExample(int x, int y, T description) {
   if (description == null) throw new NullPointerException("description");
   this.x = x;
   this.y = y;
   this.description = description;
 }

 public static class NoArgsExample {
   @NonNull private String field;

   public NoArgsExample() {
   }
 }
}
```
::::
:::

# `@Data`

::: columns
:::: column

* Annotates a class and is equivalent to the application of all of the following annotations:
  - `@ToString`
  - `@EqualsAndHashCode`
  - `@Getter` on all fields
  - `@Setter` on all non-final fields
  - `@RequiredArgsConstructor`

::::
:::: column
**Lombok**

\scriptsize
```java
import lombok.AccessLevel;
import lombok.Setter;
import lombok.Data;
import lombok.ToString;

@Data public class DataExample {
 private final String name;
 @Setter(AccessLevel.PACKAGE) private int age;
 private double score;
 private String[] tags;

 @ToString(includeFieldNames=true)
 @Data(staticConstructor="of")
 public static class Exercise<T> {
   private final String name;
   private final T value;
 }
}
```
::::
:::

# Additional Annotations

* `@Value` - makes immutable classes easy
* `@Builder` - makes creating a builder API for your class easy
* `@Synchronized` - provides for correct synchronization handling
* `@Cleanup` - calls `close()` methods safely with no hassle
* `@With` - creates immutable setters - methods that create a clone but with one changed field
* Additionally, there are some "experimental" annotations

# Using Project Lombok

* Add the lombok gradle plugin to your `build.gradle` file in the plugins block

~~~{=latex}
\begin{block}{build.gradle}
~~~

```java
    plugins {
        id 'io.freefair.lombok' version '5.3.0'
    }
```

~~~{=latex}
\end{block}
~~~

* You then need to activate annotation processors in your IDE
* Lombok will generate a "lombok.config" file
  - You should add the following line in it if you use Jacoco

  ```
  lombok.addLombokGeneratedAnnotation = true
  ```

#

\centering
\vfill
\begin{minipage}{.75\textwidth}
\begin{minipage}{3.5em}
\vskip-1em
\includegraphics[width=\textwidth]{images/bengal-black.png}
\end{minipage}
\begin{minipage}{.775\textwidth}
\Huge Checking Your Code
\vskip-0.75em
\rule{.975\textwidth}{2pt}

\large \color{Roarange}\textbf{SE 5520}
\end{minipage}
\end{minipage}

# Static Analysis

* Analysis of the static components of a software system (i.e., source code, designs, etc.)
* Analyses can involve
  - Metrics
  - Reverse engineering
  - Detecting Vulnerable Code
  - Coding Errors
  - Style Issues
* There are static analysis tools for nearly every language used in commercial software development today.
* In Java two typical tools used are
  - PMD
  - SpotBugs

# SpotBugs and PMD

\footnotesize

::: columns
:::: column

**SpotBugs**

* Tool which scans Java code for over 400 known bug types
* Bug patterns are separated into several different categories
  - \scriptsize Bad Practice
  - \scriptsize Correctness
  - \scriptsize Malicious code vulnerability
  - \scriptsize Multithreaded correctness
  - \scriptsize Performance
  - \scriptsize Security and dodgy code
  - \scriptsize and several other categoires
* Additionally there are several plugins
  - \scriptsize FindSecurityBugs - identifies 80 additional security bugs (including OWASP 10 vulnerabilities, different types of inject, and XSS protection)

::::
:::: column

**PMD**

* Scans Java source code to find potential problems
* Problems can be
  - \scriptsize breaking naming conventions
  - \scriptsize unused code or variables
  - \scriptsize performance and complexity of code
  - \scriptsize other possible bugs

::::
:::

# Using PMD

::: columns
:::: {.column width=.6}
## build.gradle

```java
  plugins {
    id 'pmd'
  }

  pmd {
    consoleOutput = true
    toolVersion = "6.21.0"
    rulesMinimumPriority = 5
    ruleSets = [
        "category/java/errorprone.xml",
        "category/java/bestpractices.xml"
    ]
  }
```
::::
:::: {.column width=.4}
* Provides several tasks, all of which run during the `check` phase of a build
  - **pmdMain** - runs PMD against Java source files
  - **pmdTest** - runs PMD against Java test files
* You can execute these tasks as follows:

  ```shell
  $ gradle pmdMain
  $ gradle pmdTest
  ```
::::
:::

# Using Spotbugs

* SpotBugs will run as part of the `check` phase of a build
* You can execute spotbugs only using the spotbugs task as follows:

  ```shell
  $ gradle spotbugs
  ```

## build.gradle

\footnotesize
```java
  plugins {
    id 'com.github.spotbugs' version '4.6.1'
  }

  dependencies {
    spotbugs 'com.github.spotbugs:spotbugs:4.2.1'
  }
```

#

\centering
\vfill
\begin{minipage}{.35\textwidth}
\begin{minipage}{3.5em}
\vskip-1em
\includegraphics[width=\textwidth]{images/bengal-black.png}
\end{minipage}
\begin{minipage}{.65\textwidth}
\Huge Logging
\vskip-0.75em
\rule{.975\textwidth}{2pt}

\large \color{Roarange}\textbf{SE 5520}
\end{minipage}
\end{minipage}

# What is Logging?

* Logging provides an application the ability to record its activity
* This record can be in a variety of forms
  - Database entries
  - A streaming file
  - Console output
  - A combination of the above
* Nearly all languages provide a logging mechanism, or have a library which does

# What is Logging?

* Logging mechanisms are typically subdivided into three components
  * **Logger** - responsible for capturing messages to be logged (along with metadata) and passing this information to the framework
  * **Logging Framework** - calls the formatter with the message, which then formats the message for output
  * **Appender/Handler** - after formatting the framework passes the message to this component which outputs the message to:
    - Console
    - File
    - Database
    - or Email

# Logging

* Logging typically involves a setup which specifies
  - Name of the logger (typically the class name to which the logger is attached)
  - Minimum severity level, for example
    * SEVERE
    * WARNING
    * INFO
    * CONFIG
    * FINE
    * FINER
    * FINEST
  - Filters used to filter out logging levels, events, etc.
  - Formatters, layouts, or renderers
  - Handlers/Appenders
* Once setup (either globally or locally) logging statements can be used
* Logging provides a superior approach to simple `print` statements as it tends to have higher performance than the standard output stream and is more easily configurable.

# Logging Frameworks

* Currently there are many different logging frameworks
  - Built in Java Logging API
  - Apache Commons Logging (JCL)
  - log4j
  - tinylog
  - Logback
  - SLF4J

* The variety of choices has led to several issues including integration problemes and problems with using multiple loggers across projects
  - This led to the development of various wrappers to solve this problem
  - Google solved this problem by developing a better Logging Framework -> Flogger

# Why Flogger?

* Provides a fluent API for logging which makes logging statements simple and easy to read.

* Makes logging at disabled levels effectively free
* Has high performance for logging at enabled levels
* Fluent API accommodates a variety of present and future features without requiring a logging facade.
* Reduces reliance on long parameter lists and yields more self-documenting code

# Using Flogger

* Assuming that you are using Project Lombok within your project
* You can add a `log` field, of type `FluentLogger` by adding the following annotation above your class declaration:

  ```java
  @Flogger
  ```

* You will also need to add a dependency

## build.gradle

```java
  dependencies {
    implementation 'com.google.flogger:flogger:0.5.1'
    runtime 'com.google.flogger:flogger-system-backend:0.5.1'
  }
```

# Logging with Flogger

* You can then log as follows:

  ```java
  log.atInfo()
       .withcause(exception)
       .log("Log message with: %s", argument);
  log.atSevere()
       .atMostEvery(30, SECONDS)
       .log("Value: %s", lazy(() -> doExpensiveCalculation()));
  ```

  - where `log` is the field provided by the `@Flogger` annotation
  - `atInfo()` indicates the level of logging - In this case INFO
  - `withCause()` indicates the reason for logging
  - `log()` provides the message to be logged (note you can use standard Java string formatting specifiers)

* The fluent API is much larger than this, but I leave exploring this up to you.

#

\centering
\vfill
\begin{minipage}{.5\textwidth}
\begin{minipage}{3.5em}
\vskip-1em
\includegraphics[width=\textwidth]{images/bengal-black.png}
\end{minipage}
\begin{minipage}{\textwidth}
\Huge Code Coverage
\vskip-0.75em
\rule{.8\textwidth}{2pt}

\large \color{Roarange}\textbf{SE 5520}
\end{minipage}
\end{minipage}

# What is Code Coverage?

* **Code coverage** is a metric used to evaluate a test suite

* Essentially it evaluates how much of a program was executed by the test suite

* Thus, it returns a percentage value:
  - Across each method
  - Across each class
  - Across each package
  - Across the entire program

* Coverage also gives us the ability to determine when we can stop testing a system.
  - Our goal with testing is to simply cover the entire program
  - Thus, we need only write enough tests to achieve 100% coverage

# Coverage with Jacoco

* Jacoco is a tool which works with your test environment to determine how much coverage your tests provide.

* It informs us the percentage of lines covered by the tests executed
  - Show this at the Package, class, and method level

* The ultimate goal is to achieve 100% code coverage, but often this is not possible.
  - Thus, a good stopping goal is 85% code coverage

# Using Jacoco

::: columns
:::: column

## build.gradle

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

* Adds the following tasks:
  - **jacocoTestCoverageVerification** - verifies code coverage metrics based on specified rules for the test task
  - **jacocoTestReport** - generates the code coverage report for the test task

::::
:::

# Setting Coverage Goals

::: columns
:::: column

~~~{=latex}
\begin{block}{build.gradle}
~~~

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

~~~{=latex}
\end{block}
~~~

\scriptsize
* Rules can note the element (CLASS, LINE, METHOD, etc)
* Rules can also have an includes and excludes section both of which contain a list of classes to be included or excluded

::::
:::: column

\footnotesize
* This rule states that we have a minimum of 85% line coverage
* We could also replace "LINE" with:
  - \scriptsize BRANCH - number of execution branches
  - \scriptsize CLASS - number of classes
  - \scriptsize INSTRUCTION - number of code instructions
  - \scriptsize METHOD - number of methods
* We can replace the value "COVEREDRATIO" with:
  - \scriptsize COVEREDCOUNT - absolute number of covered items
  - \scriptsize MISSEDCOUNT - absolute number of items not covered
  - \scriptsize MISSEDRATIO - ratio of items not covered
  - \scriptsize TOTALCOUNT - total number of items

::::
:::

# Resources

::: columns
:::: column

* JavaDoc
  - [Tutorialspoint Tutorial](https://www.tutorialspoint.com/java/java_documentation.htm)
  - [Javadoc Coding Standards](https://blog.joda.org/2012/11/javadoc-coding-standards.html)
  - [Tips and Tricks for Better Java Docs](https://www.jrebel.com/blog/tips-and-tricks-for-better-java-documentation)
* Licenses
  - [choosealicense.com](https://choosealicense.com/)
  - [Open Source Initiative](https://opensource.org/licenses)
  - [Gradle License Plugin](https://github.com/hierynomus/license-gradle-plugin)
* Style
  - [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)
  - [Checkstyle Gradle Plugin](https://docs.gradle.org/current/userguide/checkstyle_plugin.html)
  - [Checkstyle Google Java Guide File](https://github.com/checkstyle/checkstyle/blob/master/src/main/resources/google_checks.xml)

::::
:::: column

* [Lombok](https://projectlombok.org/)
* Analysis
  - [SpotBugs Plugin](https://github.com/spotbugs/spotbugs-gradle-plugin)
  - [PMD Plugin](https://docs.gradle.org/current/userguide/pmd_plugin.html)
* Logging
  - [Flogger](https://github.com/google/flogger)
  - [Flogger Page](https://google.github.io/flogger/)
* Code Coverage
  - [Jacoco Plugin](https://docs.gradle.org/current/userguide/jacoco_plugin.html)
  - [Definitive Guide to Jacoco Gradle Plugin](https://reflectoring.io/jacoco/)
* Java Best Practices
  - [javapractices.com](http://www.javapractices.com)

::::
:::

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
