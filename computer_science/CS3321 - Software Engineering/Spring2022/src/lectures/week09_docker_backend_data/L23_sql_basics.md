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

# Storing Data

* It is inevitable that we will need to persist data between executions of our application

\vskip1em

* In 2263, we utilized a naive approach for doing this via JSON and Serialization

\vskip1em

* However, often we need something far more robust...

# Outcomes

After today's lecture you will be able to:

::: columns
:::: {.column width=.7}
* Identify different Database Management Systems
* Transform a basic UML Class Diagram into a database schema and tables
* Utilize fundamental knowledge of SQL Data Definition Language to construct both
  - Database schema
  - Database tables
* Utilize fundamental knowledge of SQL Data Manipulation Language to
  - Inserting, Updating, and Deleting Data
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
\Huge DBMS
}
\vskip-.5em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 3321}
\end{minipage}

# DBMS

* \small Database Management System (DBMS) -- provide a system for optimally storing and retrieving data.

\vskip.5em

* \small There are essentially three main types:
  * \footnotesize \textcolor{Roarange}{\textbf{Relational}} -- MySQL, MariaDB, Postgres, SQLite, RDS, and many others
  * \footnotesize Non-Relational (i.e., No-SQL) -- Amazon DynamoDB, MongoDB, Big Table
  * \footnotesize Others Databases
    - \scriptsize Graph Databases
    - \scriptsize Time Series Data Stores
    - \scriptsize Object Data Stores

#

\centering
\vfill
\begin{minipage}{.375\textwidth}
{
\includegraphics[width=13pt]{images/mark.png}
\Huge SQL
}
\vskip-.5em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 3321}
\end{minipage}

# SQL

* \small SQL is a data manipulation language

\vskip.5em

* \small SQL is not a programming language

\vskip.5em

* \small SQL commands are interpreted by the DBMS engine

\vskip.5em

* \small SQL commands can be used interactively as a query language with in the DBMS

\vskip.5em

* \small SQL commands can be embedded within programming languages

# 3 Types of SQL Commands

* \small \textcolor{Roarange}{\textbf{Data Definition Language (DDL):}}
  - \footnotesize Commands that define a database - `Create`, `Alter`, `Drop`

\vskip.5em

* \small \textcolor{Roarange}{\textbf{Data Manipulation Language (DML):}}
  - \footnotesize Commands that maintain and query a database

\vskip.5em

* \small Data Control Language (DCL)
  - \footnotesize Commands that control a database, including administering privileges and committing data.

#

\centering
\vfill
\begin{minipage}{.665\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Data Definition Language
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 3321}
\end{minipage}

# Some SQL Data Types

\textcolor{Roarange}{\textbf{MySQL and MS SQL Server}}

* \small String types:
  - \footnotesize `CHAR(n)` -- fixed-length character data, `n` characters long, max length is 255 characters
  - \footnotesize `VARCHAR(n)` -- variable length character data, max length is 65535 characters
  - \footnotesize `TEXT(n)` -- String data with max size of 65,535 bytes
  - \footnotesize `LONGTEXT` -- String data with a max size of 4,294967,295 characters

* \small Numeric Types
  - \footnotesize `BOOL` or `BOOLEAN` -- Zero is false, all other values are true
  - \footnotesize `INT(n)` or `INTEGER(n)` -- A medium sized integer
  - \footnotesize `FLOAT(p)` -- decimal integer with `p` numbers after the decimal point

* \small Date/Time Type:
  - \footnotesize `DATE` -- fixed-length date/time in YYYY-MM-DD format

# Some SQL Data Types

\textcolor{Roarange}{\textbf{SQLite}}

* \small String types:
  - \footnotesize `TEXT` -- stores string data
  - \footnotesize `BLOB` -- stores other data

* \small Numeric types:
  - \footnotesize `INTEGER` -- stores signed integer data
  - \footnotesize `REAL` -- stores floating point data

* \small Others
  - \footnotesize There is no specific datatype for \textcolor{Roarange}{\textbf{boolean}} or \textcolor{Roarange}{\textbf{dates}}
  - \footnotesize Booleans are typical stored as `INTEGER`
  - \footnotesize Dates can be stored as `INTEGER`, `REAL`, or `TEXT` values

# SQL Database Definition

* \small Data Definition Languae (DDL)

\vskip.5em

* \small Major `CREATE` statements:
  - \footnotesize `CREATE SCHEMA` -- defines a portion of the database owned by a particular user
  - \footnotesize `CREATE TABLE` -- defines a table and its columns
  - \footnotesize `CREATE VIEW` -- defines a logical table from one or more views

\vskip.5em

* \small `ALTER` statements

# Table Creation

::: columns
:::: column

\textcolor{Roarange}{\textbf{General Syntax}}

\scriptsize

```
CREATE TABLE tablename (
  {column definition [table constraint]},
);
```

Where column definitions:

```
column_name datatype[(size)] [column_constraint]
       [default value] [collate clause]
```

And table constraints:

```
[CONSTRAINT constraint_name] Constraint_type
       [constraint_attrs]
```

::::
:::: column

