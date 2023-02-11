---
author:
- Isaac Griffith
title: SQL Injection and XSS
institute: |
  CS 2263

  Department of Informatics and Computer Science

  Idaho State University
fontsize: 11pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Outcomes

After today's lecture you will be able to:

* Describe, execute, and defend against a SQL Injection attack
* Describe, execute, and defend against a Cross Site Scripting attack

# Inspiration

> "Up to a point, it is better to just let the snags [bugs] be there than to spend such time in design that there are none." -- Alan M. Turing

#

\vfill
\centering
\Huge SQL Injection

# SQL Language

* Widely used database query language
* Fetch a set of records
```sql
SELECT * FROM Accounts WHERE Username='Alice'
```
* Add data to the table
```sql
INSERT INTO Accounts(Username, Password) VALUES ('Alice', 'helloworld')
```
* Modify data
```sql
UPDATE Accounts SET Password='hello' WHERE Username='Alice'
```
* Query syntax (mostly) independent of vendor

# Example Web App

::: columns
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Defensive/sqlinject1.eps}
\end{center}
::::
:::: column
\vskip1.5em
**Constructing SQL Query from User Input**

```js
$result = mysql_query(
  "SELECT * FROM Accounts".
  "WHERE Username = '$username'".
  "AND Password = '$password';");
if (mysql_num_rows($result) > 0)
  $login = true;
```

\vskip1em
**Resulting SQL Query**

```sql
SELECT * FROM Accounts
WHERE Username = 'gtan'
AND Password = 'geheim';
```
::::
:::

# SQL Injection Example

::: columns
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Defensive/sqlinject2.eps}
\end{center}
::::
:::: column
\vskip1.5em
**Resulting SQL Query**

```sql
SELECT * FROM Accounts
WHERE Username = '' OR 1=1;/*'
AND Password = 'geheim';
```

\large OOPS!
::::
:::

# SQL Injection Example

::: columns
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Defensive/sqlinject3.eps}
\end{center}
::::
:::: column
\vskip1.5em
**Resulting SQL Query**

```sql
SELECT * FROM Accounts
WHERE Username = '';
drop TABLES Accounts;
/*'AND Password = 'geheim';
```

\large OOPS!
::::
:::

# Exploits of a Mom

\begin{center}
\includegraphics[width=.95\textwidth]{images/Defensive/exploits_of_a_mom.png}
\end{center}

\centering

