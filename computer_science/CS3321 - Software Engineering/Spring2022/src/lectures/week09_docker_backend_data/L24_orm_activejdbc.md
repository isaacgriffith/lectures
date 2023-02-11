---
author:
- Dr. Isaac Griffith
title: SQL Basics
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
outline: false
...

# Outcomes

After today's lecture you will be able to:

::: columns
:::: {.column width=.7}
* Describe the basics of ORM
* Use ActiveJDBC in your daily development
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
{
\includegraphics[width=13pt]{images/mark.png}
\Huge ORM
}
\vskip-.5em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 3321}
\end{minipage}

# What is an ORM?

* \small Object-Relational Mapping (ORM) is a technique to map OO constructs such as classes to tables of a relational database

\vskip.5em

* \small ORM frameworks typically provide an API which allows for the augmenting of existing classes with the necessary capabilities to store and retrieve instances from the DB
  - \footnotesize Typically this is done using features of the underlying language
  - \footnotesize Usually implemented using the \textcolor{Roarange}{\textbf{Data Access Object (DAO) design pattern}

# Advantages and Disadvantages

* \small ORM frameworks reduce the amount of code needed to perform the basic DB operations

\vskip.5em

* \small ORM frameworks also abstract away the details, making understanding the code more difficult (potentially)

\vskip.5em

* \small ORM frameworks are not magic and do not replace good OO design and good Database design
  - \footnotesize When using ORM your database will directly reflect your OO system
  - \footnotesize Garbage In == Garbage Out

#

\centering
\vfill
\begin{minipage}{.375\textwidth}
{
\includegraphics[width=13pt]{images/mark.png}
\Huge ActiveJDBC
}
\vskip-.5em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 3321}
\end{minipage}

# Our Model (again)

\vspace{-1em}
\begin{center}
\includegraphics[width=.7\textwidth]{images/sql/model.eps}
\end{center}

# Customer

::: columns
:::: column

\small \textcolor{Roarange}{\textbf{UML}}

\centering
\includegraphics[width=.95\textwidth]{images/sql/customer.eps}

::::
:::: column

\small \textcolor{Roarange}{\textbf{SQL}} (MySQL)

\tiny

```sql
CREATE TABLE customers (
  id           INTEGER NOT NULL PRIMARY KEY Auto_Increment,
  name         VARCHAR(25) NOT NULL,
  address      VARCHAR(30),
  city         VARCHAR(20),
  state        VARCHAR(2),
  postal_code  VARCHAR(9),
  created_at   DATETIME,
  updated_at   DATETIME
);
```

\small \textcolor{Roarange}{\textbf{Java Code}}

\tiny

```java
public class Customer extends Model {

}
```

::::
:::

# Order

::: columns
:::: column

\small \textcolor{Roarange}{\textbf{UML}}

\centering
\includegraphics[width=.95\textwidth]{images/sql/order.eps}

::::
:::: column

\small \textcolor{Roarange}{\textbf{SQL}} (MySQL)

\tiny
```sql
CREATE TABLE orders (
  id           INTEGER NOT NULL PRIMARY KEY Auto_Increment,
  order_date   DATETIME NOT NULL,
  customer_id  INTEGER REFERENCES customers (id),
  created_at   DATETIME,
  updated_at   DATETIME
);
```

\small \textcolor{Roarange}{\textbf{Java Code}}

\tiny
```java
@BelongsTo(parent = Customer.class,
    foreignKeyName = "customer_id")
public class Order extends Model {

}
```

::::
:::

# Product

::: columns
:::: column

\small \textcolor{Roarange}{\textbf{UML}}

\centering
\includegraphics[width=.95\textwidth]{images/sql/product.eps}

::::
:::: column

\small \textcolor{Roarange}{\textbf{SQL}} (MySQL)

\tiny
```sql
CREATE TABLE products (
  id               INTEGER NOT NULL PRIMARY KEY Auto_Increment,
  description      VARCHAR(50),
  finish           VARCHAR(20),
  price            DECIMAL(6,2),
  product_line_id  INTEGER,
  created_at       DATETIME,
  updated_at       DATETIME
);
```

\small \textcolor{Roarange}{\textbf{Java Code}}

\tiny
```java
@Many2Many(other = Order.class, join = "order_lines",
    sourceFKName = "product_id", targetFKName = "order_id")
public class Product extends Model {

}
```

::::
:::

# OrderLine

::: columns
:::: column

\small \textcolor{Roarange}{\textbf{UML}}
\centering
\includegraphics[width=.95\textwidth]{images/sql/orderline.eps}

::::
:::: column

\small \textcolor{Roarange}{\textbf{SQL}} (MySQL)

\tiny
```sql
CREATE TABLE order_lines (
  id                INTEGER NOT NULL PRIMARY KEY Auto_Increment,
  order_id          INTEGER NOT NULL REFERENCES orders (id),
  product_id        INTEGER NOT NULL REFERENCES products (id),
          quantity  INTEGER,
  created_at        DATETIME,
  updated_at        DATETIME
);
```

\small \textcolor{Roarange}{\textbf{Java Code}}

\tiny
```java
@Table("order_lines")
public class OrderLine extends Model {

}
```

::::
:::

# Connections