\textcolor{Roarange}{\textbf{Steps in table creation:}}

1. \small Identify data types for attributes
2. \small Identify columns that can and cannot be null
3. \small Identify columns that must be unique (candidate keys)
4. \small Identify primary key-foreign key mates
5. \small Determine default values
6. \small Identify constraints on columns (domain specifications)
7. \small Create the table and associated indexes

::::
:::

# Modeling Databases

* \small There are several methods to model a database
  - \footnotesize ER Diagrams
  - \footnotesize EER Diagrams
  - \footnotesize \textcolor{Roarange}{\textbf{UML Class Diagrams}}

\vskip1em

* \small Given that we are discussing the backend data of a software system and later we will
  be working with ORM, we will use \textcolor{Roarange}{\textbf{UML Class Diagrams}}
  - \footnotesize Each class is a table, and each object stored is a row
  - \footnotesize Fields represent columns of the table
  - \footnotesize Operations, do not have a place here
  - \footnotesize \textcolor{Buttons}{\textbf{Note:} be careful concerning circular dependencies}

# Example Model

\vspace{-1em}
\begin{center}
\includegraphics[width=.7\textwidth]{images/sql/model.eps}
\end{center}

# Customer Table

\scriptsize

\textcolor{Roarange}{\textbf{SQLite}}

```sql
CREATE TABLE customers (
  customer_id       INTEGER NOT NULL PRIMARY KEY AutoIncrement,
  customer_name     VARCHAR NOT NULL,
  customer_address  VARCHAR,
  city              VARCHAR,
  state             VARCHAR,
  postal_code       VARCHAR
);
```

\textcolor{Roarange}{\textbf{MySQL}}

```sql
CREATE TABLE customers (
  customer_id       INTEGER NOT NULL PRIMARY KEY Auto_Increment,
  customer_name     VARCHAR(25) NOT NULL,
  customer_address  VARCHAR(30),
  city              VARCHAR(20),
  state             VARCHAR(2),
  postal_code       VARCHAR(9)
);
```

# Order Table

\scriptsize

\textcolor{Roarange}{\textbf{SQLite}}

```sql
CREATE TABLE orders (
  order_id     INTEGER NOT NULL PRIMARY KEY AutoIncrement,
  order_date   NUMERIC NOT NULL,
  customer_id  INTEGER REFERENCES customers (customer_id)
);
```

\textcolor{Roarange}{\textbf{MySQL}}

```sql
CREATE TABLE orders (
  order_id     INTEGER NOT NULL PRIMARY KEY Auto_Increment,
  order_date   DATETIME NOT NULL,
  customer_id  INTEGER REFERENCES customers (customer_id)
);
```

# Product Table

\scriptsize

\textcolor{Roarange}{\textbf{SQLite}}

```sql
CREATE TABLE products (
  product_id           INTEGER NOT NULL PRIMARY KEY AutoIncrement,
  product_description  VARCHAR,
  product_finish       VARCHAR,
  standard_price       REAL,
  product_line_id      INTEGER
);
```

\textcolor{Roarange}{\textbf{MySQL}}

```sql
CREATE TABLE products (
  product_id           INTEGER NOT NULL PRIMARY KEY Auto_Increment,
  product_description  VARCHAR(50),
  product_finish       VARCHAR(20),
  standard_price       DECIMAL(6,2),
  product_line_id      INTEGER
);
```

# OrderLine Table

\scriptsize

\textcolor{Roarange}{\textbf{SQLite}}

```sql
CREATE TABLE order_lines (
  order_id          INTEGER NOT NULL REFERENCES orders (order_id),
  product_id        INTEGER NOT NULL REFERENCES products (product_id),
  ordered_quantity  INTEGER,
  CONSTRAINT ORDER_LINE_PK PRIMARY KEY (order_id, product_id)
);
```

\textcolor{Roarange}{\textbf{MySQL}}

```sql
CREATE TABLE order_lines (
  order_id          INTEGER NOT NULL REFERENCES orders (order_id),
  product_id        INTEGER NOT NULL REFERENCES products (product_id),
  ordered_quantity  INTEGER,
  CONSTRAINT ORDER_LINE_PK PRIMARY KEY (order_id, product_id)
);
```

# Changing and Removing Tables

* \small `ALTER TABLE` statement allows you to change column specifications:

  \footnotesize

  ```sql
  ALTER TABLE customers ADD (TYPE VARCHAR(2));
  ```

\vskip1em

* \small `DROP TABLE` statement allows you to remove tables from your schema:

  \footnotesize

  ```sql
  DROP TABLE customers;
  ```

# Schema Definition

* \small Control processing/storage efficiency
  - \footnotesize Choice of indexes
  - \footnotesize File organizations for base tables
  - \footnotesize File organizations for indexes
  - \footnotesize Data clustering
  - \footnotesize Statistics maintenance

* \small Creating indexes
  - \footnotesize Speed up random/sequential access to base table data
  - \footnotesize Example

#

\centering
\vfill
\begin{minipage}{.75\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Data Manipulation Language
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 3321}
\end{minipage}

# Data Manipulation Language (DML)