[http://xkcd.com/327/](http://xkcd.com/327/)

# SQL Injection

* Vulnerability: any application in any programming language that connects to a SQL database
* Typical books such as "PHP & MySQL for Dummies" contain examples with security vulnerabilities!
* Note the common theme to many injection attacks: \color{Roarange} concatenating strings\color{black}, some of them user input, and then \color{Roarange}\textit{\underline{interpreting}} the result

# Examples of Real SQL Injection Attacks

* Oklahoma Department of Corrections divulges thousands of social security numbers (2008)
  - Sexual and Violent Offender Registry for Oklahoma
  - Data repository lists both offenders and employees

# CardSystems Attack (June 2005)

* CardSystems was a major credit card processing company
* Put out of business by a SQL injection attack
  - Credit card numbers stored unencrypted
  - Data on 263,000 accounts stolen
  * 43 million identities exposed

# Preventing SQL Injection

* Input validation
  - Filtering input: apostrophes, semicolons, percent symbols, hyphens, underscores, ...
    - Any character that has special meanings
  - Check the data type (e.g., make sure it's an integer)
* **Whitelisting** what's allowed
  - Allow only a well-defined set of safe values
  - Better than **blacklisting** "bad" characters
    - May forget to filter out some characters

# "Blacklists" are useful for testing

* Identify some data you should not accept
  - But \textit{\underline{don't}} use this blacklist as your rules
* Instead, use blacklists to *test* your whitelist rules
  - I.e., use (subset of ) a blacklist as test cases
  - to ensure your whitelist rules won't accept them
* In general, regression test should check that "forbidden actions" are actually forbidden
  - E.g., Apple iOS's "goto fail" vulnerability (CVE-2014-1266)
    - Its SSL/TLS implementation accepted valid certificates (good) *and* invalid certificates (bad).
    - No one tested it with invalid certificates!

# Escaping Quotes

* For valid string inputs use escape characters to prevent the quote becoming part of the query
  - Example: escape(o'brien) = o''brien
    - E.g., ANSI SQL mode in MySQL
  - Another example: Convert ' into \'
    - E.g., MySQL mode in MySQL
  - Different databases have different rules for escaping
  - Only works for string inputs

# Prepared Statements

* Metacharacters such as ' in queries provide distinction between data and control
* In most injection attacks \color{Roarange} data are interpreted as control \color{black} -- this changes the semantics of a query or a command
* Bind variables; ? placeholders guaranteed to be data (not control)
* \color{Roarange} Prepared statements \color{black} allow creation of static queries with bind variables. This preserves the structure of intended query.

# Prepared Statement

**Vulnerable**:

```java
String updateString = "SELECT * FROM Account WHERE Username" +
username + " AND Password = " + password;
stmt.executeUpdate(updateString);
```

**Not Vulnerable**:

```java
PreparedStatement login = con.preparedStatement("SELECT *
      FROM Account WHERE Username = ? AND Password = ?");
login.setString(1, username);
login.setString(2, password);
login.executeUpdate();
```

# Mitigating Impact of Attack

* Encrypt sensitive data stored in database
* Limit privileges (defense in depth)
* Harden DB server and host OS

#

\vfill
\centering
\Huge Input Validation: XSS (Cross-Site Scripting)

# Web Application (In)Security

* Increasingly, web applications become obvious targets to attack
* Modern-day web browser
  - More like an OS
  - Allow downloading and installing web-applications, which take untrusted input

# XSS (Cross site scripting)

\vfill
\begin{center}
\includegraphics[width=.75\textwidth]{images/Defensive/xss1.eps}
\end{center}

# XSS (Cross site scripting)

\vfill
\begin{center}
\includegraphics[width=.75\textwidth]{images/Defensive/xss2.eps}
\end{center}

# XSS (Cross site scripting)

* What can happen if we enter more complicated HTML code as search term?

```html
<img = "http://www.sxpam.org/advert.jpg">

<script langauge="javascript">alert('aloha');</script>
```

# XSS (Cross site scripting)

* aka \color{Roarange} HTML injection \color{black}
* Vulnerability:
  \color{Roarange} User input, possible including *executable content* (JavaScript, VBScript, ActiveX, ...) is echoed back in a webpage\color{black}
* But why is this a security problem?

# XSS -- Scenario

1. User A injects HTML into a website,

   (e.g. webforum, book review on `amazon.com`, ...),

   Which is echoed back to User B later

2. this allows website defacement, or tricking User B to follow link to `anotheronlinebookshop.com`

3. *worse still*, B's web browser will execute any javascript included in the injected HTML...

4. This is done in the context of the vulnerable site, i.e., using B's cookies for this site...

[https://www.youtube.com/watch?v=cbmBDiR6WaY](https://www.youtube.com/watch?v=cbmBDiR6WaY)

# Why XSS is a Security Problem?

* The problem is that what attackers inject might be viewed by a victim in the victim's browser
  - The injected code will be run on the vitim's computer
  - With the origin from a trusted web site
* XSS injects malicious scripts into trusted web sites such as a banking web site
* Affects web sites, built using any language or technology, that echoes back user input in a webpage

# XSS

* Countermeasures
  - Input validation
    - Blocking "<script>" is not enough
    - Pseudo-urls, stylesheets, encoded inputs (%3C codes "<"), etc.
    - Hard to do in practice (see Samy Worm)
  - Principle of least privilege
    - Turn off scripting languages, restrict access to cookies, don't store sensitive data in cookies, ...

# MySpace Worm

* Used script injection
* Started on "samy" MySpace page
* Everybody who visits an infected page, becomes infected and adds "samy" as a friend and hero
* 5 hours later "samy" has 1,005,831 friends
  - Was adding 1,000 friens per second at its peak

# More Input Validation Problems

* From servers' point of view, any data form the client cannot be trusted
* Data in web forms, incl. \color{Roarange} hidden form fields\color{black}.

  Hidden form fields, e.g.

  ```html
  <INPUT TYPE=HIDDEN NAME="price" VALUE="50">
  ```

  are not shown in browser, unless you click View -> Page source ..., and may be altered

* Data in cookies
  - cookies, stored at client-side, can be altered
  - Such data always has to be re-validated

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
