---
author:
- Dr. Isaac Griffith
title: Long-term Storage + Documenting Your Code
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
outline: false
...

# Thought Experiment

\centering

\vfill

\Large How do we reuse objects

between executions of our program?

# Outcomes

After today's lecture you will be able to:

::: columns
:::: {.column width=.7}
* Understand the basics of persisting data using
  - Java Serialization
  - JSON via Gson
* Understand and use JavaDoc to document your code following good practices
* Understand basics of source code licensing
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
\begin{minipage}{.425\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Storing Objects
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# Long-Term Storage of Objects

* Most applications will have some need to persist data between executions
* Additionally, data that is needed may be significantly larger than that which can be stored in main memory
* Thus, we need some mechanism to store and retrieve this data
* There are several options, but we will discuss the following
  - Java ObjectStreams
  - Java Serialization
  - Google Gson

# Basics

* \small We can easily store and retrieve primitive data
* \small For this we will use a FileOutputStream (or FileInputStream) parameterized with an ObjectOutputStream (or ObjectInputStream)

* \small Example: \textcolor{Roarange}{\textbf{Writing Primitive Data}}

1. \footnotesize Construct the output stream

   \vskip.25em
   \scriptsize
   ```java
   FileOutputStream file = new FileOutputStream("file");
   ObjectOutputStream out = new ObjectOutputStream(file);
   ```
   \vskip.25em
   \small

2. \footnotesize Store the data

   \vskip.25em
   \scriptsize
   ```java
   int i = 7;
   char c = 'q';
   boolean b = true;
   double d = 3.14;
   out.writeInt(i);
   out.writeChar(c);
   out.writeBoolean(b);
   out.writeDouble(d);
   out.close();
   ```

# Basics

* \small We can easily store and retrieve primitive data
* \small For this we will use a ObjectOutputStream (or ObjectInputStream) parameterized with an FileOutputStream (or FileInputStream)

* \small Example: \textcolor{Roarange}{\textbf{Reading Primitive Data}}

1. \footnotesize Construct the input stream

   \vskip.25em
   \scriptsize
   ```java
   FileInputStream file = new FileInputStream("file");
   ObjectInputStream in = new ObjectInputStream(file);
   ```
   \vskip.25em
   \small

2. \footnotesize Read in the data

   \vskip.25em
   \scriptsize
   ```java
   int i = input.readInt();
   char c = input.readChar();
   boolean b = input.readBoolean();
   double d = input.readDouble();
   ```

#

\centering
\vfill
\begin{minipage}{.5\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Using Serialization
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# Storing Objects

* \small To store objects we would expect to follow a similar procedure:

  \footnotesize
  ```java
  Television television = new Television();
  Account account = new Account();
  FileOutputStream file = new FileOutputStream("objdata");
  ObjectOutputStream out = new ObjectOutputStream(file);
  out.writeObject(television);
  out.writeObject(account);
  ```

* \small Unfortunately, it is not quite that simple

# Retrieving Objects

* \small And again, we would expect to retrieve objects like so:

  \footnotesize
  ```java
  Television television;
  Account account;
  FileInputStream file = new FileInputStream("objdata");
  ObjectInputStream out = new ObjectInputStream(file);
  television = input.readObject();
  account = input.readObject();
  ```

* \small Unfortunately, it is not quite that simple

# Issues

* \small Unfortunately, due to the way objects are composed of other objects, there will be several issues we need to consider
  - \footnotesize \textcolor{Roarange}{\textbf{Reconstruction}} - depending on how the object was stored, we will need information on how to retrieve it
  - \footnotesize \textcolor{Roarange}{\textbf{Complexity}} - The more complex the object (more other objects it is composed of) the more objects that must also be read in to construct the original object.

\vskip.5em

* \small Because of these issues the creators of Java created \textcolor{Roarange}{\textbf{serialization}}
  - \footnotesize Provides efficient reconstruction of objects
  - \footnotesize Provides correct storage of complex objects

# Serialization

* \small The process of Serialization is as follows:
  1. \footnotesize Each class to be serialized must implement the `java.io.Serializable` interface
  2. \footnotesize Need to open an `ObjectOutputStream` paramaterized by a `FileOutputStream`
  3. \footnotesize Use the `writeObject(Object)` method from `ObjectOutputStream`

# Deserialization

* \small The process of Deserialization is as follows:
  1. \footnotesize Open the file using an `ObjectInputStream` parameterized with a `FileInputStream`
  2. \footnotesize Use the `readObject()` method from `ObjectInputStream` to read the appropriate type
  3. \footnotesize Objects are to be read back in the order in which they were written

\vskip0.5em

* \small Note: There is an issue. Every time a class changes, it can no longer deserialize data from prior versions of the class.

#

\centering
\vfill
\begin{minipage}{.375\textwidth}
{
\includegraphics[width=13pt]{images/mark.png}
\Huge Using Gson
}
\vskip-.5em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# JSON

::: columns
:::: column
* \small A language independent lightweight data-interchange format
* \small Designed to be:
  - \footnotesize Easy for humans to read and write
  - \footnotesize Easy for machines to parse and generate
* \small Built on two structures:
  - \footnotesize Collection of name/value pairs
    * \scriptsize i.e., object, record, dictionary, etc.
  - \footnotesize Ordered list of values
    * \scriptsize i.e., array, list, sequence, etc.
::::
:::: column
**Example**

\scriptsize
```json
{
"menu": {
  "id": "file",
  "value": "File",
  "popup": {
    "menuitem": [
      {"value": "New", "onclick": "CreateNewDoc()"},
      {"value": "Open", "onclick": "OpenDoc()"},
      {"value": "Close", "onclick": "CloseDoc()"}
    ]
  }
}
}
```
::::
:::

# Gson

* \small Library which:
  - \footnotesize Converts Java Objects into a JSON representation
  - \footnotesize Converts JSON Strings into Java Objects
  - \footnotesize Overcomes the issue of deserialization

* \small To use Gson with gradle, you need only add the following dependency:

\scriptsize

```groovy
dependencies {
  implementation 'com.google.code.gson:gson:2.8.6'
}
```

* \small \textcolor{Roarange}{\textbf{Issues}}
  - \footnotesize You cannot serialize objects with circular references
    * \scriptsize results in infinite recursion
  - \footnotesize Classes to be serialized require a no-args constructor in order to be serialized

# Storing an Objects

1. \small Create the Gson object

   \footnotesize
   ```java
   Gson gson = new Gson();
   ```

2. \small Convert the object to a JSON String

   \footnotesize
   ```java
   class SomeObject {
     private int value1 = 1;
     private String value2 = "abc";

     SomeObject() {} // no-args constructor req'd
   }

   SomeObject obj = new SomeObject();
   String json = gson.toJson(obj);
   ```

3. \small Write out the JSON string to a file

# Retrieve an Object

1. \small Read the json data from a file into a string
2. \small Create the Gson object

\footnotesize
```java
Gson gson = new Gson();
```
3. \small Convert theString into the object

\footnotesize
```java
String json; // json string
SomeObject obj2 = gson.fromJson(json, SomeObject.class);
```

<!--
#

\centering
\vfill
\Huge Let's See an Example
-->

#

\centering
\vfill
\begin{minipage}{.65\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Documenting Your Code
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# JavaDoc

* \footnotesize JavaDoc provides you a means to communicate the purpose and use of your code to yourself and others

* \footnotesize Towards this end, Javadoc provides the following tags:

\scriptsize
+-----------------+----------------------------------------------+-------------------------------------------+
| **Tag**         | **Description**                              | **Syntax**                                |
+:================+:=============================================+:==========================================+
| `@author`       | Adds the author of a class                   | `@author name-text` \vskip0.25em          |
+-----------------+----------------------------------------------+-------------------------------------------+
| `{@inheritDoc}` | Inherits a comment from the **nearest**      | \vskip0.25em                              |
|                 | inheritable class or implementable interface |                                           |
|                 | \vskip0.25em                                 |                                           |
+-----------------+----------------------------------------------+-------------------------------------------+
| `@version`      | Adds a "version" subheading with the         | `@version version-text`                   |
|                 | specified version-text to the generated docs |                                           |
|                 | when the -version option is used \vskip0.25em|                                           |
+-----------------+----------------------------------------------+-------------------------------------------+
| `@param`        | Adds a parameter with the specified          | `@param parameter-name`                   |
|                 | parameter-name followed by the specified     | `description`                             |
|                 | description to the "Parameters" section      | \vskip0.25em                              |
|                 | \vskip0.25em                                 |                                           |
+-----------------+----------------------------------------------+-------------------------------------------+
| `@return`       | Adds a "Returns" section with the            | `@return description`                     |
|                 | description text                             |                                           |
+-----------------+----------------------------------------------+-------------------------------------------+

# JavaDoc

* \footnotesize JavaDoc provides you a means to communicate the purpose and use of your code to yourself and others

* \footnotesize Towards this end, Javadoc provides the following tags:

\scriptsize
+-----------------+----------------------------------------------+-------------------------------------------+
| **Tag**         | **Description**                              | **Syntax**                                |
+:================+:=============================================+:==========================================+
| `@exception`    | Adds a **Throws** subheading to the          | `@exception class-name`                   |
|                 | generated documentation, with the classname  | `description`                             |
|                 | and description text \vskip0.25em            | \vskip0.25em                              |
+-----------------+----------------------------------------------+-------------------------------------------+
| `@throws`       | synonym for `@exception` \vskip0.25em        | \vskip0.25em                              |
+-----------------+----------------------------------------------+-------------------------------------------+
| `@see`          | Adds a "See Also" heading with a link or     | `@see reference`                          |
|                 | text entry that points to reference          | \vskip0.25em                              |
|                 | \vskip0.25em                                 |                                           |
+-----------------+----------------------------------------------+-------------------------------------------+
| `@since`        | Adds a "Since" heading with the specified    | `@since release`                          |
|                 | since-text to the generated documentation    | \vskip0.25em                              |
|                 | \vskip0.25em                                 |                                           |
+-----------------+----------------------------------------------+-------------------------------------------+
| `@deprecated`   | Adds a comment indicating that               | `@deprecated deprecatedtext`              |
|                 | this API should no longer be used            |                                           |
+-----------------+----------------------------------------------+-------------------------------------------+

# JavaDoc

* \footnotesize JavaDoc provides you a means to communicate the purpose and use of your code to yourself and others

* \footnotesize Towards this end, Javadoc provides the following tags:

\scriptsize
+-----------------+----------------------------------------------+-------------------------------------------+
| **Tag**         | **Description**                              | **Syntax**                                |
+:================+:=============================================+:==========================================+
| `@link`         | Inserts an in-line link that the visible     | `{@link package.class#member label}`      |
|                 | text label that points to the documentation  |                                           |
|                 | for the specified package, class, or member  |                                           |
|                 | name of a referenced class. \vskip0.25em     |                                           |
+-----------------+----------------------------------------------+-------------------------------------------+
| `@linkplain`    | Identical to `{@link}`, except the link's    | `{@linkplain package.class#member label}` |
|                 | label is displayed in plain text rather than |                                           |
|                 | code font. \vskip0.25em                      |                                           |
+-----------------+----------------------------------------------+-------------------------------------------+
| `{@code}`       | Displays text in code font without           | `{@code text}`                            |
|                 | interpreting the text as HTML markup         |                                           |
|                 | or nested javadoc tags \vskip0.25em          |                                           |
+-----------------+----------------------------------------------+-------------------------------------------+
| `{@value}`      | When `{@value}` is used in the doc           | `{@value package.class#field}`            |
|                 | comment of a static field, it                |                                           |
|                 | displays the value of that constant          |                                           |
+-----------------+----------------------------------------------+-------------------------------------------+

# JavaDoc Standards

* \small Write Javadoc to be read as source code
* \small All public/protected methods should be fully defined with Javadoc
  - \footnotesize If a method is overridden use `@Override` to indicate that the Javadoc is inherited
* \small Use the standard style for javadoc comment

  \footnotesize
  ```java
  /**
   * Standard comment
   */
  ```

* \small Use "this" to refer to an instance of the class
* \small Aim for short single line sentences

# JavaDoc Standards

* \small Do not use `@code` for `null`, `true`, or `false`
* \small Use `@param` for generics
* \small Use one blank line before `@param`
* \small Treat `@param` and `@return` as a phrase
* \small Treat `@throws` as an if clause
* \small `@param` should have two spaces after param name

# JavaDoc Standards

* \small Define null-handling for all parameters and return types
* \small Include implementation notes [Example](https://github.com/ThreeTen/threeten/blob/0b071a60997f409e44b9bbccde013b004f24fe22/src/main/java/javax/time/Clock.java#L74)
* \small Use a single `<p>` tag between paragraphs
* \small Use a single `<li>` tag for items in a list

# JavaDoc Best Practices

\small The following are several tips/best practices for documenting your code with JavaDoc

1. \footnotesize Use `@link` and `@linkplain` for point to some code
2. \footnotesize Use `@code` for Code Snippets
3. \footnotesize Use `@value` to insert the value of a field in the documentation
4. \footnotesize Indicate when features have been available with `@since`
5. \footnotesize Don't be anonymous, use `@author`
6. \footnotesize For non-void methods, always use `@return`
7. \footnotesize Clarify what parameters mean with `@param`
8. \footnotesize Use `DocCheck` to your advantage

# Generating JavaDoc

* \small You can utilize Gradle to automate generating JavaDoc

* \small This is part of the `java` plugin

::: columns
:::: column

* \small In your build file add the following (assuming standard directory structure)

\small \textcolor{Roarange}{\textbf{build.gradle}}

\scriptsize
```java
plugins {
  id 'java' // not needed if application
}

javadoc {
  source = sourceSets.main.allJava
}
```

::::
:::: column

* \small Generate using the following command

\footnotesize

```shell
$ gradle javadoc
```

* \small This will produce the JavaDoc in the following location

  \footnotesize
  `project-root/build/docs/javadoc`

::::
:::

# GitHub Pages

::: columns
:::: column

* \footnotesize GitHub provides the capability of adding a static site to a project or organization in order to allow you to have a landing page to showcase what you have done.
* \footnotesize These pages use markdown and jekyll to generate html.
* \footnotesize You can configure your project (in the settings) to utilize the `docs/` folder to serve these pages.
* \footnotesize Thus, if you provided an index with a link to `javadoc/index.html` you could copy your generated javadoc to this location as part of the build.
* \footnotesize With this in place you could then provide api documentation automatically.

::::
:::: column

\small \textcolor{Roarange}{\textbf{build.gradle}}

\footnotesize

```java
javadoc {
   source = sourceSets.main.allJava
   destinationDir = file("${rootDir}/docs/javadoc")
}
```

::::
:::

#

\centering
\vfill
\begin{minipage}{.55\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Licensing Your Code
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# Licensing your Code

* \small Programming and software development are an exercise in creativity.
* \small As such, they are a form of property known as Intellectual Property.
* \small Thus, it needs protection
* \small Code can be protected under copyright law.
* \small In addition to copyright, you should protect your code and yourself by stating the terms of use via a license.
* \small All companies license their software under either a conventional closed source or an open source license.
  - \footnotesize The latter, allows for the users to not only have free use of the software, but also rights to use the source code (according to the constraints of the license)
* \small There are many variations of these licenses
  - \footnotesize For open source license information: [https://opensource.org/licenses](https://opensource.org/licenses)

# Licensing your Code

* \small Popular Open Source Licenses are:
  - \footnotesize Apache License 2.0
  - \footnotesize BSD 3-Clause "New" or "Revise" license
  - \footnotesize BSD 2-Clause "Simplified" or "FreeBSD" license
  - \footnotesize GNU General Public License (GPL)
  - \footnotesize GNU Library or "Lesser" General Public License (LGPL)
  - \footnotesize MIT License (my favorite)
  - \footnotesize Mozilla Public License 2.0
  - \footnotesize Common Development and Distribution License
  - \footnotesize Eclipse Public License version 2.0

* \small [choosealicense.com](https://choosealicense.com/) is an extremely helpful site that is designed to help you select an open source license that is right for you.
  - \footnotesize They also note what happens if you choose not to license your code.

# Licensing your Code

* \small Regardless of which license you select, you need to add a `LICENSE` file to the root directory of your project (next to the `README.md` and `CHANGELOG.md` files)
* \small Additionally, it is considered good practice to insert (as a comment) the license header at the top of each of your source code files.
  - \footnotesize As this is a tedious process, there is a gradle plugin that will help you deal with this issue
  - \footnotesize The Gradle License Plugin, which uses your `LICENSE` file and adds its contents to each code file in your project.

\small \textcolor{Roarange}{\textbf{build.gradle}}

\footnotesize
```java
    plugins {
        id "com.github.hierynomus.license-base" version "0.16.1"
    }

    license {
        header = project.file('LICENSE')
    }
```

# License Plugin

* \small This adds several tasks to the build lifecycle
  * \footnotesize `licenseMain(LicenseCheck)`: checks header consistency in the main source set
  * \footnotesize `licenseFormatMain(LicenseFormat)`: applies the license found in the header file i	n files missing the header
  * \footnotesize `licenseTest(LicenseCheck)`: checks header consistency in the test source set
  * \footnotesize `licenseFormatTest(LicenseFormat)`: applies the license found in the header file in files missing the header in the test source set

* \small The `licenseCheck` tasks are executed during the build process in the `check` phase
  - \footnotesize will fail the build if it detects files that are not consistent or missing the header
* \small You can run the format using the following command:

  \footnotesize

  ```shell
  $ gradle licenseFormat
  ```

  from the root directory of your project

# Resources

* \small [JSON](https://www.json.org/json-en.html)
* \small [Gson User Guide](https://github.com/google/gson/blob/master/UserGuide.md)

# For Next Time

::: columns
:::: column
* Review Chapter 4.6
* Review the Gson Tutorial
* Review the JavaDoc Tutorial
* Review this Lecture
* Come to class
* Read Getting Started with JavaFX
* Read the JavaFX Tutorial
* Continue working on Homework 03
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