* \small The most basic connection is on a single thread and can be opened using the `DB` class:

  \tiny
  ```java
      new DB("default").open("com.mysql.cj.jdbc.Driver", // DB Connection Class
          "jdbc:mysql://localhost/test_db?serverTimezone=America/Denver", // DB URL
          "user", // User Name
          "password"); // password
  ```

  - \footnotesize MySQL Driver: `com.mysql.cj.jdbc.Driver`
  - \footnotesize SQLite Driver: `org.sqlite.JDBC`

\vskip.5em

* \small You need to have an open connection to do any real work with the model classes

\vskip.5em

* \small Once you are done you need to close the connection

  \tiny

  ```java
      new DB("default").close();
  ```

# Creating Instances

* \small You can create a new instance just like any other class, with the `new` operator.
  - \footnotesize You then need to provide the new instance with its data and save it.

  \tiny
  ```java
      Customer bob = new Customer();
      bob.set("name", "Bob Sampson");
      bob.set("address", "123 Some St.");
      bob.set("city", "Pocatello");
      bob.set("state", "ID");
      bob.set("postal_code", "83201");
      bob.saveIt();
  ```

\vskip.5em

* \small You can also do this in a single line with the `createIt` method:

  \tiny
  ```java
      Customer bob = Customer.createIt("name", "Bob Sampson", "address", "123 Some St.",
                              "city", "Pocatello", "state", "ID", "postal_code", "83201");
  ```

\vskip.5em

* \small Additionally, if you believe some record may exist, you could use the
  `findOrCreateIt` method in the same way as `createIt`.
  - \footnotesize This will attempt to find a match given the fields, and if one is found, will
    return that rather than create if, otherwise it creates it.

# Accessing Data

* \small You can access all of the data using a variety of `get` methods.
  - \footnotesize `get("fieldname")` returns an `Object` or throws an error if no such field exists
  - \footnotesize `getString(...)` just like get but for Strings
  - \footnotesize `getInteger(...)`
  - \footnotesize `getDate(...)`
  - \footnotesize and many more

\vskip.5em

* \small Additionally, there are `set` methods which take two parameters
  - \footnotesize First is the name of the field to set
  - \footnotesize Second is the new value of the field
  - \footnotesize \textcolor{Roarange}{\textbf{Remember to save after setting...}}

# Working with Relationships

* \small If there is a relationship between two model objects, we can work with as follows
  - \footnotesize To connect two objects, we simply use the `add(...)` method to add a child to the parent
  - \footnotesize To retrieve a list of children from an object we simply use `getAll(ClassName.class)`
    * \scriptsize Where `ClassName.class` is the class object of the child class

\vskip.5em

* \small If we wish to know what the parent of a model class is we can use the
  - \footnotesize `getParent(ClassName.class)` which retrieve the parent instance for that class type

\vskip.5em

* \small We can also set the parent, though this is typically automatically done for us, using the
  - \footnotesize `setParent(...)` method

# Deleting Instances

* \small Just as we can `save()` an instance to the database, we can also delete one as well.

\vskip.5em

* \small This is done by calling the `delete()` method on the object reference.
  - \footnotesize Only removes it from the database, not from memory
  - \footnotesize Places the object into a `frozen` state, which you can `unfreeze()` the object, and `saveIt` again.

#

\centering
\vfill
\begin{minipage}{.375\textwidth}
{
\includegraphics[width=13pt]{images/mark.png}
\Huge Gradle
}
\vskip-.5em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 3321}
\end{minipage}

# Connecting with Gradle

* \small In order to include activejdbc into your gradle projects, you need to:

  1. \footnotesize Add the activejdbc-gradle-plugin:

     ```groovy
     plugins {
       ...
       id "de.schablinski.activejdbc-gradle-plugin" version "2.0.1"
     }
     ```
  2. \footnotesize Add dependencies (if your model classes use them) to the `activejdbc` configuration

     ```groovy
     dependencies {
       ...
       activejdbc 'org.scala-lang:scala-library:2.12.6'
       ...
     }
     ```

 3. \footnotesize Create your database

# Connecting with Gradle

* \small In order to include activejdbc into your gradle projects, you need to:

  4. \footnotesize Setup your classes
  5. \footnotesize Connect your project to your database
  6. \footnotesize You can then instrument your classes as follows:

     ```bash
     $ gradle instrumentModels
     ```

  7. \footnotesize Test your setup

\vskip.5em

* [https://github.com/cschabl/activejdbc-gradle-plugin](https://github.com/cschabl/activejdbc-gradle-plugin)

# Gradle Database Dependencies

\footnotesize

```groovy
    // SQLite
    implementation 'org.xerial:sqlite-jdbc:3.25.2'

    // MariaDborg.sqlite.JDBC
    implementation 'org.mariadb.jdbc:mariadb-java-client:2.6.0'

    // MySQL
    implementation 'mysql:mysql-connector-java:8.0.20'

    // JavaLite
    implementation "org.javalite:activejdbc:3.0-j11"
    implementation "org.javalite:javalite-common:3.0-j11"
```

# For Next Time

::: columns
:::: column

* Review this Lecture
* Come to Class

::::
:::: column
\centering
\includegraphics[width=.85\textwidth]{images/next_time-invert2.png}
::::
:::

#

\vfill
\centering
\includegraphics[scale=.40]{images/questions-invert2.png}

\Huge \textbf{Are there any questions?}