\textcolor{Roarange}{\textbf{Four Basic Commands:}}

* \small `INSERT`
* \small `UPDATE`
* \small `DELETE`
* \small `SELECT`

# Inserting Data

::: columns
:::: column

* \small Puts \textcolor{Roarange}{\textbf{ONE}} row into a table

\vskip.5em

* \small Column list is optional if you plan to insert a value into every column and in the same order as the table

\vskip.5em

* \small If you wish to change the order of data, the column list is needed
  - \footnotesize value list must match
  - \footnotesize you can use `NULL` or blank values

\vskip.5em

* \small Columns left out, will have a value of `NULL`
  - \footnotesize only if the column is able to be `NULL`

::::
:::: column

\scriptsize

\textcolor{Roarange}{\textbf{Syntax:}}

```sql
INSERT INTO tablename (column-list)
VALUES (value-list);
```

\textcolor{Roarange}{\textbf{Example:}}

```sql
INSERT INTO course (course_code, course_name,
  credit_hours)
VALUES ('MIS499', 'ADVANCED ORACLE', 4);
```

::::
:::

# Deleting Data

* \small Removes rows from a table

\vskip1em

* \small Delete certain rows:

  \footnotesize

  ```sql
  DELETE FROM customer_t WHERE
  STATE = 'HI';
  ```

\vskip1em

* \small Delete all rows

  \footnotesize

  ```sql
  DELETE FROM customer_t;
  ```

# Updating Data

* \small Modifies data in existing rows

  \footnotesize

  ```sql
  UPDATE product_t SET unit_price =
  775 WHERE product_id = 7;
  ```

# Retrieving Data

* \small We use the \textcolor{Roarange}{\texttt{SELECT}} statement for queries on a single or multiple tables

\vskip.5em

* \small Clauses of the \textcolor{Roarange}{\texttt{SELECT}} statement:
  - \footnotesize \textcolor{Roarange}{\texttt{SELECT}} -- List the columns (and expressions) that should be returned from the query
  - \footnotesize \textcolor{Roarange}{\texttt{FROM}} -- Indicates the table(s) or view(s) from which data will be obtained
  - \footnotesize \textcolor{Roarange}{\texttt{WHERE}} -- Indicate the conditions under which a row will be included in the result
  - \footnotesize \textcolor{Roarange}{\texttt{GROUP BY}} -- Indicate categorization of results
  - \footnotesize \textcolor{Roarange}{\texttt{HAVING}} -- Indicate the conditions under which a category (group) will be included
  - \footnotesize \textcolor{Roarange}{\texttt{ORDER BY}} -- Sorts the result according to specified criteria

# Query Processing

\vfill
\begin{center}
\includegraphics[width=.8\textwidth]{images/sql/processing.eps}
\end{center}

# `SELECT` Example

* \small Find products with standard price less than \$275

  \footnotesize

  ```sql
  SELECT product_name, standard_price
  FROM products
  WHERE standard_price < 275;
  ```

\vskip1em

* \small Aliases allow for alternative column or table names

  \footnotesize

  ```sql
  SELECT cust.customer as NAME,
    cust.customer_address
  FROM customers cust
  WHERE name = 'Home Furnishings';
  ```

# Counting Rows

* \small You can use the `COUNT` \textcolor{Roarange}{\textbf{aggregate function}} to find totals

  \footnotesize

  ```sql
  SELECT count(*) FROM order_lines
  WHERE order_id = 1004;
  ```

\vskip1em

* \small \textcolor{Buttons}{\textbf{Note:} with aggregate functions you can't have single-valued columns included in the select clause}

# Boolean Operators

* \small `AND`, `OR`, and `NOT` operators can be used to customize conditions in a `WHERE` clause

  \footnotesize

  ```sql
  SELECT product_description, product_finish,
    standard_price
  FROM products
  WHERE (product_description LIKE '%Desk'
  OR product_description LIKE '%Table')
  AND unit_price > 300;
  ```

# Order By

* \small Example: Sort the results first by STATE, and within a state by CUSTOMER_NAME

  \footnotesize

  ```sql
  SELECT customer_name, city, state
  FROM customers
  WHERE state IN ('FL', 'TX', 'CA', 'HI')
  ORDER BY state, customer_name;
  ```

# Group By

* \small Group by is for use with aggregate functions
  - \footnotesize \textcolor{Roarange}{\textbf{Scalar aggregate:}} single value returned from SQL query with aggregate function
  - \footnotesize \textcolor{Roarange}{\textbf{Vector aggregate:}} multiple values returned from SQL query with aggregate function (via `GROUP BY`)

  \footnotesize

  ```sql
  SELECT state, count(state)
  FROM customers
  GROUP BY state;
  ```

* \small \textcolor{Buttons}{\textbf{Note:} you can use single-value fields with aggregate functions if they are included in the \texttt{GROUP BY} clause}

# The `HAVING` Clause

* \small We can qualify results by categories using the `HAVING` clause when using `GROUP BY`

  \scriptsize

  ```sql
  SELECT state, count(state)
  FROM customers
  GROUP BY state
  HAVING count(state) > 1;
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
